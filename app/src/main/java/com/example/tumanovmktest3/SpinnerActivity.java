package com.example.tumanovmktest3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity {

    private final String[] paths = {
            "Охота", "Разрушение", "Эрудиция",
            "Гармония", "Небытие", "Изобилие", "Сохранение"
    };

    private final String[] pathDescriptions = {
            "Охота — путь прицельного разрушения и непреклонной воли. " +
            "Носители этого пути — искусные охотники, которые разят одиночные цели с хирургической точностью. ",

            "Разрушение — путь разрушительной силы и хаоса. " +
            "Носители черпают мощь из собственного тела, нередко жертвуя HP ради урона. ",

            "Эрудиция — путь знаний и интеллекта. " +
            "Носители наносят урон сразу по всем врагам, используя науку и магию. ",

            "Гармония — путь сотрудничества и поддержки союзников. " +
            "Носители усиливают команду, увеличивая её атаку, скорость и общую эффективность. ",

            "Небытие — путь яда, деградации и постепенного разрушения. " +
            "Носители ослабляют врагов дебаффами и наносят урон со временем. ",

            "Изобилие — путь жизни и исцеления. " +
            "Носители восстанавливают HP союзников и обеспечивают долговечность команды в бою. ",

            "Сохранение — путь защиты и стойкости. " +
            "Носители поглощают урон за союзников, создают щиты и являются опорой команды. "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = findViewById(R.id.pathSpinner);
        TextView descriptionView = findViewById(R.id.pathDescription);
        TextView selectedPathView = findViewById(R.id.selectedPath);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPathView.setText("Выбранный путь: " + paths[position]);
                descriptionView.setText(pathDescriptions[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedPathView.setText("");
                descriptionView.setText("");
            }
        });
    }
}
