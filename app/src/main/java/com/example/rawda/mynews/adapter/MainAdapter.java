package com.example.rawda.mynews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rawda.mynews.R;
import com.example.rawda.mynews.data.model.News;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private Context mContext;
    private List<News> newsList;
    // TODO add Listener
    public MainAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        News newsModel = newsList.get(i);
        // TODO turn image url into Image(int)
        myViewHolder.newsImage.setImageResource(R.drawable.ic_launcher_background);
        myViewHolder.contentText.setText(newsModel.getContent());
        myViewHolder.publisherText.setText(newsModel.getAuthor());
        myViewHolder.dateText.setText(newsModel.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView newsImage;
        private TextView contentText;
        private TextView dateText;
        private TextView publisherText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_image_view);
            contentText = itemView.findViewById(R.id.news_content_text_view);
            dateText = itemView.findViewById(R.id.news_date_text_view);
            publisherText = itemView.findViewById(R.id.news_date_text_view);
        }
    }
}
