package com.developerdj.toybox.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 13/4/2017.
 */

public class MiFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments=null;
    private List<String> titulos=null;

    public static MiFragmentPagerAdapter getInstance(FragmentManager fm){
        return new MiFragmentPagerAdapter(fm);
    }

    /** Constructor of the class */
    public MiFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<Fragment>();
        titulos=new ArrayList<String>();
    }

    public void addFragment(Fragment fragmento,String texto) {
        fragments.add(fragmento);
        titulos.add(texto);
    }

    /** This method will be invoked when a page is requested to create */
    @Override
    public Fragment getItem(int arg0) {

        return (Fragment) fragments.get(arg0);
    }

    /** Returns the number of pages */
    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
        //return null;
    }
}
