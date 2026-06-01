package com.example.tumanovmktest3;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class CategoryActivity extends AppCompatActivity {

    private ArrayList<String> characters = new ArrayList<>();
    private ArrayList<String> selectedCharacters = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private String pathName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        pathName = getIntent().getStringExtra("path_name");
        if (pathName == null) pathName = "Неизвестный";

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(pathName);
        }

        TextView titleView = findViewById(R.id.pathTitle);
        titleView.setText("Путь: " + pathName);

        loadCharacters(pathName);

        listView = findViewById(R.id.characterListView);
        View addDeleteLayout = findViewById(R.id.addDeleteLayout);

        if ("Охота".equals(pathName)) {
            addDeleteLayout.setVisibility(View.VISIBLE);
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_multiple_choice, characters);
            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String character = adapter.getItem(position);
                    if (listView.isItemChecked(position)) {
                        selectedCharacters.add(character);
                    } else {
                        selectedCharacters.remove(character);
                    }
                }
            });
        } else {
            addDeleteLayout.setVisibility(View.GONE);
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, characters);
        }

        listView.setAdapter(adapter);
    }

    private void loadCharacters(String path) {
        switch (path) {
            case "Охота":
                characters.addAll(Arrays.asList(
                        "Дань Хэн", "Зеле", "Яньцин",
                        "Доктор Рацио", "Бутхилл", "Март 7",
                        "Топаз"));
                break;
            case "Разрушение":
                characters.addAll(Arrays.asList(
                        "Клара", "Арлан",
                        "Блэйд", "Цзинлю", "Светлячок", "Фаэнон"));
                break;
            case "Эрудиция":
                characters.addAll(Arrays.asList(
                        "Химеко", "Яшма", "Аргенти",
                        "Цзин Юань", "Герта", "Великая Герта"));
                break;
            case "Гармония":
                characters.addAll(Arrays.asList(
                        "Броня", "Зарянка", "Ханья", "Тиньюнь",
                        "Воскресенье", "Жуань Мэй", "Искорка"));
                break;
            case "Небытие":
                characters.addAll(Arrays.asList(
                        "Кафка", "Чёрный лебедь",
                        "Гуйнайфэнь", "Лука", "Ахерон"));
                break;
            case "Изобилие":
                characters.addAll(Arrays.asList(
                        "Байлу", "Наташа", "Лоча",
                        "Хо Хо", "Галлахер", "Линша", "Рысь"));
                break;
            case "Сохранение":
                characters.addAll(Arrays.asList(
                        "Март 7 (Сохранение)", "Гепард", "Фу Сюань",
                        "Авантюрин", "Освободитель Пустошей", "Первопроходец (Сохранение)"));
                break;
            default:
                characters.add("Персонажи не найдены");
        }
    }

    public void addCharacter(View view) {
        EditText editText = findViewById(R.id.newCharacterInput);
        String name = editText.getText().toString().trim();
        if (!name.isEmpty()) {
            adapter.add(name);
            editText.setText("");
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeCharacters(View view) {
        for (int i = 0; i < selectedCharacters.size(); i++) {
            adapter.remove(selectedCharacters.get(i));
        }
        listView.clearChoices();
        selectedCharacters.clear();
        adapter.notifyDataSetChanged();
    }
}
