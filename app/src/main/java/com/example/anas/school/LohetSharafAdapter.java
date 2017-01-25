package com.example.anas.school;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anas on 2016-12-22.
 */

public class LohetSharafAdapter extends RecyclerView.Adapter<LohetSharafAdapter.lohetsharafViewHolder> {

    private Context context;
    private LohetSharaf lohetSharaf;
    private List<LohetSharaf> lohetSharafs_List;

    public LohetSharafAdapter(List<LohetSharaf> lohetSharafs_List) {
        this.lohetSharafs_List = lohetSharafs_List;
    }

    public static class lohetsharafViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tx_name,tx_classroom;

        lohetsharafViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_news_id);
            tx_name= (TextView) itemView.findViewById(R.id.textview_name_id);
            tx_classroom= (TextView) itemView.findViewById(R.id.textview_classroom_id);

        }
    }

    @Override
    public lohetsharafViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_lohetsharf, parent, false);
        lohetsharafViewHolder holder = new lohetsharafViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(lohetsharafViewHolder holder, int position) {

        lohetSharaf=lohetSharafs_List.get(position);
        holder.tx_name.setText(lohetSharaf.getName());
        holder.tx_classroom.setText(lohetSharaf.getClassroom());

    }

    @Override
    public int getItemCount() {
        return lohetSharafs_List.size();
    }
}
