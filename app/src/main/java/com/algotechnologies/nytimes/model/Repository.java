package com.algotechnologies.nytimes.model;

import com.algotechnologies.nytimes.model.dto.Article;
import com.algotechnologies.nytimes.model.network.ArticleService;
import com.algotechnologies.nytimes.model.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saad Aftab on 14/07/2018.
 */
public class Repository {

    private RepositoryCallback callback;

    public Repository(RepositoryCallback callback) {
        this.callback = callback;
    }

    public void getArticlesData() {
        ArticleService service = new ArticleService(this);
        service.request(Constant.BASE_URL + Constant.KEY);
    }

    public void onFailure(String errorMessage) {
        callback.onFailure(errorMessage);
    }

    public void onSuccess(String data) {

        List<Article> articles = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject result = jsonArray.getJSONObject(i);
                articles.add(
                        new Article(result.getString("title")
                            , result.getString("byline")
                            , result.getString("abstract"))
                );
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        callback.onSuccess(articles);
    }
}
