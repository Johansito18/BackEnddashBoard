package com.proyecto.empresa.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.proyecto.empresa.enums.EState;
import com.proyecto.empresa.model.state.Deserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor //Constructor with arguments
@NoArgsConstructor  //Constructor without arguments
@Getter             //Getters to retrieve the data value
@Setter             //Getters to change the data value
@Entity             //Decorator to indicate that the "Area" class is a database entity
@Table(name = "areas")
public class Area implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area",nullable = false)
    private Integer idArea;

    @Column(name = "code_area",length = 2, unique = true)
    private Integer codeArea;

    @Column(name = "name_area",length = 50)
    private String nameArea;

    @JsonDeserialize(using = Deserialize.class)
    private EState state;


    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne
    @JoinColumn(name = "id_user")
    private User leaderArea;

}
