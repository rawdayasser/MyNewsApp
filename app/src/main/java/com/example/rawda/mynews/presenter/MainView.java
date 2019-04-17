package com.example.rawda.mynews.presenter;

import com.example.rawda.mynews.data.model.News;

import java.util.List;

public interface MainView{
    void showProgress();
    void hideProgress();
    void setItems(List<News> newsList);
    void showMessage(String message);
}
