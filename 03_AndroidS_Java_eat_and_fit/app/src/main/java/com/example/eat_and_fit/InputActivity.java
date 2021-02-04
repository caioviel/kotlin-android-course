package com.example.eat_and_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class InputActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "InputActivity_EXTRA_PERSON";
    private Vector<EditText> fields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button btnResults = findViewById(R.id.btn_results);
        btnResults.setOnClickListener(v -> onResultsButton());

        Button btnCalculator = findViewById(R.id.btn_calculator);
        btnCalculator.setOnClickListener(v -> onCalculatorButton());

        fields = new Vector<EditText>(3);
        fields.add(findViewById(R.id.txt_weight));
        fields.add(findViewById(R.id.txt_height));
        fields.add(findViewById(R.id.txt_age));
    }

    private void onCalculatorButton() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



    private void onResultsButton() {
        if (checkForInputs()) {
            double weight = Double.parseDouble(fields.get(0).getText().toString());
            double height = Double.parseDouble(fields.get(1).getText().toString());
            int age = Integer.parseInt(fields.get(2).getText().toString());
            Person person = new Person(weight, height, age);

            Intent intent = new Intent(this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(EXTRA_PERSON, person);
            intent.putExtra(EXTRA_PERSON, bundle);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkForInputs() {
        for (EditText field : fields) {
            if (field.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}