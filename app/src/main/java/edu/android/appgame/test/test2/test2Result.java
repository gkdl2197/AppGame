package edu.android.appgame.test.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.android.appgame.R;

import static edu.android.appgame.test.test2.test2Fragment.TOTAL_SCORE;

public class test2Result extends AppCompatActivity {

    private TextView textScore1, textGuide1;
    private int total;
    private test2Fragment test2 = new test2Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2_result);

        textScore1 = findViewById(R.id.textScore1);
        textGuide1 = findViewById(R.id.textGuide1);
        total = getIntent().getIntExtra(TOTAL_SCORE, 0);

        if (total >= 6) {
            textScore1.setText("우울증 점수: " + total);
            textGuide1.setText("정상입니다!");
        }
        if (total < 6) {
            textScore1.setText("우울증 점수: " + total);
            textGuide1.setText("(주의) 기억력 장애 의심 \n 실제 기억력 장애는 없고 우울증 등 다른 원인에 의해서도  " +
                    "높은 점수가 나올 수 있으므로 가급적 정보제공자 설문 혹은 \n 간이 인지기능검사와 함께 사용하는 것이 바람직하다.");

        }

    }

}
