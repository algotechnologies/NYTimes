package com.algotechnologies.nytimes.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.algotechnologies.nytimes.R;
import com.algotechnologies.nytimes.model.dto.Article;
import com.algotechnologies.nytimes.model.util.Helper;
import com.algotechnologies.nytimes.viewmodel.SplashViewModel;

import java.io.Serializable;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if ( isInternetAvailable() ) {
            new SplashViewModel(this);
        }
    }

    public void displayMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public boolean isInternetAvailable() {
        if (!Helper.checkNetworkAvailablity(getApplicationContext())) {
            Toast.makeText(this, "No internet connectivity!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void showNextScreen(List<Article> articleList) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ARTICLES", (Serializable) articleList);
        startActivity(intent);
        finish();
    }

}
