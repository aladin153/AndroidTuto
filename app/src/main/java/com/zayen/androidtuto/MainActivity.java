package com.zayen.androidtuto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

        Button set = (Button) findViewById(R.id.btn_set);
        Button get = (Button) findViewById(R.id.btn_get);
        EditText newName = (EditText) findViewById(R.id.new_name);
        TextView savedName = (TextView) findViewById(R.id.saved_name);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Set Button Clicked");
                // Storing data into SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("SPTest",MODE_PRIVATE);
                // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                // Storing the key and its value as the data fetched from edittext
                myEdit.putString("full_name", newName.getText().toString());
                // Once the changes have been made, we need to commit to apply those changes made,
                // otherwise, it will throw an error
                myEdit.commit();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Set Button Clicked");
                // Retrieving the value using its keys the file name must be same in both saving and retrieving the data
                SharedPreferences sh = getSharedPreferences("SPTest", MODE_APPEND);
                // The value will be default as empty string because for the very
                // first time when the app is opened, there is nothing to show
                String s1 = sh.getString("full_name", "");
                // We can then use the data
                savedName.setText(s1);
            }
        });
    }
}