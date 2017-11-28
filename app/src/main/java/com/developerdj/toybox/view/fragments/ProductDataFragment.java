package com.developerdj.toybox.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developerdj.toybox.R;

/**
 * Created by diego on 28/11/17.
 */

public class ProductDataFragment extends Fragment {


    public ProductDataFragment() {
        // Required empty public constructor

    }

    public static ProductDataFragment newInstance() {
        return new ProductDataFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_product_data, container, false);

        return root;
    }
}
