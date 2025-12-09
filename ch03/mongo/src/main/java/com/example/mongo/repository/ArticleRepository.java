package com.example.mongo.repository;

import com.example.mongo.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findByName(String name);

    List<Article> findByNameAndEmail(String name, String email);

    List<Article> findByNameOrEmail(String name, String email);

    List<Article> findByNameStartingWith(String name);

    List<Article> findByNameEndingWith(String name);

    List<Article> findByNameContaining(String name);

    List<Article> findByNameLike(String name);

    // p 199 FIND TEXT CODE

}
