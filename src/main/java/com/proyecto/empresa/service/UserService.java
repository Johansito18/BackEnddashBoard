package com.proyecto.empresa.service;

import com.proyecto.empresa.enums.ERole;
import com.proyecto.empresa.model.User;
import com.proyecto.empresa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        try {
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateUser(User user, Integer idUser){
        try {
            User user1 = userRepository.findByIdUser(idUser);
            if (user1.getIdUser().equals(user.getIdUser())){

                user1.setName(user.getName());
                user1.setLastName(user.getLastName());
                user1.setBirthDate(user.getBirthDate());
                user1.setEmail(user.getEmail());
                user1.setPassword(user.getPassword());
                user1.setSalary(user.getSalary());
                user1.setPosition(user.getPosition());
                user1.setRoles(user.getRoles());
                user1.setState(user.getState());
            }
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<User> findAll(){
        List<User> listUser = userRepository.findAll();
        return listUser;
    }

    public List<User> findAllByEmployeeRol(){
        List<User> listEmployee = userRepository.findAllByRoles(ERole.EMPLOYED);
        return listEmployee;
    }

    public Integer findAmountOfEmployees(){
        Integer amountEmployees = userRepository.findAmountOfEmployees();
        return amountEmployees;
    }

    public Integer findAmountOfActiveEmployees(){
        Integer amountActiveEmployees = userRepository.findAmountOfActiveEmployees();
        return amountActiveEmployees;
    }

    public Integer findAmountOfInactiveEmployees(){
        Integer amountInactiveEmployees =  userRepository.findAmountOfInactiveEmployees();
        return amountInactiveEmployees;
    }

    public Integer findAmountOfEmployeesByDates(String date) throws ParseException {
        String date1 = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        Integer amountEmployeesByDate = userRepository.findAmountOfEmployeesByDates(date1);
        return amountEmployeesByDate;
    }

    public Integer findAmountOfEmployeesByName(String name){
        Integer amountEmployeesByName = userRepository.findAmountOfEmployeesByName(name);
        return amountEmployeesByName;
    }

    public Integer findAmountOfUsersAndAreasByState(Integer state){
        Integer amountEmployeesByState = userRepository.findAmountOfUsersAndAreasByState(state);
        return amountEmployeesByState;
    }

    public Integer findAmountOfUsersBySalary(Double salary){
        Integer amountEmployeesBySalary = userRepository.findAmountOfUsersBySalary(salary);
        return amountEmployeesBySalary;
    }

    public Integer findAmountOfUsersByAge(Integer age){
        Integer amountEmployeesByAge = userRepository.findAmountOfUsersByAge(age);;
        return amountEmployeesByAge;
    }

    public Integer findAmountOfUsersByNumberDocument(Integer numberDocument){
        Integer amountEmployeesByNumberDocument = userRepository.findAmountOfUsersByNumberDocument(numberDocument);
        return amountEmployeesByNumberDocument;
    }

}
