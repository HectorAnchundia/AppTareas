package com.example.tareas_java;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listviewTasks;
    private ArrayList<String> Tasks;
    private ArrayAdapter<String> TasksAdapter;
    private EditText txt_Task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listviewTasks = findViewById(R.id.lista_tareas);
        txt_Task = findViewById(R.id.txt_tarea);
        Button btn_add = findViewById(R.id.btn_agregar);

        Tasks = new ArrayList<>();

        TasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Tasks);

        listviewTasks.setAdapter(TasksAdapter);

        btn_add.setOnClickListener(v -> {
            String task = txt_Task.getText().toString();
            if (TextUtils.isEmpty(task)) {
                Toast.makeText(this, "No puedes agregar una tarea vacia", Toast.LENGTH_SHORT).show();
                } else {
                Tasks.add(task);

                TasksAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Tarea agregada", Toast.LENGTH_SHORT).show();
                txt_Task.setText("");

            }
        });
    }
}