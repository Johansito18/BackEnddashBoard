package com.proyecto.empresa.service;

import com.proyecto.empresa.enums.ERole;
import com.proyecto.empresa.enums.EState;
import com.proyecto.empresa.model.User;
import com.proyecto.empresa.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
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

    public List<User> findAllByEmployeeRol(){
        return userRepository.findAllByRoles(ERole.EMPLOYED);
    }

    public Integer findAmountOfEmployees(){
        return userRepository.findAmountOfEmployees();
    }

    public Integer findAmountOfActiveEmployees(){
        return userRepository.findAmountOfActiveEmployees();
    }

    public Integer findAmountOfInactiveEmployees(){
        return userRepository.findAmountOfInactiveEmployees();
    }

    public Integer findAmountOfEmployeesByDates(String date) throws ParseException {
        String date1 = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        return userRepository.findAmountOfEmployeesByDates(date1);
    }

    public Integer findAmountOfEmployeesByName(String name){
        return userRepository.findAmountOfEmployeesByName(name);
    }

    public Integer findAmountOfUsersAndAreasByState(Integer state){
        return userRepository.findAmountOfUsersAndAreasByState(state);
    }

    public Integer findAmountOfUsersBySalary(Double salary){
        return userRepository.findAmountOfUsersBySalary(salary);
    }

    public Integer findAmountOfUsersByAge(Integer age){
        return userRepository.findAmountOfUsersByAge(age);
    }

    public Integer findAmountOfUsersByNumberDocument(Integer numberDocument){
        return userRepository.findAmountOfUsersByNumberDocument(numberDocument);
    }


    /*public List<Long> findByDates(Date startDate, Date endDate){
        List<Long> lista = new ArrayList<>();

        Long empleadosTotales = userRepository.findAll().stream()
                .filter(fechas -> fechas.getBirthDate().compareTo(startDate) >=0 && fechas.getBirthDate().compareTo(endDate) <= 0)
                .count();

        Long rolEmpleadoActive = (long) userRepository.findByRolesAndState(ERole.EMPLOYED, EState.ACTIVE.getValor()).size();

        Long rolEmpleadoInactive = (long) userRepository.findByRolesAndState(ERole.EMPLOYED, EState.INACTIVE.getValor()).size();

        lista.add(empleadosTotales);
        lista.add(rolEmpleadoActive);
        lista.add(rolEmpleadoInactive);

        return lista;
    }*/

    /*public List<Long> findByAreas(Integer idArea){
        List<Long> lista = new ArrayList<>();

        Long empleadosTotales = userRepository.findAll().stream()
                .filter(area -> area.getArea().getIdArea().equals(idArea)).count();


    }*/

    /*public List<User> findByDates(Date startDate, Date endDate){
        return userRepository.findByDateBetween(startDate, endDate);
    }

    public List<User> findByAreas(Integer idArea){
        return userRepository.findByArea(idArea);
    }

    public List<User> findByStates(EState state){
        return userRepository.findByState(state);
    }

    public List<User> findBySalaries(Double startSalary, Double endSalary){
        return userRepository.findBySalaryBetween(startSalary,endSalary);
    }

    *//*public List<User> findByAge(int age){
        return userRepository.findByAge(age);
    }*//*

    public List<User> findByNumberDocument(Integer numberDocument){
        return userRepository.findByDocumentNumber(numberDocument);
    }*/
}
