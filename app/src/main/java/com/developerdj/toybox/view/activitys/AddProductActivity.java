package com.developerdj.toybox.view.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.developerdj.toybox.R;
import com.developerdj.toybox.view.adapters.MiFragmentPagerAdapter;
import com.developerdj.toybox.view.fragments.ProductDataFragment;
import com.developerdj.toybox.view.fragments.ScannerFragment;

/**
 * Created by diego on 28/11/17.
 */

public class AddProductActivity extends AppCompatActivity {

    public static ViewPager viewPager;

    public static void createInstance(Context context) {

        Intent intent = new Intent(context, AddProductActivity.class);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        viewPager = (ViewPager) findViewById(R.id.viewpager_addproduct);

        MiFragmentPagerAdapter pagerAdapter = new MiFragmentPagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(ScannerFragment.newInstance(),"Escaner");
        pagerAdapter.addFragment(ProductDataFragment.newInstance(),"Datos del producto");

        viewPager.setAdapter(pagerAdapter);
    }
}
