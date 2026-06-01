package com.example.tumanovmktest3;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Настраиваем ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Главная");
        }

        // Загружаем фрагмент по умолчанию
        loadFragment(new HomeFragment());

        // Настраиваем BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            ActionBar ab = getSupportActionBar();
            if (item.getItemId() == R.id.nav_home) {
                loadFragment(new HomeFragment());
                if (ab != null) ab.setTitle("Главная");
                return true;
            } else if (item.getItemId() == R.id.nav_team) {
                loadFragment(new TeamFragment());
                if (ab != null) ab.setTitle("Отряд");
                return true;
            } else if (item.getItemId() == R.id.nav_shop) {
                loadFragment(new ShopFragment());
                if (ab != null) ab.setTitle("Магазин");
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.second_content_frame, fragment);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
