package edu.android.appgame.game.game1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.android.appgame.R;

import static edu.android.appgame.game.game1.Main0Animal.TEXT_BEST;
import static edu.android.appgame.game.game1.Main0Animal.TEXT_SCORE;

public class Main0Activity extends AppCompatActivity {

    private String animal_score;
    private String animal_best;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_main);

        animal_best = getIntent().getStringExtra(TEXT_BEST);
        animal_score = getIntent().getStringExtra(TEXT_SCORE);

    }

    public void firstGame(View view) {
        finish();
       Intent intent = new Intent(this, Main0Animal.class);
       startActivity(intent);
    }
    public void twoGame(View view) {
        finish();
        Intent intent = new Intent(this, Main0Korea.class);
        startActivity(intent);
    }
    public void threeGame(View view) {
        finish();
        Intent intent = new Intent(this, Main0Itwill.class);
        startActivity(intent);
    }
    public void resultGame(View view) {
        finish();
        Intent intent = new Intent(this, Main0Result.class);
        startActivity(intent);
    }
}
