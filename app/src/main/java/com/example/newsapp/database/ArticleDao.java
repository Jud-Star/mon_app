package com.example.newsapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.newsapp.model.Article;

import java.util.List;

@Dao
public interface ArticleDao {
    @Insert
    void insert(Article article);

    @Update
    void update(Article article);

    @Delete
    void delete(Article article);

    @Query("SELECT * FROM articles ORDER BY publishedAt DESC")
    List<Article> getAllArticles();

    @Query("SELECT * FROM articles WHERE category = :category ORDER BY publishedAt DESC")
    List<Article> getArticlesByCategory(String category);

    @Query("SELECT * FROM articles WHERE isFavorite = 1 ORDER BY publishedAt DESC")
    List<Article> getFavoriteArticles();

    @Query("SELECT * FROM articles WHERE id = :articleId")
    Article getArticleById(int articleId);

    @Query("SELECT DISTINCT category FROM articles")
    List<String> getAllCategories();

    @Query("UPDATE articles SET isFavorite = :isFavorite WHERE id = :articleId")
    void updateFavoriteStatus(int articleId, boolean isFavorite);

    @Query("DELETE FROM articles")
    void deleteAllArticles();
}
