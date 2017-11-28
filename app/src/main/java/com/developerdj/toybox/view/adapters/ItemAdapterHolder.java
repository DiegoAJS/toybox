package com.developerdj.toybox.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.developerdj.toybox.R;
import com.developerdj.toybox.interfaces.ItemClickListener;
import com.developerdj.toybox.interfaces.OnLoadMoreListener;
import com.developerdj.toybox.pojo.Footer;
import com.developerdj.toybox.pojo.Item;
import com.developerdj.toybox.pojo.Order;
import com.developerdj.toybox.pojo.Product;
import com.developerdj.toybox.pojo.Store;
import com.developerdj.toybox.pojo.User;
import com.developerdj.toybox.pojo.Warehouse;
import com.developerdj.toybox.view.activitys.WareHouseActivity;

import java.util.List;
/**
 * Created by diego on 26/11/17.
 */

public class ItemAdapterHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemClickListener {

    private Context context;
    private List<Item> items;

    OnLoadMoreListener loadMoreListener;
    boolean isLoading = false, isMoreDataAvailable = true;

    public static final int TYPE_FOOTER     = 0;
    public static final int TYPE_ORDER      = 1;
    public static final int TYPE_PRODUCT    = 2;
    public static final int TYPE_STORE      = 3;
    public static final int TYPE_USER       = 4;
    public static final int TYPE_WAREHOUSE  = 5;

    public ItemAdapterHolder(@NonNull List<Item> items, Context context) {
        this.items = items;
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Order) {
            return TYPE_ORDER;
        } else if (items.get(position) instanceof Product) {
            return TYPE_PRODUCT;
        } else if (items.get(position) instanceof Store) {
            return TYPE_STORE;
        } else if (items.get(position) instanceof User) {
            return TYPE_USER;
        } else if (items.get(position) instanceof Warehouse) {
            return TYPE_WAREHOUSE;
        }else if(items.get(position) instanceof Footer){
            return TYPE_FOOTER;
        }else
            throw new RuntimeException("ItemViewType unknown");
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case TYPE_ORDER:
                viewHolder = new OrderHolder(inflater.inflate(R.layout.item_order,parent,false),this);break;
            case TYPE_PRODUCT:
                viewHolder = new ProductHolder(inflater.inflate(R.layout.item_product,parent,false),this);break;
            case TYPE_STORE:
                viewHolder = new StoreHolder(inflater.inflate(R.layout.item_store,parent,false),this);break;
            case TYPE_USER:
                viewHolder =  new UserHolder(inflater.inflate(R.layout.item_users,parent,false),this);break;
            case TYPE_WAREHOUSE:
                viewHolder =  new WarehouseHolder(inflater.inflate(R.layout.item_warehouse,parent,false),this);break;
            case TYPE_FOOTER:
                viewHolder =  new LoadHolder(inflater.inflate(R.layout.item_load,parent,false));break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position>=getItemCount()-1 && isMoreDataAvailable && !isLoading && loadMoreListener!=null){
            isLoading = true;
            loadMoreListener.onLoadMore();
        }

        switch (getItemViewType(position)){
            case TYPE_ORDER:((OrderHolder)holder).bindData(context,(Order) items.get(position));break;
            case TYPE_PRODUCT:((ProductHolder)holder).bindData(context,(Product) items.get(position));break;
            case TYPE_STORE: ((StoreHolder)holder).bindData(context,(Store) items.get(position));break;
            case TYPE_USER:((UserHolder)holder).bindData(context,(User) items.get(position));break;
            case TYPE_WAREHOUSE:((WarehouseHolder)holder).bindData(context,(Warehouse) items.get(position));break;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(View view, int position) {

        switch (getItemViewType(position))
        {
            case TYPE_ORDER:
                //order event
                ;break;

            case TYPE_PRODUCT:
                //product event
                break;

            case TYPE_STORE:
                //store event
                break;

            case TYPE_USER:
                //user event
                break;

            case TYPE_WAREHOUSE:
                //warehouse event
                WareHouseActivity.createInstance(context,((Warehouse)items.get(position)));
                break;
        }
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }

    /* notifyDataSetChanged is final method so we can't override it call adapter.notifyDataChanged(); after update the list */
    public void notifyDataChanged(){
        notifyDataSetChanged();
        isLoading = false;
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    //viewHolder Load
    static class LoadHolder extends RecyclerView.ViewHolder{
        public LoadHolder(View itemView) {
            super(itemView);
        }
    }
}
