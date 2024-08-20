package com.zayen.androidtuto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AndroidTraining";
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

        Button addName = (Button) findViewById(R.id.add_name);
        EditText newName = (EditText) findViewById(R.id.new_name);
        ListView names = (ListView) findViewById(R.id.names);
        Vector<String> names_vector = new Vector<>();
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, names_vector);
        names.setAdapter(arr);

        addName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Adding New name");
                names_vector.add(newName.getText().toString());
                names.setAdapter(arr);
            }
        });




    }
}