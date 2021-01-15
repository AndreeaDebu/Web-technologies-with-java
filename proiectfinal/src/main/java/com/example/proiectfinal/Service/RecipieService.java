package com.example.proiectfinal.Service;

import com.example.proiectfinal.Model.IngredientRecipie;
import com.example.proiectfinal.Model.Recipie;
import com.example.proiectfinal.Repository.IngredientRecipieRepository;
import com.example.proiectfinal.Repository.IngredientRepository;
import com.example.proiectfinal.Repository.RecipieRepository;
import com.example.proiectfinal.dto.RecipieDto;
import com.example.proiectfinal.exception.NoIngredientFoundException;
import com.example.proiectfinal.exception.NoStockAvailableException;
import com.example.proiectfinal.mapper.RecipieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipieService {

    @Autowired
    private RecipieMapper recipieMapper;

    private final RecipieRepository recipieRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientRecipieRepository ingredientRecipieRepository;

    public RecipieService(RecipieRepository recipieRepository, IngredientRepository ingredientRepository, IngredientRecipieRepository ingredientRecipieRepository) {
        this.recipieRepository = recipieRepository;
        this.ingredientRepository = ingredientRepository;
        this.ingredientRecipieRepository = ingredientRecipieRepository;
    }


    @Transactional
    public RecipieDto save(List<IngredientRecipie> ingredientRecipies, String recipieName) {
        List<IngredientRecipie> itemsToBeAdd = ingredientRecipies.stream()
                .map(
                        itemOrdered -> {
                            IngredientRecipie ingredient = new IngredientRecipie();
                            var p = ingredientRepository.getIngredientByName(itemOrdered.getIngredient().getNameIngredient());
                            if (!p.isEmpty()) {
                                ingredient.setIngredient(p.get());
                                ingredient.setQuantity(itemOrdered.getQuantity());
                                if (itemOrdered.getQuantity() < 0) {
                                    throw new NoStockAvailableException();
                                }
                            } else {
                                throw new NoIngredientFoundException();
                            }
                            return ingredient;
                        }
                ).collect(Collectors.toList());

        if (ingredientRecipies.size() != itemsToBeAdd.size()) {
            throw new NoIngredientFoundException();
        }

        Recipie recipie = new Recipie();
        recipie.setName(recipieName);
        LocalDate date = LocalDate.now();
        recipie.setCreateDate(date.toString());


        long recipieId = recipieRepository.save(recipie);

        itemsToBeAdd.forEach(recipie1 -> {
                    ingredientRecipieRepository.save(recipie1, (int) recipieId);
                }
        );

        recipie.setId((int) recipieId);
        return recipieMapper.recipieDto(recipie, itemsToBeAdd);



}


    /*public List<String> recipie (String username, List<String> ingredients ) {
        //verificam ca exista userul cu usernameul dat
        //daca nu il gasim, aruncam o exceptie care poate fi handle-uita de controller dupa
        User user = userRepository.getByUsername(username).orElseThrow(NoSuchElementException::new);

        //verificam ca toate produsele din comanda exista
        //intr-o lista vom tine numele produselor negasite
        List<String> ingredinetNO = new ArrayList<>();

        //in alta lista produsele Product gasite pe baza denumirii produselor din comanda
        List<Ingredient> ingredientsFound = new ArrayList<>();
        ingredients.forEach(ingredientName -> ingredientRepository.get(ingredientName).ifPresentOrElse(
                //ifPresent, produsul a fost gasit si este adaugat in lista de produse gasite
                ingredient -> ingredientsFound.add(ingredient),
                //else, produsul nu a fost gasit si este adaugat in lista cu denumirile produselor negasite
                () -> ingredinetNO.add(ingredientName)
        ));



        //toate produsele au fost gasite, putem efectua comanda
        //creeam comanda si o salvam pe user
        Recipie recipie = new Recipie(user, ingredientsFound);
        user.addOrder(recipie);

        //returnam o lista goala pt controller (sau productsNotFound; care in acest punct e tot goala)
        //ca acesta sa stie ca operatia a decurs ok
        return Collections.emptyList();
    }*/
}
