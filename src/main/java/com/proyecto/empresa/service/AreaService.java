package com.proyecto.empresa.service;


import com.proyecto.empresa.enums.ERole;
import com.proyecto.empresa.model.Area;
import com.proyecto.empresa.model.User;
import com.proyecto.empresa.repository.AreaRepository;
import com.proyecto.empresa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AreaRepository areaRepository;

    public Area saveArea(Area area, Integer idUser){
        try {
            User user = userRepository.findByIdUserAndRoles(idUser, ERole.LEADER);

            if (area.getLeaderArea().getIdUser().equals(user.getIdUser())) {

                return areaRepository.save(area);
            }else{
                throw new Exception("El usuario no tiene el rol de líder");
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Area> findAllAreas(){
        return areaRepository.findAll();
    }

    // filtros
    public Integer findAmountOfAreas(){
        return areaRepository.findAmountOfAreas();
    }

    public Integer findAmountOfActiveAreas(){
        return areaRepository.findAmountOfActiveAreas();
    }

    public Integer findAmountOfInactiveAreas(){
        return areaRepository.findAmountOfInactiveAreas();
    }

    public Integer findAmountOfAreasByName(String nameArea){
        return areaRepository.findAmountOfAreasByName(nameArea);
    }
}
