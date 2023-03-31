package com.proyecto.empresa.controller;

import com.proyecto.empresa.model.Area;
import com.proyecto.empresa.model.User;
import com.proyecto.empresa.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    AreaService areaService;

    @PostMapping("/saveArea")
    public Area saveArea(@RequestBody Area area, @RequestParam("idUser") Integer idUser){
        return areaService.saveArea(area, idUser);
    }

    @GetMapping("/findAllAreas")
    public List<Area> findAllAreas(){
        return areaService.findAllAreas();
    }

    //Filtros
    @GetMapping("/findAmountOfAreas")
    public Integer findAmountOfAreas(){
        return areaService.findAmountOfAreas();
    }

    @GetMapping("/findAmountOfActiveAreas")
    public Integer findAmountOfActiveAreas(){
        return areaService.findAmountOfActiveAreas();
    }

    @GetMapping("/findAmountOfInactiveAreas")
    public Integer findAmountOfInactiveAreas(){
        return areaService.findAmountOfInactiveAreas();
    }

    @GetMapping("/findAmountOfAreasByName/{nameArea}")
    public Integer findAmountOfAreasByName(@PathVariable String nameArea){
        return areaService.findAmountOfAreasByName(nameArea);
    }




}
