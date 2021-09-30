package com.bogsnebes.mtstetajava.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.bogsnebes.mtstetajava.R;
import com.bogsnebes.mtstetajava.ui.movie_list.MovieListFragment;
import com.bogsnebes.mtstetajava.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MovieListFragment())
                .commit();
        bottomNavigationMenu = findViewById(R.id.bottomNavigationView);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.home):
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new MovieListFragment())
                        .commit();
                break;
            case (R.id.profile):
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ProfileFragment())
                        .commit();
                break;
        }
        return false;
    }
}