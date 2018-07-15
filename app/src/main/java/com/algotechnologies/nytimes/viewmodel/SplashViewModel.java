package com.algotechnologies.nytimes.viewmodel;

import com.algotechnologies.nytimes.model.Repository;
import com.algotechnologies.nytimes.model.RepositoryCallback;
import com.algotechnologies.nytimes.model.dto.Article;
import com.algotechnologies.nytimes.view.SplashActivity;

import java.util.List;

/**
 * Created by Saad Aftab on 15/07/2018.
 */
public class SplashViewModel implements RepositoryCallback {

    private SplashActivity view;
    private Repository repository;

    public SplashViewModel(SplashActivity view) {
        this.view = view;

        repository = new Repository(this);
        repository.getArticlesData();
    }

    @Override
    public void onFailure(String errorMessage) {
        view.displayMessage(errorMessage);
    }

    @Override
    public void onSuccess(List<Article> articleList) {
        view.showNextScreen(articleList);
    }

}
