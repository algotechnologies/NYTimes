package com.algotechnologies.nytimes.viewmodel;

import com.algotechnologies.nytimes.model.dto.Article;
import com.algotechnologies.nytimes.view.MainActivity;
import com.algotechnologies.nytimes.viewmodel.adapter.ArticlesAdapter;

import java.util.List;

/**
 * Created by Saad Aftab on 14/07/2018.
 */
public class MainViewModel {

    private ArticlesAdapter articlesAdapter;

    public MainViewModel(MainActivity view, List<Article> articleList) {
        articlesAdapter = new ArticlesAdapter(articleList);
        view.showData(articlesAdapter);
        view.setListeners(articlesAdapter);
    }

}
