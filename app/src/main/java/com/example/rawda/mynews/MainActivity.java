package com.example.rawda.mynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rawda.mynews.adapter.MainAdapter;
import com.example.rawda.mynews.data.model.News;
import com.example.rawda.mynews.presenter.MainActivityPresenter;
import com.example.rawda.mynews.presenter.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView newsRecycleView;
    private ProgressBar newsProgressBar;
    private MainActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
      //TODO add presenter object
    }
    private void init(){
        newsRecycleView = findViewById(R.id.news_recycler_view);
        newsProgressBar = findViewById(R.id.news_progress_bar);
    }

    @Override
    public void showProgress() {
        newsRecycleView.setVisibility(View.INVISIBLE);
        newsProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        newsProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setItems(List<News> newsList) {
        newsRecycleView.setAdapter(new MainAdapter(this, newsList));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
