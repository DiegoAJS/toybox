package com.developerdj.toybox.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developerdj.toybox.R;
import com.developerdj.toybox.control.ItemControl;
import com.developerdj.toybox.view.adapters.ItemAdapterHolder;

/**
 * Created by diego on 25/11/17.
 */

public class WareHouseFragment extends Fragment {

    private ItemControl control;

    public WareHouseFragment() {
        // Required empty public constructor
        control=new ItemControl();
    }

    public static WareHouseFragment newInstance() {
        return new WareHouseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);
        control.setupFragment(getActivity(),root,getFragmentManager(), ItemAdapterHolder.TYPE_WAREHOUSE);
        return root;
    }
}
