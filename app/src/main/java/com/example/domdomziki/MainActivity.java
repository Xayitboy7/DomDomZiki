package com.example.domdomziki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String[] choices = {"Tosh", "Qog'oz", "Qaychi"};

    int vinner = 0;
    int lose = 0;
    int durrang = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        resultTextView = findViewById(R.id.resultTextView);
        ImageButton rockButton = findViewById(R.id.rockButton);
        ImageButton paperButton = findViewById(R.id.paperButton);
        ImageButton scissorsButton = findViewById(R.id.scissorsButton);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Tosh");
                Toast.makeText(MainActivity.this, "You clicked Tosh", Toast.LENGTH_SHORT).show();
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Qog'oz");
                Toast.makeText(MainActivity.this, "You clicked Qog'oz", Toast.LENGTH_SHORT).show();
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Qaychi");
                Toast.makeText(MainActivity.this, "You clicked Qaychi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void playGame(String userChoice) {
        String computerChoice = choices[new
                Random().nextInt(choices.length)];
        String result;

        if (userChoice.equals(computerChoice)) {
            result = "Durrang! Kompyuter ham " + computerChoice + " harakatini tanladi.";
            durrang ++;
        } else if (
                (userChoice.equals("Tosh") &&
                        computerChoice.equals("Qaychi")) ||
                        (userChoice.equals("Qog'oz") &&
                                computerChoice.equals("Tosh")) ||
                        (userChoice.equals("Qaychi") &&
                                computerChoice.equals("Qog'oz"))) {
            result = "Siz yutdingiz! Kompyuter " + computerChoice + "harakatini tanladi.";
            vinner ++;
        } else {

            result = "Siz yutqazdingiz! Kompyuter " + computerChoice +
                    " harakatini tanladi.";
            lose ++;
        }
        resultTextView.setText(result);
        showDialog(result);
    }
    private void showDialog(String message) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("O'yin Natijasi")
                .setMessage("Yutish - " + vinner + "; Yutqazish - " + lose + "; Durrang! - " + durrang + "\n" + message)
                .setPositiveButton("OK", null)
                .show();
    }
}

