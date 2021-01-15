package com.example.proiectfinal.Service;

import com.example.proiectfinal.Model.User;
import com.example.proiectfinal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    //private final RecipieRepository recipieRepository;



    public UserService(UserRepository userRepository/*, RecipieRepository recipieRepository*/) {
        this.userRepository = userRepository;
        //this.recipieRepository = recipieRepository;
    }


    /*public User save(List <Recipie> recipies, List<IngredientRecipie> ingredient) {
        List<Recipie> itemsToBeAdd = recipies.stream()
                .map(
                        itemOrdered -> {
                            Recipie recipie = new Recipie();
                            var p = recipieRepository.getRecipieByName(itemOrdered.getName());
                            if (!p.isEmpty()) {
                                recipie.setId(itemOrdered.getId());
                                recipie.setName(itemOrdered.getName());
                                recipie.setCreateDate(itemOrdered.getCreateDate());
                            } else {
                                throw new NoRecipieFoundException();
                            }
                            return recipie;
                        }
                ).collect(Collectors.toList());

        if (recipies.size() != itemsToBeAdd.size()) {
            throw new NoIngredientFoundException();
        }

        User user = new User();

        long userId = userRepository.save(user);


        itemsToBeAdd.forEach(recipie -> {
                    recipieRepository.save(recipie);
                }
        );

        user.setId((int) userId);
        //return userMapper.toDtoUser(user, itemsToBeAdd);

        return user;
    }*/


    public void save(User user){
        userRepository.save(user);
    }

    /*@Transactional
    //se foloseste in principiu pe serviciu
    //o tranzactie reprezinta (fietoate,fieniciuna,seface rollback),consistenta, variabilitate,conservare
    public UserDto saveUser(List<User> users) {
        //pentru fiecare ingredient il add in BD
        users.forEach(user -> userRepository.save(user));
        return recipieMapper.recipieDto()
    }*/
}
