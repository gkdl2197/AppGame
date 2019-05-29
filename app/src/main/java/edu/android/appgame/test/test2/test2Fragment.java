package edu.android.appgame.test.test2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.android.appgame.R;



public class test2Fragment extends Fragment {

    private static final String[] Memory =
            {"자신의 기억력에 문제가 있다고 생각하십니까?",
             "자신의 기억력이 10년 전보다 나빠졌다고 생각하십니까?",
             "자신의 기억력이 같은 또래의 다른 사람들에 비해 나쁘다고 생각하십니까?",
             "기억력 저하로 인해 일상생활에 불편을 느끼십니까?",
             "최근에 일어난 일을 기억하는 것이 어렵습니까?",
             "며칠 전에 나눈 대화 내용을 기억하기 어렵습니까?",
             "며칠 전에 한 약속을 기억하기 어렵습니까?",
             "친한 사람의 이름을 기억하기 어렵습니까?",
             "물건 둔 곳을 기억하기 어렵습니까?",
             "이전에 비해 물건을 자주 잃어버립니까?",
             "집 근처에서 길을 잃은 적이 있습니까?",
             "가게에서 2-3가지 물건을 사려고 할 때 물건이름을 기억하기 어렵습니까?",
             "가스불이나 전기불 끄는 것을 기억하기 어렵습니까?",
             "자주 사용하는 전화번호(자신 혹은 자녀의 집)를 기억하기 어렵습니까?"
            };
    public static final String TOTAL_SCORE="total_score";
    private int currentIndex = 0;
    private  static  final  String KEY_INDEX="current_index";
    private TextView textSurvey,textresult;
    private RadioButton radioYes,radioNo;
    private Button btnNext;
    private int testScore=0;

    public test2Fragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_test2_fragment,container2,false);
        textSurvey = view.findViewById(R.id.textSurvey1);
        radioYes= view.findViewById(R.id.radioNever);
        radioNo=  view.findViewById(R.id.radioYes);
        btnNext=  view.findViewById(R.id.btnNext);

        if(savedInstanceState != null){
            currentIndex =savedInstanceState.getInt(KEY_INDEX);
            chageText();
        }

        textSurvey.setText(Memory[0]);
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
        if(currentIndex<Memory.length-1){
            currentIndex++;
            chageText();
            if(radioYes.isChecked()){
                radioYes.setChecked(false);
            }else if(radioNo.isChecked()){
                radioNo.setChecked(false);
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
                                Intent intent = new Intent(getActivity(), test2Result.class);
                                intent.putExtra(TOTAL_SCORE,testScore);
                                startActivity(intent);
                                }

                            });
            alertDialog.create();
            alertDialog.show();
        }
    }
    private void chageText() {
        textSurvey.setText(Memory[currentIndex]);
    }
    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioYes.isChecked()){
                    testScore += 1;
                }else if(radioNo.isChecked()){
                    testScore += 0;
                }
                // textresult.setText(testScore+ "");
                if( radioYes.isChecked() == false && radioNo.isChecked() == false){
                    Toast.makeText(getActivity(), "체크를 하신 후 다음문제로 넘어가실 수 있습니다.", Toast.LENGTH_SHORT).show();
                } else if (radioNo.isChecked() || radioYes.isChecked()){
                    showNextText();
                }
            }
        });
    }

}

