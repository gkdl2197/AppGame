package edu.android.appgame.game.game2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import edu.android.appgame.R;
import static edu.android.appgame.game.game2.Main3Activity.SCORE_CHO;


public class Result3Activity extends AppCompatActivity {

    private TextView textResult;
    private Button btnRetry;
    SharedPreferences spf = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_result3);

        textResult = findViewById(R.id.textResult);
        btnRetry = findViewById(R.id.btnRetry);
        spf = getSharedPreferences("spfScore", MODE_PRIVATE);

        int score_cho = getIntent().getIntExtra(SCORE_CHO,0);
        int score = 60 - score_cho;
        textResult.setText("걸린 시간: " + score + "초");

//        if(spf.getInt("spfscore",0) < score){ //내점수가 저번 점수보다 크면
//            spf.edit().putInt("spfscore",score).commit(); //반영의 commit(). 현재상태 저장
//            textResult.setText("신기록달성\n"+score);
//        }


        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result3Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
