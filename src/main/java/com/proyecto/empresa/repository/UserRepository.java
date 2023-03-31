package com.proyecto.empresa.repository;

import com.proyecto.empresa.enums.ERole;
import com.proyecto.empresa.enums.EState;
import com.proyecto.empresa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    //Para metodo guardar de areas
    User findByIdUserAndRoles(Integer idUser, ERole rol);

    User findByIdUser(Integer idUser);

    List<User> findAllByRoles(ERole role);

    //Filtros
    @Query(value = "CALL empleados_totales();", nativeQuery = true)
    Integer findAmountOfEmployees();

    @Query(value = "CALL empleados_activos();", nativeQuery = true)
    Integer findAmountOfActiveEmployees();

    @Query(value = "CALL empleados_inactivos();", nativeQuery = true)
    Integer findAmountOfInactiveEmployees();

    @Query(value = "SELECT COUNT(*) FROM users WHERE birth_date = ?;",
            nativeQuery = true)
    Integer findAmountOfEmployeesByDates(@Param("birth_date") String date);

    @Query(value = "SELECT COUNT(*) FROM users WHERE name = ?;",
            nativeQuery = true)
    Integer findAmountOfEmployeesByName(@Param("name") String name);

    @Query(value = "SELECT (SELECT COUNT(*) FROM users WHERE state = ?1) +\n" +
            "(SELECT COUNT(*) FROM areas WHERE state = ?1);",
            nativeQuery = true)
    Integer findAmountOfUsersAndAreasByState(@Param("state") Integer state);

    @Query(value = "SELECT COUNT(*) FROM users WHERE salary = ?;",
            nativeQuery = true)
    Integer findAmountOfUsersBySalary(@Param("salary") Double salary);

    @Query(value = "SELECT COUNT(*) FROM users WHERE \n" +
            "DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),birth_date)), '%Y') = ?;",
            nativeQuery = true)
    Integer findAmountOfUsersByAge(@Param("edad") Integer age);

    @Query(value = "SELECT COUNT(*) FROM users WHERE document_number = ?;",
            nativeQuery = true)
    Integer findAmountOfUsersByNumberDocument(@Param("document_number")
                  Integer numberDocument);

}
