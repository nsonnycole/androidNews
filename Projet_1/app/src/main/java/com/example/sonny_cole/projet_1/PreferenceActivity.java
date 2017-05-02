package com.example.sonny_cole.projet_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sonny-cole on 16/03/2017.
 */

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mes_preferences);

        getFragmentManager().beginTransaction()
                .replace(R.id.containerPrefs, new Preferences())
                .commit();
    }
}
