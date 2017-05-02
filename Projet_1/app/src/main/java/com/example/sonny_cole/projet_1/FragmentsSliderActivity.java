package com.example.sonny_cole.projet_1;

/**
 * Created by sonny-cole on 15/03/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;
import java.util.Vector;

public class FragmentsSliderActivity extends AppCompatActivity {

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.viewpager);

        // Création de la liste de Fragments que fera défiler le PagerAdapter
        List fragments = new Vector();

        // Ajout des Fragments dans la liste
        fragments.add(Fragment.instantiate(this,MyFragment.class.getName()));
        fragments.add(Fragment.instantiate(this,WebviewFragment.class.getName()));



        // Création de l'adapter qui s'occupera de l'affichage de la liste de
        // Fragments
        this.mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
           return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, PreferenceActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
