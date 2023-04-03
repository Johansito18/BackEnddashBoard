package com.proyecto.empresa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.proyecto.empresa.enums.ERole;
import com.proyecto.empresa.enums.EState;
import com.proyecto.empresa.model.state.Deserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor //Constructor with arguments
@NoArgsConstructor  //Constructor without arguments
@Getter             //Getters to retrieve the data value
@Setter             //Getters to change the data value
@Entity             //Decorator to indicate that the "User" class is a database entity
@Table(name = "users")
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user",nullable = false)
    private Integer idUser;

    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 50)
    private String name;

    @NotEmpty(message = "El apellido no debe estar vacío")
    @Column(length = 50)
    private String lastName;

    @NotNull(message = "La fecha no debe estar vacía")
    @Temporal(TemporalType.DATE)
    private String birthDate;

    @NotEmpty(message = "El correo no debe estar vacío")
    @Email(message = "El correo debe tener un formato válido")
    @Column(length = 50)
    private String email;

    @NotEmpty
    @Column(length = 50)
    private String password;

    @NotNull
    @Column(length = 10, unique = true)
    private Integer documentNumber;

    @NotNull
    @Column(length = 10)
    private Double salary;

    @NotEmpty(message = "La posicion no debe estár vacía")
    @Column(length = 50)
    private String position;

    /*@ElementCollection(targetClass = ERole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_user"))*/
    @Enumerated(EnumType.STRING)
    private ERole roles;

    @JsonDeserialize(using = Deserialize.class)
    private EState state;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    /*@OneToMany(mappedBy = "leaderArea")
    private List<Area> area;*/

    /*@ManyToOne()
    @JoinColumn(name = "id_area")
    private Area area;*/

}
