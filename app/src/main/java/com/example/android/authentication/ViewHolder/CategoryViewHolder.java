package com.example.android.authentication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.authentication.Interface.ItemClickListener;
import com.example.android.authentication.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView category_name;
    public ImageView category_image;
    private ItemClickListener itemClickListener;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        category_name=(TextView)itemView.findViewById(R.id.category_name);
        category_image=(ImageView)itemView.findViewById(R.id.category_image);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.OnClick(v,getAdapterPosition(),false);

    }
}
