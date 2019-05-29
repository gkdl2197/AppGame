package edu.android.appgame.game.game5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.android.appgame.R;

import static edu.android.appgame.game.game5.Game5MainActivity.CORRECT_SCORE;
import static edu.android.appgame.game.game5.Game5MainActivity.TOTAL_Q;

public class Game5ScoreActivity extends AppCompatActivity {
    private int score;
    private int total;
    private TextView textCount, textTotal,textScore;

    private int grade;
    private String stringGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5_score);

        score = getIntent().getIntExtra(CORRECT_SCORE,0);
        total = getIntent().getIntExtra(TOTAL_Q,0);
        textCount=findViewById(R.id.textCount);
        textTotal=findViewById(R.id.textTotal);
        textScore=findViewById(R.id.textScore);
        textCount.setText(score+"");
        textTotal.setText(total+"");
    }
    public void calScore(){
        grade = (score/total)*100;

        if(grade == 100) {
            textScore.setText("A");
        } else if(grade <=99 && grade > 80){
            textScore.setText("B");
        } else if(grade <= 80 && grade >60){
            textScore.setText("C");
        } else {
            textScore.setText("D");
        }

    }

    public void onClickbtnGoHome(View view) {
        Intent intent = new Intent (this, Game5MainActivity.class);
        startActivity(intent);
    }
}
