package com.proyecto.empresa.controller;

import com.proyecto.empresa.enums.EState;
import com.proyecto.empresa.model.User;
import com.proyecto.empresa.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }else{
            userService.saveUser(user);
            return ResponseEntity.ok("Usuario creado correctamente");
        }
    }

    @GetMapping("/findAllByEmployeeRol")
    public List<User> findAllByEmployeeRol(){
        return userService.findAllByEmployeeRol();
    }

    // Filtros
    @GetMapping("/findAmountOfEmployees")
    public Integer findAmountOfEmployees(){
        return userService.findAmountOfEmployees();
    }

    @GetMapping("/findAmountOfActiveEmployees")
    public Integer findAmountOfActiveEmployees(){
        return userService.findAmountOfActiveEmployees();
    }

    @GetMapping("/findAmountOfInactiveEmployees")
    public Integer findAmountOfInactiveEmployees(){
        return userService.findAmountOfInactiveEmployees();
    }

    @GetMapping("/findAmountOfEmployeesByDates")
    public Integer findAmountOfEmployeesByDates(@RequestParam("date") String date) throws ParseException {
        return userService.findAmountOfEmployeesByDates(date);
    }

    @GetMapping("/findAmountOfEmployeesByName/{name}")
    public Integer findAmountOfEmployeesByName(@PathVariable String name){
        return userService.findAmountOfEmployeesByName(name);
    }

    @GetMapping("/findAmountOfUsersAndAreasByState/{state}")
    public Integer findAmountOfUsersAndAreasByState(@PathVariable Integer state){
        return userService.findAmountOfUsersAndAreasByState(state);
    }

    @GetMapping("/findAmountOfUsersBySalary/{salary}")
    public Integer findAmountOfUsersBySalary(@PathVariable Double salary){
        return userService.findAmountOfUsersBySalary(salary);
    }

    @GetMapping("/findAmountOfUsersByAge/{age}")
    public Integer findAmountOfUsersByAge(@PathVariable Integer age){
        return userService.findAmountOfUsersByAge(age);
    }

    @GetMapping("/findAmountOfUsersByNumberDocument/{numberDocument}")
    public Integer findAmountOfUsersByNumberDocument(@PathVariable Integer numberDocument){
        return userService.findAmountOfUsersByNumberDocument(numberDocument);
    }




}
