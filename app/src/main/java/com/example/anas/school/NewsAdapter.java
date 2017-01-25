package com.example.anas.school;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.newsViewHolder>{


    private Context context;
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public static class newsViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tx_news;

        newsViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_news_id);
            tx_news= (TextView) itemView.findViewById(R.id.textview_news_id);

        }
    }

    @Override
    public newsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_news, parent, false);
        newsViewHolder tr = new newsViewHolder(v);
        return tr;

    }

    @Override
    public void onBindViewHolder(newsViewHolder holder, int position) {
         News news=newsList.get(position);
        holder.tx_news.setText(news.getNews());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
