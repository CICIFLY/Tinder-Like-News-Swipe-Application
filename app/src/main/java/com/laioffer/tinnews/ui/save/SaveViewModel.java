package com.laioffer.tinnews.ui.save;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.repository.NewsRepository;

import java.util.List;

public class SaveViewModel extends ViewModel {
    private final NewsRepository newsRepository;

    public SaveViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public LiveData<List<Article>> getAllSavedArticles() {
        return newsRepository.getAllSavedArticles();
    }

    public void deleteSavedArticle(Article article) {
        newsRepository.deleteSavedArticle(article);
    }

}
