package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void calcularFibonacci(View view) {
        String input = editTextNumber.getText().toString();

        textViewResult.setText("Insira um número.");

        int n = Integer.parseInt(input);
        if (n <= 0 || n >= 20) {
            textViewResult.setText("Digite um número de 1 a 19.");
            return;
        }
        StringBuilder result = new StringBuilder();
        int primeiro = 0, segundo = 1;
        for (int i = 1; i <= n; ++i) {
            result.append(primeiro).append(", ");
            int prox = primeiro + segundo;
            primeiro = segundo;
            segundo = prox;
        }

        textViewResult.setText(n + " termo:\n" + result.toString());
    }
}
