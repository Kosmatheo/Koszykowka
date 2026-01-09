package com.example.koszykowkakosmy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView liczba;
    private Button plus1;
    private Button plus2;
    private Button plus3;
    private int liczb = 0;

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
        liczba = findViewById(R.id.tekst);
        plus1 = findViewById(R.id.button);
        plus2 = findViewById(R.id.button2);
        plus3 = findViewById(R.id.button3);
        if(savedInstanceState != null){
            liczb = savedInstanceState.getInt("LICZB");
            liczba.setText(Integer.toString(liczb));
        }
        plus1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liczb++;
                        liczba.setText(""+liczb);
                    }
                }
        );
        plus2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liczb+=2;
                        liczba.setText(""+liczb);
                    }
                }
        );
        plus3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liczb+=3;
                        liczba.setText(""+liczb);
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("LICZB",liczb);
    }
}