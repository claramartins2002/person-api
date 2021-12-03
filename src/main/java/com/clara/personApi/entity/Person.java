package com.clara.personApi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data //gera getters + setters
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incrementar id
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)//não há registros com o mesmo cpf!!
    private String cpf;
    private LocalDate birthDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;

}
