package com.example.demo2;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByEmail(String email);
    List<Member> findByNameContaining(String name);

    List<Member> findByNameAndEmail(String name, String email);
    List<Member> findByNameOrEmail(String name, String email);

    List<Member> findByAgeGreaterThan(int age);
    List<Member> findByAgeLessThan(int age);
    List<Member> findByAgeBetween(int min, int max);

    @Query("SELECT * FROM Member WHERE age >= 13 AND agd <= 19")
    List<Member> findTeenAge();

    @Query("SELECT * FROM Member WHERE age >= :min AND age <= :max")
    List<Member> findByAgeRange(int min, int max);
}
