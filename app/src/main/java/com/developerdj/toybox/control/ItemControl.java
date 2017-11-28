package com.developerdj.toybox.control;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;


import com.developerdj.toybox.R;
import com.developerdj.toybox.data.service.MoviesApi;
import com.developerdj.toybox.data.service.OrderApi;
import com.developerdj.toybox.data.service.ProductApi;
import com.developerdj.toybox.data.service.ServiceGenerator;
import com.developerdj.toybox.data.service.StoreApi;
import com.developerdj.toybox.data.service.UserApi;
import com.developerdj.toybox.data.service.WareHouseApi;
import com.developerdj.toybox.interfaces.OnLoadMoreListener;
import com.developerdj.toybox.pojo.Carrera;
import com.developerdj.toybox.pojo.Footer;
import com.developerdj.toybox.pojo.Item;
import com.developerdj.toybox.pojo.Order;
import com.developerdj.toybox.pojo.Product;
import com.developerdj.toybox.pojo.Store;
import com.developerdj.toybox.pojo.User;
import com.developerdj.toybox.pojo.Warehouse;
import com.developerdj.toybox.view.adapters.ItemAdapterHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 15/8/2017.
 */

public class ItemControl implements SwipeRefreshLayout.OnRefreshListener {

    public static String TAG = ItemControl.class.getSimpleName();

    private static final int LIMINT = 5;

    private Context context;
    private RecyclerView recycler;
    private FragmentManager fragmentManager;

    private int type;
    private String id;

    private SwipeRefreshLayout refreshLayout;

    private ItemAdapterHolder adapter;
    private List<Item> items = new ArrayList<Item>();

    private OrderApi orderApi           = ServiceGenerator.createService(OrderApi.class);
    private ProductApi productApi       = ServiceGenerator.createService(ProductApi.class);
    private StoreApi storeApi           = ServiceGenerator.createService(StoreApi.class);
    private UserApi userApi             = ServiceGenerator.createService(UserApi.class);
    private WareHouseApi wareHouseApi    = ServiceGenerator.createService(WareHouseApi.class);


    //protected NoResultadoDialog noResultadoDialog=new NoResultadoDialog();

    public ItemControl() {

    }

    public void setupFragment(Context c, ViewGroup v, FragmentManager f, int type){

        this.context=c;
        this.fragmentManager=f;
        this.type=type;

        recycler=(RecyclerView)v.findViewById(R.id.reciclador);
        refreshLayout = (SwipeRefreshLayout)v.findViewById(R.id.sr_cargando);

        init();

    }

    public void setupActivity(AppCompatActivity context, int type, String id){

        this.context=context;
        this.fragmentManager=context.getSupportFragmentManager();
        this.type=type;
        this.id=id;

        recycler=(RecyclerView)context.findViewById(R.id.reciclador);
        refreshLayout = (SwipeRefreshLayout)context.findViewById(R.id.sr_cargando);

        init();

    }

    @Override
    public void onRefresh() {
        dismissCargando();
        clear();
    }

    public void init(){

        adapter = new ItemAdapterHolder(items,context);

        adapter.setLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                recycler.post(new Runnable() {
                    @Override
                    public void run() {
                        load(items.size());
                    }
                });
            }
        });

        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.setAdapter(adapter);

        // Obtener el refreshLayout
        // Seteamos los colores que se usarán a lo largo de la animación
        refreshLayout.setColorSchemeResources(R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorAccent);
        refreshLayout.setOnRefreshListener(this);

        if(items.isEmpty())
            load(0);
    }

    public void clear(){
        items.clear();
        init();
    }

    public void load(int index){

        Log.d(TAG, "type : "+String.valueOf(type));

        if(items.isEmpty())
            showCargando();
        else{
            items.add(new Footer());
            adapter.notifyItemInserted(items.size()-1);
        }

        switch (this.type){
            case ItemAdapterHolder.TYPE_ORDER:
                //orden
                getOrder(index);
                ;break;
            case ItemAdapterHolder.TYPE_PRODUCT:
                //Product
                getProduct();
                ;break;
            case ItemAdapterHolder.TYPE_STORE:
                //store
                getStore(index);
                ;break;
            case ItemAdapterHolder.TYPE_USER:
                //user
                getUser(index);
                ;break;
            case ItemAdapterHolder.TYPE_WAREHOUSE:
                //warehouse
                getWareHouse();
                ;break;
        }
    }

    private void cancelar(){
        if (items.isEmpty()){
            dismissCargando();
        }else {
            //remove loading view
            items.remove(items.size()-1);
        }
    }

    public void showCargando(){
        refreshLayout.setRefreshing(true);
    }

    public void dismissCargando(){
        refreshLayout.setRefreshing(false);
    }

    //getDatos

    public void getOrder(int index){
        Call<List<Order>> call = orderApi.getOrders(index);
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                cancelar();
                if(response.isSuccessful()){
                    items.addAll(response.body());
                    adapter.notifyDataChanged();
                }else{
                    Log.e(TAG," Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                cancelar();
                Log.e(TAG," Response Error "+t.getMessage());
            }
        });
    }

    public void getProduct(){
        Call<List<Product>> call = productApi.getProducts(id,LIMINT,items.size());
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                cancelar();
                if(response.isSuccessful()){

                    items.addAll(response.body());
                    adapter.notifyDataChanged();
                }else{
                    Log.e(TAG," Response Error "+String.valueOf(response.code()));
                    showMessage(" Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(TAG," Response Error "+t.getMessage());
                showMessage(" Response Error "+t.getMessage());
                cancelar();
            }
        });
    }

    public void getStore(int index){
        Call<List<Store>> call = storeApi.getStores(index);
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                if(response.isSuccessful()){

                    items.addAll(response.body());
                    adapter.notifyDataChanged();
                }else{
                    Log.e(TAG," Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                Log.e(TAG," Response Error "+t.getMessage());
            }
        });
    }

    public void getUser(int index){
        Call<List<User>> call = userApi.getUsers(index);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){

                    items.addAll(response.body());
                    adapter.notifyDataChanged();
                }else{
                    Log.e(TAG," Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG," Response Error "+t.getMessage());
            }
        });
    }

    public void getWareHouse(){
        Call<List<Warehouse>> call = wareHouseApi.getWareHouses(LIMINT,items.size());
        call.enqueue(new Callback<List<Warehouse>>() {
            @Override
            public void onResponse(Call<List<Warehouse>> call, Response<List<Warehouse>> response) {
                cancelar();
                if(response.isSuccessful()){

                    items.addAll(response.body());
                    adapter.notifyDataChanged();

                }else{
                    Log.e(TAG," Response Error "+String.valueOf(response.code()));
                    showMessage(" Response Error "+String.valueOf(response.code()));

                }
            }

            @Override
            public void onFailure(Call<List<Warehouse>> call, Throwable t) {
                Log.e(TAG," Response Error "+t.getMessage());
                showMessage(" Response Error "+t.getMessage());
                cancelar();
            }
        });
    }

    public void showMessage(String texto){
        Toast.makeText(context,texto,Toast.LENGTH_LONG).show();
    }


}
