package com.example.tumanovmktest3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String[] paths = {
            "Охота", "Разрушение", "Эрудиция",
            "Гармония", "Небытие", "Изобилие", "Сохранение"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.pathListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, paths);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("path_name", paths[position]);
                startActivity(intent);
            }
        });
    }

    public void openRecycler(View view) {
        startActivity(new Intent(this, RecyclerActivity.class));
    }

    public void openScroll(View view) {
        startActivity(new Intent(this, ScrollActivity.class));
    }

    public void openSpinner(View view) {
        startActivity(new Intent(this, SpinnerActivity.class));
    }
}
