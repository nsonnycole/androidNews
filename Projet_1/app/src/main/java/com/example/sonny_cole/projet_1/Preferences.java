package com.example.sonny_cole.projet_1;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

import static android.R.attr.id;

/**
 * Created by sonny-cole on 16/03/2017.
 */

public class Preferences extends PreferenceFragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        findPreference("notif")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        // afficher notif

                        NotificationCompat.Builder maNotif = new NotificationCompat.Builder(getActivity());
                        maNotif.setContentTitle("Nouveau msg")
                                .setContentText("Un text")
                                .setSmallIcon(R.mipmap.ic_launcher);

                        NotificationManager notificationManager =
                                (NotificationManager)
                                        getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                        notificationManager.notify(
                                id, maNotif.build());

                        return true;

                    }
                });
    }
}
