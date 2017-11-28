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

/**
 * Created by diego on 27/11/17.
 */

public class OrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView titulo;
    private ImageView imagen;
    public ItemClickListener listener;

    public OrderHolder(View v, ItemClickListener listener) {
        super(v);

        //titulo = (TextView) v.findViewById(R.id.tv_titulo_itemcurso);

        //imagen = (ImageView) v.findViewById(R.id.iv_imagen_itemcurso);

        this.listener = listener;
        v.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        listener.onItemClick(v, getAdapterPosition());
    }

    void bindData(final Context context, final Order order){

        //titulo.setText(curso.getTitulo());

        //Glide.with(context).load(curso.getImagen()).into(imagen);

    }
}
