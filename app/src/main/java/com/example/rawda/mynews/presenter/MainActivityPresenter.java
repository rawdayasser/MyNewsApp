package com.example.rawda.mynews.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rawda.mynews.data.model.News;

import java.util.List;

public class MainActivityPresenter {
    private List<News> newsList;
    private MainView view;

    public MainActivityPresenter(MainView view, List<News> newsList) {
        this.view = view;
        this.newsList = newsList;
    }

    public MainView getView() {
        return view;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void onResume() {
        if (view != null) {
            view.showProgress();
        }
    }

    public void onListItemClicked(String item) {
        if (view != null) {
            view.showMessage(String.format("%s clicked", item));
        }
    }

    public void onDestroy() {
        view = null;
    }

    public void onFinishedLoading(List<News> newsList) {
        if (view != null) {
            view.setItems(newsList);
            view.hideProgress();
        }
    }
}
