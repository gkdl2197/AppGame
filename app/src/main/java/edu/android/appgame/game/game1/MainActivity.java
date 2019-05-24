package edu.android.appgame.game.game1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.android.appgame.R;

import static edu.android.appgame.game.game1.QuizStart.TEXT_BEST;
import static edu.android.appgame.game.game1.QuizStart.TEXT_SCORE;

public class MainActivity extends AppCompatActivity {

    private String animal_score;
    private String animal_best;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animal_best = getIntent().getStringExtra(TEXT_BEST);
        animal_score = getIntent().getStringExtra(TEXT_SCORE);


    }

    public void firstGame(View view) {
        finish();
       Intent intent = new Intent(this, QuizStart.class);
       startActivity(intent);
    }
    public void twoGame(View view) {
        finish();
        Intent intent = new Intent(this,MainKorea.class);
        startActivity(intent);
    }
    public void threeGame(View view) {
        finish();
        Intent intent = new Intent(this,MainItwill.class);
        startActivity(intent);
    }
    public void resultGame(View view) {
        finish();
        Intent intent = new Intent(this,MainResult.class);
        startActivity(intent);
    }
}
