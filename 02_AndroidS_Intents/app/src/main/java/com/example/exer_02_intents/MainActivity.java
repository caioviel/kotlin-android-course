package com.example.exer_02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    static private Vector<MathChallenge> challegens;
    {
        challegens = new Vector<MathChallenge>();
        challegens.add(new MathChallenge("2 + 2", 4));
        challegens.add(new MathChallenge("10 + 2", 12));
        challegens.add(new MathChallenge("5 - 5", 0));
        challegens.add(new MathChallenge("100 - 93", 7));
        challegens.add(new MathChallenge("3 * 9", 27));
        challegens.add(new MathChallenge("7 * 6", 42));
        challegens.add(new MathChallenge("75 / 15", 5));
        challegens.add(new MathChallenge("18 / 3", 6));
        challegens.add(new MathChallenge("5!", 120));
        challegens.add(new MathChallenge("3!", 6));
        challegens.add(new MathChallenge("2 ^ 0", 1));
        challegens.add(new MathChallenge("2 ^ 4", 16));
        challegens.add(new MathChallenge("Raiz quadrada de 25", 5));
        challegens.add(new MathChallenge("Raiz quadrada de 64", 8));
        challegens.add(new MathChallenge("5 * 2 + 4", 14));
        challegens.add(new MathChallenge("4 + 2 * 5", 14));
        challegens.add(new MathChallenge("4 / 4 + 5 - 3?", 3));
        challegens.add(new MathChallenge("2 * (2 + 2) - 9 / 3", 5));
    }

    private MathChallenge challenge;
    private TextView txtQuestion;
    private EditText txtAnswer;

    static private MathChallenge getRandomMathChallenge()
    {
        Random random = new Random();
        Integer index = random.nextInt(MainActivity.challegens.size());
        return MainActivity.challegens.get(index);
    }

    private void refreshChallange() {
        challenge = getRandomMathChallenge();
        txtQuestion.setText(challenge.getQuestion());
        txtAnswer.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtQuestion = findViewById(R.id.txtQuestion);
        this.txtAnswer = findViewById(R.id.txtAnswer);

        findViewById(R.id.btnCheck).setOnClickListener(v -> onBtnCheckClicked());
        findViewById(R.id.btnClear).setOnClickListener(v -> onBtnClearClicked());
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshChallange();
    }

    private void onBtnClearClicked() {
        txtAnswer.setText("");
    }

    public void onBtnCheckClicked() {
        Integer userAnswer = Integer.parseInt(txtAnswer.getText().toString());

        if (challenge.getAnswer() == userAnswer) {
            Intent intent = new Intent(this, CongratulationsActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.error_message), Toast.LENGTH_SHORT).show();
            txtAnswer.setText("");
        }
    }
}