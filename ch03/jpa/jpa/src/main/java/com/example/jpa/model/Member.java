package com.example.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member", indexes = {
        @Index(name = "idx_name_age", columnList = "name, age"),
        @Index(name = "idx_email", columnList = "email")
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    /* Oracle Sequence */
//    @SequenceGenerator(
//            name = "member_seq_gen",
//            sequenceName = "MEM_SEQ",
//            allocationSize = 1
//    )
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 2048, nullable = false, unique = true)
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "age", nullable = false, columnDefinition = "INTEGER DEFAULT 10")
    private Integer age;
    @Transient
    private String address;
}
