package com.algotechnologies.nytimes.model.network;

import android.util.Log;

import com.algotechnologies.nytimes.model.Repository;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Saad Aftab on 14/07/2018.
 */
public class ArticleService implements Callback {

    private OkHttpClient client;
    private Repository repository;

    public ArticleService(Repository repository) {
        this.repository = repository;

        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    public void request(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = client.newCall(request);
        call.enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        repository.onFailure(e.getMessage());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            String responseStr = response.body().string();
            repository.onSuccess(responseStr);
        } else {
            repository.onFailure("Something went wrong!");
        }
    }

}
