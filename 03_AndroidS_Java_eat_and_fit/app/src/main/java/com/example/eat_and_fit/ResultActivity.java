package com.example.eat_and_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(InputActivity.EXTRA_PERSON);
        Person person = bundle.getParcelable(InputActivity.EXTRA_PERSON);

        BMICalculator calculator = new BMICalculator();
        BMICalculator.BMIResult result = calculator.calcBMI(person);

        TextView lblResults = findViewById(R.id.lbl_result);
        lblResults.setText(createResultString(result));

        findViewById(R.id.btn_voltar).setOnClickListener(v -> onBackButton());
        findViewById(R.id.btn_email).setOnClickListener(v -> onEmailButton());
    }

    private void onEmailButton() {
        Toast.makeText(this, "E-mail enviado!", Toast.LENGTH_SHORT).show();
    }

    private void onBackButton() {
        finish();
    }

    private String createResultString(BMICalculator.BMIResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append("Seu IMC é: ");
        sb.append(String.format("%.2f", result.getValue()));
        sb.append("\nVocê está: ");
        sb.append(result.getStatus().ptLabel);
        sb.append("\n\nClica no botão abaixo receber por e-mail " +
                "um cardápio semanal feito sub medida para você!");

        return sb.toString();
    }
}