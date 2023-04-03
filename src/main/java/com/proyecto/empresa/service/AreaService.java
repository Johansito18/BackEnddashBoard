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
            System.out.println(user.getIdUser());
            if (area.getLeaderArea().getIdUser().equals(user.getIdUser())) {

                Area area1;

                area1 = areaRepository.save(area);

                return area1;

            }else{
                throw new Exception("El usuario no tiene el rol de líder");
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void updateArea(Area area, Integer idArea){
        try {
            Area area1 = areaRepository.findByIdArea(idArea);

            User user = userRepository.findByIdUserAndRoles(
                    area.getLeaderArea().getIdUser(), ERole.LEADER
            );

            if (area1.getIdArea().equals(area.getIdArea())){

                area1.setNameArea(area.getNameArea());
                area1.setState(area.getState());
                area1.setLeaderArea(user);
            }
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Area> findAllAreas(){
        List<Area> listArea = areaRepository.findAll();
        return listArea;
    }

    // filtros
    public Integer findAmountOfAreas(){
        Integer amountAreas = areaRepository.findAmountOfAreas();
        return amountAreas;
    }

    public Integer findAmountOfActiveAreas(){
        Integer amountActiveAreas = areaRepository.findAmountOfActiveAreas();
        return amountActiveAreas;
    }

    public Integer findAmountOfInactiveAreas(){
        Integer amountInactiveAreas = areaRepository.findAmountOfInactiveAreas();
        return amountInactiveAreas;
    }

    public Integer findAmountOfAreasByName(String nameArea){
        Integer amountAreasByName = areaRepository.findAmountOfAreasByName(nameArea);
        return amountAreasByName;
    }
}
