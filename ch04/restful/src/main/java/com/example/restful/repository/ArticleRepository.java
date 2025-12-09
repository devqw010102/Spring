package com.example.restful.repository;

import com.example.restful.model.Article;
import com.example.restful.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByMember(Member member);
}
