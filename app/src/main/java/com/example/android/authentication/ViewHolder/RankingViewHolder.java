package com.example.android.authentication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.authentication.R;

public class RankingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txt_name,txt_score;
    public RankingViewHolder(View itemView) {
        super(itemView);
        txt_name=(TextView)itemView.findViewById(R.id.txt_name);
        txt_score=(TextView)itemView.findViewById(R.id.txt_score);
    }

    @Override
    public void onClick(View v) {

    }
}
