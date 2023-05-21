package com.evaluation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RegisterEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRegister;

    @Column(nullable = false)
    private LocalDateTime dateEnrollment;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_REGISTER_STUDENT"))
    private Student student;


    @OneToMany(mappedBy = "register", cascade = CascadeType.ALL)
    private List<DetailEnrollment> details;

    @Column(nullable = false)
    private boolean status;

}
