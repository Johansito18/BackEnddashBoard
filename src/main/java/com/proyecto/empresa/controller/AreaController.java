package com.proyecto.empresa.controller;

import com.proyecto.empresa.model.Area;
import com.proyecto.empresa.model.User;
import com.proyecto.empresa.service.AreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    AreaService areaService;

    @PostMapping("/saveArea")
    public Area saveArea(@RequestBody Area area, @RequestParam("idUser") Integer idUser){
        Area area1 = areaService.saveArea(area, idUser);
        return area1;
    }

    @PutMapping("/updateArea/{idArea}")
    public ResponseEntity<?> updateArea(@Valid @RequestBody Area area, @PathVariable Integer idArea, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }else{
            areaService.updateArea(area, idArea);
            return ResponseEntity.ok("Area actualizada correctamente");
        }
    }
    @GetMapping("/findAllAreas")
    public List<Area> findAllAreas(){
        List<Area> listArea = areaService.findAllAreas();
        return listArea;
    }

    //Filtros
    @GetMapping("/findAmountOfAreas")
    public Integer findAmountOfAreas(){
        Integer amountAreas = areaService.findAmountOfAreas();
        return amountAreas;
    }

    @GetMapping("/findAmountOfActiveAreas")
    public Integer findAmountOfActiveAreas(){
        Integer amountActiveAreas = areaService.findAmountOfActiveAreas();
        return amountActiveAreas;
    }

    @GetMapping("/findAmountOfInactiveAreas")
    public Integer findAmountOfInactiveAreas(){
        Integer amountInactiveAreas = areaService.findAmountOfInactiveAreas();
        return amountInactiveAreas;
    }

    @GetMapping("/findAmountOfAreasByName/{nameArea}")
    public Integer findAmountOfAreasByName(@PathVariable String nameArea){
        Integer amountAreasByName = areaService.findAmountOfAreasByName(nameArea);
        return amountAreasByName;
    }




}
