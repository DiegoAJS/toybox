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
import com.developerdj.toybox.pojo.Product;

/**
 * Created by diego on 27/11/17.
 */

public class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView titulo,cantidad;
    private ImageView imagen;
    public ItemClickListener listener;

    public ProductHolder(View v, ItemClickListener listener) {
        super(v);

        titulo = (TextView) v.findViewById(R.id.tv_titulo_item_product);
        cantidad = (TextView) v.findViewById(R.id.tv_cantidad_item_product);

        imagen = (ImageView) v.findViewById(R.id.iv_imagen_item_product);

        this.listener = listener;
        v.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        listener.onItemClick(v, getAdapterPosition());
    }

    void bindData(final Context context, final Product product){

        titulo.setText(product.getName());
        cantidad.setText(product.getQuantity()+" disponibles");

        Glide.with(context).load(product.getPicture_url()).into(imagen);



    }
}
