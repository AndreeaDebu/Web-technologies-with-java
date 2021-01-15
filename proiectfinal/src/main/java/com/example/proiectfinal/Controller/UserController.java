package com.example.proiectfinal.Controller;

import com.example.proiectfinal.Model.User;
import com.example.proiectfinal.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody  User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok("User saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*@PostMapping("/add")
    public ResponseEntity addUser(@RequestBody List<IngredientRecipie> ingredientRecipies, @RequestParam String name ) {
        userService.save(users);
    }*/
}
