package com.proyecto.empresa.controller;

import com.proyecto.empresa.enums.ERole;
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

    @PutMapping("/updateUser/{idUser}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user,@PathVariable Integer idUser, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }else{
            userService.updateUser(user, idUser);
            return ResponseEntity.ok("Usuario actualizado correctamente");
        }
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> listUser = userService.findAll();
        return listUser;
    }

    @GetMapping("/findAllByEmployeeRol")
    public List<User> findAllByEmployeeRol(){
        List<User> listEmployee = userService.findAllByEmployeeRol();
        return listEmployee;
    }

    // Filtros
    @GetMapping("/findAmountOfEmployees")
    public Integer findAmountOfEmployees(){
        Integer amountEmployees = userService.findAmountOfEmployees();
        return amountEmployees;
    }

    @GetMapping("/findAmountOfActiveEmployees")
    public Integer findAmountOfActiveEmployees(){
        Integer amountActiveEmployees = userService.findAmountOfActiveEmployees();
        return amountActiveEmployees;
    }

    @GetMapping("/findAmountOfInactiveEmployees")
    public Integer findAmountOfInactiveEmployees(){
        Integer amountInactiveEmployees =  userService.findAmountOfInactiveEmployees();
        return amountInactiveEmployees;
    }

    @GetMapping("/findAmountOfEmployeesByDates")
    public Integer findAmountOfEmployeesByDates(@RequestParam("date") String date) throws ParseException {
        Integer amountEmployeesByDate = userService.findAmountOfEmployeesByDates(date);
        return amountEmployeesByDate;
    }

    @GetMapping("/findAmountOfEmployeesByName/{name}")
    public Integer findAmountOfEmployeesByName(@PathVariable String name){
        Integer amountEmployeesByName = userService.findAmountOfEmployeesByName(name);
        return amountEmployeesByName;
    }

    @GetMapping("/findAmountOfUsersAndAreasByState/{state}")
    public Integer findAmountOfUsersAndAreasByState(@PathVariable Integer state){
        Integer amountEmployeesByState = userService.findAmountOfUsersAndAreasByState(state);
        return amountEmployeesByState;
    }

    @GetMapping("/findAmountOfUsersBySalary/{salary}")
    public Integer findAmountOfUsersBySalary(@PathVariable Double salary){
        Integer amountEmployeesBySalary = userService.findAmountOfUsersBySalary(salary);
        return amountEmployeesBySalary;
    }

    @GetMapping("/findAmountOfUsersByAge/{age}")
    public Integer findAmountOfUsersByAge(@PathVariable Integer age){
        Integer amountEmployeesByAge = userService.findAmountOfUsersByAge(age);;
        return amountEmployeesByAge;
    }

    @GetMapping("/findAmountOfUsersByNumberDocument/{numberDocument}")
    public Integer findAmountOfUsersByNumberDocument(@PathVariable Integer numberDocument){
        Integer amountEmployeesByNumberDocument = userService.findAmountOfUsersByNumberDocument(numberDocument);
        return amountEmployeesByNumberDocument;
    }




}
