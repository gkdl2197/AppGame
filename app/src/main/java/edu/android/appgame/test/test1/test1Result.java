package edu.android.appgame.test.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.android.appgame.R;
import static edu.android.appgame.test.test3.test3Fragment.TOTAL_SCORE;

public class test1Result extends AppCompatActivity {

    private TextView textScore, textGuide;
    private int total;
    private test1Fragment test1 = new test1Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_result);

        textScore = findViewById(R.id.textScore);
        textGuide = findViewById(R.id.textGuide);
        total = getIntent().getIntExtra(TOTAL_SCORE, 0);

        if (total > 0 && total < 7) {
            textScore.setText("점수: " + total);
            textGuide.setText("치매가 아닌 것으로 보입니다. 그래도 늘 신경쓰세요!");
        }
        if (total >= 7 && total <= 30) {
            textScore.setText("점수: " + total);
            textGuide.setText("치매가 의심됩니다. 반드시 병원이나 센터에 찾아가보세요!");
        }
    }

}