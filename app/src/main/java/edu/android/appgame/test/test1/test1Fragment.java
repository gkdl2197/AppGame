package edu.android.appgame.test.test1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.android.appgame.R;

public class test1Fragment extends Fragment {

    private static final String[]  SURVEY_TEXT= {
            "오늘이 몇 월이고, 무슨 요일인지 잘 모른다",
            "자기가 놔둔 물건을 찾지 못한다.",
            "같은 질문을 반복해서 한다.",
            "약속을 하고서 잊어버린다.",
            "물건을 가지러 갔다가 잊어버리고 그냥 온다.",
            "물건이나 사람의 이름을 대기가 힘들어 머뭇거린다.",
            "대화 중 내용이 이해되지 않아 반복해서 물어본다.",
            "길을 잃거나 헤맨 적이 있다.",
            "예전에 비해서 계산능력이 떨어졌다.\n" +
                    "(예: 물건값이나 거스름돈 계산을 못한다.)",
            "예전에 비해 성격이 변했다.",
            "이전에 잘 다루던 기구의 사용이 서툴러졌다.\n" +
                    "(세탁기, 전기밥솥, 경운기 등)",
            "예전에 비해 방이나 집안의 정리 정돈을 하지 못한다.",
            "상황에 맞게 스스로 옷을 선택하여 입지 못한다.",
            "혼자 대중교통 수단을 이용하여 목적지에 가기 힘들다.\n" +
                    "(관절염 등 신체적인 문제로 인한 것은 제외)",
            "내복이나 옷이 더러워져도 갈아입지 않으려고 한다."

    };
    public static final String TOTAL_SCORE = "total_score";
    private int currentIndex = 0;
    private  static  final  String KEY_INDEX="current_index";
    private TextView textSurvey3;
    private RadioButton radioNever,radioSomtimes, radioOften;
    private Button btnNext;
    private int testScore=0;

    public test1Fragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_test1_fragment,container2,false);
        textSurvey3= view.findViewById(R.id.textSurvey3);
        radioNever= view.findViewById(R.id.radioNever);
        radioSomtimes=  view.findViewById(R.id.radioSometimes);
        radioOften = view.findViewById(R.id.radioOften);
        btnNext = view.findViewById(R.id.btnNext);

        if(savedInstanceState != null){
            currentIndex =savedInstanceState.getInt(KEY_INDEX);
            changeText();
        }

        textSurvey3.setText(SURVEY_TEXT[0]);
        return  view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    private void showNextText() {
        if(currentIndex<SURVEY_TEXT.length-1){
            currentIndex++;
            changeText();
            if(radioNever.isChecked()){
                radioNever.setChecked(false);
            } if(radioSomtimes.isChecked()){
                radioSomtimes.setChecked(false);
               } if (radioOften.isChecked()) {
                radioOften.setChecked(false);

            }
        }else{
            btnNext.setEnabled(false);
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.getContext());
            alertDialog.setTitle("검사결과창");
            alertDialog.setMessage("마지막 문제 입니다. 결과를 보시겠습니까?")
                    .setCancelable(false)
                    .setPositiveButton("예",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(getActivity(), test1Result.class);
                                    intent.putExtra(TOTAL_SCORE, testScore);
                                    startActivity(intent);
                                }
                            });
            alertDialog.create();
            alertDialog.show();
        }
    }

    private void changeText() {
        textSurvey3.setText(SURVEY_TEXT[currentIndex]);
    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioNever.isChecked()){
                    testScore += 0;
                }else if(radioSomtimes.isChecked()){
                    testScore += 1;
                } else if (radioOften.isChecked()) {
                    testScore += 2;
                }
                if( radioNever.isChecked() == false && radioSomtimes.isChecked() == false && radioOften.isChecked() == false){
                    Toast.makeText(getActivity(), "체크를 하신 후 다음문제로 넘어가실 수 있습니다.", Toast.LENGTH_SHORT).show();
                } else if (radioNever.isChecked() || radioSomtimes.isChecked() || radioOften.isChecked()){
                    showNextText();
                }
            }
        });
    }

}
