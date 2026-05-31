package com.example.tumanovmktest3;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CharacterModel> characters = buildCharacterList();
        CharacterAdapter adapter = new CharacterAdapter(characters);
        recyclerView.setAdapter(adapter);
    }

    private List<CharacterModel> buildCharacterList() {
        List<CharacterModel> list = new ArrayList<>();

        int huntColor        = Color.parseColor("#4CAF50"); // зелёный — Охота
        int destructionColor = Color.parseColor("#F44336"); // красный — Уничтожение
        int eruditionColor   = Color.parseColor("#2196F3"); // синий — Эрудиция
        int harmonyColor     = Color.parseColor("#FFC107"); // жёлтый — Гармония
        int nihilityColor    = Color.parseColor("#9C27B0"); // фиолетовый — Нигилизм
        int abundanceColor   = Color.parseColor("#009688"); // бирюзовый — Изобилие
        int preservationColor= Color.parseColor("#FF9800"); // оранжевый — Сохранение

        list.add(new CharacterModel("Дань Хэн",               "Охота",         huntColor));
        list.add(new CharacterModel("Зеле",                    "Охота",         huntColor));
        list.add(new CharacterModel("Бутхилл",                 "Охота",         huntColor));
        list.add(new CharacterModel("Топаз",                   "Охота",         huntColor));
        list.add(new CharacterModel("Клара",                   "Разрушение",    destructionColor));
        list.add(new CharacterModel("Блэйд",                   "Разрушение",    destructionColor));
        list.add(new CharacterModel("Светлячок",               "Разрушение",    destructionColor));
        list.add(new CharacterModel("Фаэнон",                  "Разрушение",    destructionColor));
        list.add(new CharacterModel("Химеко",                  "Эрудиция",      eruditionColor));
        list.add(new CharacterModel("Яшма",                    "Эрудиция",      eruditionColor));
        list.add(new CharacterModel("Аргенти",                 "Эрудиция",      eruditionColor));
        list.add(new CharacterModel("Герта",                   "Эрудиция",      eruditionColor));
        list.add(new CharacterModel("Броня",                   "Гармония",      harmonyColor));
        list.add(new CharacterModel("Зарянка",                 "Гармония",      harmonyColor));
        list.add(new CharacterModel("Жуань Мэй",               "Гармония",      harmonyColor));
        list.add(new CharacterModel("Воскресенье",             "Гармония",      harmonyColor));
        list.add(new CharacterModel("Кафка",                   "Небытие",       nihilityColor));
        list.add(new CharacterModel("Чёрный лебедь",           "Небытие",       nihilityColor));
        list.add(new CharacterModel("Гуйнайфэнь",              "Небытие",       nihilityColor));
        list.add(new CharacterModel("Байлу",                   "Изобилие",      abundanceColor));
        list.add(new CharacterModel("Лоча",                    "Изобилие",      abundanceColor));
        list.add(new CharacterModel("Хо Хо",                   "Изобилие",      abundanceColor));
        list.add(new CharacterModel("Галлахер",                "Изобилие",      abundanceColor));
        list.add(new CharacterModel("Фу Сюань",                "Сохранение",      preservationColor));
        list.add(new CharacterModel("Авантюрин",               "Сохранение",      preservationColor));
        list.add(new CharacterModel("Освободитель Пустошей",   "Сохранение",      preservationColor));

        return list;
    }
}
