package com.example.sonny_cole.projet_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final List fragments;

    //On fournit à l'adapter la liste des fragments à afficher
    public MyPagerAdapter(FragmentManager fm, List fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public Fragment getItem(int position) {

        return new MyFragment();
    }


    @Override
    public String getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Frist";
            break;
            case 1:
                title = "Second";
            break;
            case 2:
                title = "Third";
            break;
            default:
                break;
        }
        return title;
    }


}