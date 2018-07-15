package com.algotechnologies.nytimes.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.algotechnologies.nytimes.R;
import com.algotechnologies.nytimes.databinding.ActivityMainBinding;
import com.algotechnologies.nytimes.model.dto.Article;
import com.algotechnologies.nytimes.viewmodel.MainViewModel;
import com.algotechnologies.nytimes.viewmodel.adapter.ArticlesAdapter;
import com.algotechnologies.nytimes.viewmodel.contract.OnItemClickListener;

import java.util.List;

/**
 * Created by Saad Aftab on 14/07/2018.
 */
public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private ActivityMainBinding binding;
    private MainViewModel viewmodel;
    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        articleList = getExtras();

        if (articleList == null) {
            Toast.makeText(this, "Extras couldn't load!", Toast.LENGTH_SHORT).show();
        }

        viewmodel = new MainViewModel(this, articleList);

    }

    public void showData(ArticlesAdapter adapter) {
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerview.setAdapter(adapter);
    }

    public void setListeners(ArticlesAdapter adapter) {
        adapter.setClickListener(this);
    }

    public void showNextScreen(String details) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("DETAILS", details);
        startActivity(intent);
    }

    private List<Article> getExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return (List<Article>) extras.getSerializable("ARTICLES");
        }
        return null;
    }

    @Override
    public void onClick(View view, int position) {
        showNextScreen( articleList.get(position).getDetails() );
    }

}