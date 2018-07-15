package com.algotechnologies.nytimes.model;

import com.algotechnologies.nytimes.model.dto.Article;

import java.util.List;

/**
 * Created by Saad Aftab on 15/07/2018.
 */
public interface RepositoryCallback {

    void onFailure(String errorMessage);

    void onSuccess(List<Article> articleList);

}
