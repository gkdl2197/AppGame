package edu.android.appgame.game.game1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Random;

import edu.android.appgame.R;

public class QuizStart extends AppCompatActivity {

    private static final String TAG = "tag";
    public static final String TEXT_SCORE = "text_score";
    public static final String TEXT_BEST = "text_best";

    private HashSet set = new HashSet();
    private int index = 0;
    private TextView textQuiz, textHint;

    private String[] animalQuiz = {
            "ㅍㄱ","ㅂㄱㄱ","ㅎㄹㅇ","ㅈㅁ","ㅎㅂㄹㄱ","ㅁㄱㅎ","ㄱㅇㅈㅍ","ㅅㄴㅁ","ㅁ","ㄱㄹ"
    };

    private String[] animalHint = {
            "정답은 아무에게도 말하지 마세요..", "코카콜라 광고는 이녀석에게","콘푸로스트를 먹으면..!",
            "고백,사랑표현 하기 좋은 꽃","병진이형은 나가있어.. 뒤지기 싫으면","이 꽃 모르면 간첩",
            "이거로다가 살살 간지럽히면 세상 꿀잼","애국가 2절",
            "굳이 힌트가 필요하다면 크라잉 넛 대표곡 중 하나","이광수"
    };

    private String[] animalResult = {
            "펭귄","북극곰","호랑이","장미","해바라기","무궁화","강아지풀","소나무","말","기린"
    };


    private Random rnd;
    private Toast toast;
    private View layout;
    private Button btnCheck;
    private Button btnNext;
    private EditText textResult;
    private TextView textScore, textBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_anamal);

        textQuiz = findViewById(R.id.textQst);
        textHint = findViewById(R.id.textHint);
        btnNext = findViewById(R.id.btnNext);
        btnCheck = findViewById(R.id.btnCorrect);
        textResult = findViewById(R.id.editInput);
        textScore = findViewById(R.id.textScore);
        textBest = findViewById(R.id.textBest);

        textQuiz.setText(animalQuiz[index]);
        textHint.setText(animalHint[index]);

    } // end onCreate()

    public int calculate(){
        Log.i(TAG, "size : " + animalQuiz.length);
        rnd = new Random();
        int count1 = 0; // 현재 set에 있는 난수의 개수를 확인
        int count2 = 0; // 서로 다른 난수가 생성됐을때 set에 추가된 개수를 확인
        while (true) {
            count2 = set.size();
            Log.i(TAG, "count2 : " + count2);

            int x1 = rnd.nextInt(animalQuiz.length - 1) + 1; // 난수 생성
            set.add(x1); // 난수를 hashset에 추가
            count1 = set.size(); // 현재 set에 있는 난수의 개수 체크
            Log.i(TAG, "count1 : " + count1);
            if (count1 > count2) { // 현재 set에 있는 난수의 개수와 추가된 난수가 있는지 여부 확인
                index = x1;
                Log.i(TAG, "rnd : " + index);
                break;
            }
            if (set.size() == animalQuiz.length-1) {
//                btnNext.setEnabled(false);
//                btnCheck.setEnabled(false);
                Toast.makeText(this, "마지막 문제입니다...!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }

        return index;
    }

    public void nextGame(View view) {
        int index = calculate();
        textQuiz.setText(animalQuiz[index]);
        textHint.setText(animalHint[index]);

        btnNext.setEnabled(false);
        textResult.setText("");
        if (set.size() == animalQuiz.length) {
            btnNext.setEnabled(false);
            btnCheck.setEnabled(false);
        } else {
            btnCheck.setEnabled(true);
        }
    } // end nextGame()

    public void onClickResult(View view) {

        String inputData = textResult.getText().toString();
        String answer = animalResult[index];

//        Toast toastAnswer = Toast.makeText(this, "정답입니다!!\n축하합니다!", Toast.LENGTH_SHORT);
//        Toast toast = Toast.makeText(this, "땡!!!!!\n오답입니다..", Toast.LENGTH_SHORT);

        LayoutInflater inflater = getLayoutInflater();

        if (inputData.equals(answer)) {
            layout = inflater.inflate(R.layout.activity_game1_right, null);
            toast = new Toast(getApplicationContext());
            showToast();
            int score = Integer.parseInt(textScore.getText().toString());
            score++;
            textScore.setText(String.valueOf(score));
        } else {
            layout = inflater.inflate(R.layout.activity_game1_wrong, null);
            toast = new Toast(getApplicationContext());
            showToast();
        }

    }
    public void showToast(){
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,130);
        toast.setView(layout);
        toast.show();
        btnCheck.setEnabled(false);
        btnNext.setEnabled(true);
    }


    public void onClickGoMain(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        intent.putExtra(TEXT_SCORE, textScore.getText().toString());
        intent.putExtra(TEXT_BEST, textBest.getText().toString());
        finish();
    }
} // end class QuizStart















