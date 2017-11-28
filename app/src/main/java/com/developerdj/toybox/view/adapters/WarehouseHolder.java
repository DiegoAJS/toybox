package com.developerdj.toybox.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developerdj.toybox.R;
import com.developerdj.toybox.interfaces.ItemClickListener;
import com.developerdj.toybox.pojo.Order;
import com.developerdj.toybox.pojo.Warehouse;

/**
 * Created by diego on 27/11/17.
 */

public class WarehouseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView titulo,direccion;
    public ItemClickListener listener;

    public WarehouseHolder(View v, ItemClickListener listener) {
        super(v);

        titulo = (TextView) v.findViewById(R.id.tv_titulo_item_warehouse);
        direccion = (TextView) v.findViewById(R.id.tv_direccion_item_warehouse);

        this.listener = listener;
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v, getAdapterPosition());
    }

    void bindData(final Context context, final Warehouse warehouse){

        titulo.setText(warehouse.getName());
        direccion.setText(warehouse.getAddress());

    }
}
