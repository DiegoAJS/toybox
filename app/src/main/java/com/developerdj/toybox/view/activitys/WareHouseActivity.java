package com.developerdj.toybox.view.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.developerdj.toybox.R;
import com.developerdj.toybox.control.ItemControl;
import com.developerdj.toybox.pojo.Warehouse;
import com.developerdj.toybox.view.adapters.ItemAdapterHolder;

/**
 * Created by diego on 27/11/17.
 */

public class WareHouseActivity extends AppCompatActivity{

    public static final String ID="warehouse.id";
    public static final String NAME="warehouse.name";
    public static final String ADDRESS="warehouse.address";
    public static final String GPS="warehouse.gps";
    public static final String MAX_CAPACITY="warehouse.max_capacity";
    public static final String MIN_CAPACITY="warehouse.min_capacity";
    public static final String DATE_INIT="warehouse.date_init";

    private FloatingActionButton add;
    private TextView titulo;
    private String text;
    private FloatingActionButton fab;
    private SearchView mSearchView;

    private Warehouse warehouse = new Warehouse();

    private ItemControl control=new ItemControl();

    public static void createInstanceP(Context context) {

        Intent intent = new Intent(context, WareHouseActivity.class);

        context.startActivity(intent);
    }

    public static void createInstance(Context context, Warehouse warehouse) {

        Intent intent = new Intent(context, WareHouseActivity.class);

        intent.putExtra(ID,warehouse.getId());
        intent.putExtra(NAME,warehouse.getName());
        intent.putExtra(ADDRESS,warehouse.getAddress());
        intent.putExtra(GPS,warehouse.getGps());
        intent.putExtra(MAX_CAPACITY,warehouse.getMax_capacity());
        intent.putExtra(MIN_CAPACITY,warehouse.getMin_capacity());
        intent.putExtra(DATE_INIT,warehouse.getDate_init());

        context.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        titulo=(TextView)findViewById(R.id.tv_titulo_warehouse);
        fab=(FloatingActionButton)findViewById(R.id.fab_warehouse);

        getWareHouse();

        setTitle("Almacen");
        titulo.setText("Lista de productos del "+warehouse.getName());

        control.setupActivity(this, ItemAdapterHolder.TYPE_PRODUCT,warehouse.getId());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddProductActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_buscar, menu);

        MenuItem item = menu.findItem(R.id.menu_search_warehoouse);
        mSearchView = (SearchView)item.getActionView();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //actualizarBuscador();
                show(text);
                mSearchView.setIconified(true);
                mSearchView.onActionViewCollapsed();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                text=newText.replace(" ","%20");
                return false;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_search_warehoouse:

                return true;
            case R.id.menu_scanner_warehoouse:
                show("Escaner");
                return true;
            case R.id.menu_edit_warehoouse:
                show("Editar");
                return true;
            case R.id.menu_delete_warehoouse:
                show("eliminar");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void show(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    public void getWareHouse(){
        Intent i = getIntent();

        warehouse.setId(i.getStringExtra(ID));
        warehouse.setName(i.getStringExtra(NAME));
        warehouse.setAddress(i.getStringExtra(ADDRESS));
        warehouse.setGps(i.getStringExtra(GPS));
        warehouse.setMax_capacity(i.getIntExtra(MAX_CAPACITY,0));
        warehouse.setMin_capacity(i.getIntExtra(MIN_CAPACITY,0));
        warehouse.setDate_init(i.getStringExtra(DATE_INIT));


    }



}
