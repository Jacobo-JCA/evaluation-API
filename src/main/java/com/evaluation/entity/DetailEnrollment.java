package com.evaluation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DetailEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetail;

    @ManyToOne
    @JoinColumn(name = "id_register", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_REGISTER"))
    private RegisterEnrollment register;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false, length = 50)
    private String aula;


}
