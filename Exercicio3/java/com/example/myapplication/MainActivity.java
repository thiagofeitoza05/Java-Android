package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1;
    private EditText etNumber2;

    private TextView tvMaior;
    private TextView tvSoma;

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

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);

        tvMaior = findViewById(R.id.tvMaior);
        tvSoma = findViewById(R.id.tvSoma);

        Button btComparar = findViewById(R.id.btComparar);
        btComparar.setOnClickListener(op -> comp());

        Button btSomar = findViewById(R.id.btSomar);
        btSomar.setOnClickListener(op -> soma());


        }

    private void soma(){
            int numberA = Integer.parseInt(etNumber1.getText().toString());
            int numberB = Integer.parseInt(etNumber2.getText().toString());
            int maior, menor, i, impar = 0;

            if (numberA > numberB){
                maior = numberA;
                menor = numberB;
            } else {
                maior = numberB;
                menor = numberA;
            }

            for (i = menor; i < maior; i ++){
                if (i % 2 != 0){
                    impar += i;
                }
            }

            String resultado = "A soma é: " + impar;

            tvSoma.setText(resultado);
    }

    private void comp(){
            int number1 = Integer.parseInt(etNumber1.getText().toString());
            int number2 = Integer.parseInt(etNumber2.getText().toString());

            String res = "Os números são iguais";

            if (number1 > number2) {
                res = "O maior é: " + number1;
            } else if (number2 > number1) {
                res = "O maior é: " + number2;
            }

            tvMaior.setText(res);

    }
}