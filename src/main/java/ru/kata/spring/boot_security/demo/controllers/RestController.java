package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/admin")
public class RestController {

    private final UserService userService;
    private final RoleService roleService;


    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsersList() {
        System.out.println("Приложение начало работу метода getUsersList");
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Приложение начало работу метода getUser");
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        System.out.println("Приложение начало работу метода createUser");
        userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        System.out.println("Приложение начало работу метода deleteUser");
        userService.deleteById(id);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        System.out.println("Приложение начало работу метода saveUser");
        userService.saveUser(user);
    }
}