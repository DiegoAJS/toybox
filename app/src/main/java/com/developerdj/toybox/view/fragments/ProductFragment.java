package com.developerdj.toybox.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developerdj.toybox.R;

/**
 * Created by diego on 25/11/17.
 */

public class ProductFragment extends Fragment {

    public ProductFragment() {
        // Required empty public constructor
    }

    public static ProductFragment newInstance() {
        return new ProductFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);

        return root;
    }
}
