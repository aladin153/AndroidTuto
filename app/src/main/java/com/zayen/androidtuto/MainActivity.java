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
import android.widget.ProgressBar;
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
    private boolean started = false;

    private void updateProgressBar(ProgressBar progress) throws InterruptedException {
        for(int i=0; i<=10; i++) {
            progress.setProgress(i*10);
            Log.d(TAG, "New progress value = " + i);
            Thread.sleep(5000);
        }
    }

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

        Button displayText = (Button) findViewById(R.id.display_text);
        EditText text = (EditText) findViewById(R.id.text);
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);


        displayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Display Text");
                Toast.makeText(getApplicationContext(), text.getText().toString(), Toast.LENGTH_SHORT).show();
                if (!started) {
                    new Thread(new Runnable() {
                        public void run(){
                            try {
                                updateProgressBar(progress);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }).start();
                    started = true;
                }
            }
        });




    }
}