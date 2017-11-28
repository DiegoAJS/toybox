package com.developerdj.toybox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.developerdj.toybox.data.service.MoviesApi;
import com.developerdj.toybox.data.service.ServiceGenerator;
import com.developerdj.toybox.pojo.Carrera;
import com.developerdj.toybox.view.activitys.WareHouseActivity;
import com.developerdj.toybox.view.adapters.MiFragmentPagerAdapter;
import com.developerdj.toybox.view.fragments.WareHouseFragment;
import com.developerdj.toybox.view.fragments.UserFragment;
import com.developerdj.toybox.view.fragments.OrderProductFragment;
import com.developerdj.toybox.view.fragments.UsersFragment;
import com.developerdj.toybox.view.fragments.StoreFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG=MainActivity.class.getSimpleName();

    private ViewPager viewPager;
    private BottomNavigationView navigation;

    private FloatingActionButton boton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_almacen:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_tienda:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_pedidos:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_colaboradores:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.navigation_perfil:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        boton = (FloatingActionButton)findViewById(R.id.fab);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        MiFragmentPagerAdapter pagerAdapter = new MiFragmentPagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(WareHouseFragment.newInstance(),"Almacen");
        pagerAdapter.addFragment(StoreFragment.newInstance(),"Tienda");
        pagerAdapter.addFragment(OrderProductFragment.newInstance(),"Pedidos");
        pagerAdapter.addFragment(UsersFragment.newInstance(),"Colaboradores");
        pagerAdapter.addFragment(UserFragment.newInstance(),"Perfil");

        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:navigation.setSelectedItemId(R.id.navigation_almacen);break;
                    case 1:navigation.setSelectedItemId(R.id.navigation_tienda);break;
                    case 2:navigation.setSelectedItemId(R.id.navigation_pedidos);break;
                    case 3:navigation.setSelectedItemId(R.id.navigation_colaboradores);break;
                    case 4:navigation.setSelectedItemId(R.id.navigation_perfil);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //WareHouseActivity.createInstanceP(getApplicationContext());
                Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WareHouseActivity.class);
                startActivity(intent);

            }
        });

    }

}
