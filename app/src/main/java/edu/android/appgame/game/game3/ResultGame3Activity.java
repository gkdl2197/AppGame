package edu.android.appgame.game.game3;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.android.appgame.R;
import edu.android.appgame.game.GameDao;

import static edu.android.appgame.game.game3.MainGame3Activity.CORRECT_SCORE;
import static edu.android.appgame.game.game3.MainGame3Activity.TOTAL_Q;


public class ResultGame3Activity extends AppCompatActivity {

    private static final String TAG = "debug";
    public static final String GAME_COUNT = "game_count";
    private int score;
    private int total;
    private TextView textCount, textTotal;
    private ImageView imageGrade;
    private int grade;
    private String stringGrade;
    private GameDao dao = GameDao.getInstance(this);
    private int gameCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_result);

        textCount = findViewById(R.id.textCount);
        textTotal = findViewById(R.id.textTotal);
        imageGrade = findViewById(R.id.imageGrade);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorDarkBlue)));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

        score = getIntent().getIntExtra(CORRECT_SCORE,0);
        total = getIntent().getIntExtra(TOTAL_Q,0);
        gameCount = getIntent().getIntExtra(GAME_COUNT, 0);

        textCount.setText(score+"");
        textTotal.setText(total+"");

        calScore();

    }// end onCreate()

    public void calScore(){
        grade = (score/total)*100;

        if(grade == 100) {
            imageGrade.setImageResource(R.drawable.game3_alphabet_a);
            stringGrade = "A";
        } else if(grade <=99 || grade > 80){
            imageGrade.setImageResource(R.drawable.game3_alphabet_b);
            stringGrade = "B";
        } else if(grade <= 80 || grade >60){
            imageGrade.setImageResource(R.drawable.game3_alphabet_c);
            stringGrade = "C";
        } else {
            imageGrade.setImageResource(R.drawable.game3_alphabet_d);
            stringGrade = "D";
        }

        try {
            dao.saveScoreToFileByGames("word",gameCount, stringGrade);
            Log.i(TAG, "성공");
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // end calScore()

    public void onClickHome(View view) {

        //TODO 합치고 나서 게임 홈(리스트)로 가는 코드 작성하기!!!!!!!!!
        Intent intent = new Intent();

        finish();
    }

    public void onClickRestart(View view) {

        Intent intent = new Intent(this, MainGame3Activity.class);
        startActivity(intent);
        finish();
    }
} // end class ResultGame3Activity
