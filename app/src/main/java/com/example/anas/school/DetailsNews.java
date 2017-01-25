package com.example.anas.school;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsNews extends Activity {

    TextView tx_news;
    News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_news);

        tx_news= (TextView) findViewById(R.id.tx_details_news_id);

        news = getIntent().getParcelableExtra("news");
        String s = news.getNews();

        tx_news.setText(s);

    }
}
