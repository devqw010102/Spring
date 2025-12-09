package com.example.jpa.repository;

import com.example.jpa.model.Member;
import com.example.jpa.model.MemberStats;
import com.example.jpa.model.MemberStatsNative;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findAllByName(String name);

    List<Member> findByName(String name);

    List<Member> findByNameIs(String name);

    List<Member> findByNameEquals(String name);

    List<Member> getByName(String name);

    List<Member> queryByName(String name);

    List<Member> readByName(String name);

    List<Member> searchByName(String name);

    List<Member> findByNameAndEmail(String name, String email);

    List<Member> findByNameOrEmail(String name, String email);

    List<Member> findByNameStartingWith(String name);

    List<Member> findByNameEndingWith(String name);

    List<Member> findByNameContaining(String name);

    List<Member> findByNameLike(String name);

    List<Member> findByAgeIsNull();

    List<Member> findByAgeIsNotNull();

    List<Member> findByAgeIs(Integer age);

    List<Member> findByAgeGreaterThan(Integer age);

    List<Member> findByAgeAfter(Integer age);

    List<Member> findByAgeGreaterThanEqual(Integer age);

    List<Member> findByAgeLessThan(Integer age);

    List<Member> findByAgeBefore(Integer age);

    List<Member> findByAgeLessThanEqual(Integer age);

    List<Member> findByAgeBetween(Integer min, Integer max);

    List<Member> findByNameIsAndEmailIsOrAgeIsGreaterThan(String name, String email, Integer age);

    List<Member> queryByNameEqualsAndEmailIsOrAgeGreaterThan(String name, String email, Integer age);

    List<Member> searchByNameAndEmailOrAgeGreaterThan(String name, String email, Integer age);

    List<Member> findByOrderByNameAsc();

    List<Member> findByOrderByNameDesc();

    List<Member> findByNameContainingOrderByNameAsc(String name);

    Member findFirstByOrderByAgeAsc();

    Member findTopByOrderByAgeAsc();

    List<Member> findFirst2ByOrderByAgeAsc();

    List<Member> findTop2ByOrderByAgeAsc();

//    List<Member> findByNameContaining(String name, Sort sort);
//
    Page<Member> findByNameContaining(String name, Pageable pageable);

    @Transactional
    int deleteByEmail(String email);

    @Transactional
    int deleteByName(String name);

    @Query("SELECT m FROM Member m WHERE m.name = :name")
    List<Member> findMember(@Param("name") String name);

    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.email = :email")
    List<Member> findMember(@Param("name") String name, @Param("email") String email);

    @Query("""
            SELECT m.name, m.email, COUNT(a.id) AS COUNT
                        FROM Member m LEFT JOIN Article a ON a.member = m
                                    GROUP BY m ORDER BY COUNT DESC
            """)
    List<Object[]> getMemberStatsObject();

    @Query("""
        SELECT new com.example.jpa.model.MemberStats(m.name, m.email, COUNT(a.id))
            FROM Member m LEFT JOIN Article a ON a.member = m
            GROUP BY m ORDER BY COUNT(a.id) DESC
    """)
    List<MemberStats> getMemberStats();

    @Modifying
    @Query("UPDATE Member m SET m.age = :age")
    @Transactional
    int setMemberAge(Integer age);

    @Query(value = """
                SELECT m.name, m.email, count(a.id) AS count
                            FROM Member m LEFT JOIN Article a ON m.id = a.member_id
                                        GROUP BY m.id ORDER BY count DESC
            """, nativeQuery = true)
    List<Object[]> getMemberStatsNativeObject();

    @Query(value = """
                SELECT m.name, m.email, count(a.id) AS count
                            FROM Member m LEFT JOIN Article a ON m.id = a.member_id
                                        GROUP BY m.id ORDER BY count DESC
            """, nativeQuery = true)
    List<MemberStatsNative> getMemberStatsNative();
}