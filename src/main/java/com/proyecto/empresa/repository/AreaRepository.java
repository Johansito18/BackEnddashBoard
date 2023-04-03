package com.proyecto.empresa.repository;

import com.proyecto.empresa.enums.ERole;
import com.proyecto.empresa.enums.EState;
import com.proyecto.empresa.model.Area;
import com.proyecto.empresa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    //Pa mostrar cantidad de areas poner .count() , activas inactivas,

    List<Area> findByState(EState state);

    Area findByIdArea(Integer idArea);

    @Query(value = "CALL areas_totales();", nativeQuery = true)
    Integer findAmountOfAreas();

    @Query(value = "CALL areas_activas();", nativeQuery = true)
    Integer findAmountOfActiveAreas();

    @Query(value = "CALL areas_inactivas();", nativeQuery = true)
    Integer findAmountOfInactiveAreas();

    @Query(value = "SELECT COUNT(*) FROM areas WHERE name_area = ?;", nativeQuery = true)
    Integer findAmountOfAreasByName(@Param("name_area") String nameArea);
}
