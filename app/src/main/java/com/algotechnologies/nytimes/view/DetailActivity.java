package com.algotechnologies.nytimes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.algotechnologies.nytimes.R;
import com.algotechnologies.nytimes.databinding.ActivityDetailBinding;
import com.algotechnologies.nytimes.model.dto.Article;

import java.util.List;

/**
 * Created by Saad Aftab on 14/07/2018.
 */
public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private String details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        setTitle("Details");

        details = getExtras();

        if (details == null) {
            Toast.makeText(this, "Extras couldn't load!", Toast.LENGTH_SHORT).show();
        }

        displayDetails();
    }

    private void displayDetails() {
        binding.textview.setText(details);
    }

    private String getExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString("DETAILS");
        }
        return null;
    }

}
