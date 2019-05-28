package edu.android.appgame.test.test1;

import android.content.Context;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.android.appgame.R;

public class TextFragment extends Fragment {

    private TextView textSurvey , textScore;
    private Button btnPrev, btnNext;
    private RadioButton btnNever,btnSometimes,btnOften;
    private static final String KEY_INDEX = "current_index";  //
    private int currentIndex;
    private int testScore=0;



    public TextFragment() {
    }

    private static final String[] TEXT_DEMENTIA = {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_test_dementia, container, false);
        btnPrev = view.findViewById(R.id.btnPrev);
        btnNext = view.findViewById(R.id.btnNext);
        textSurvey = view.findViewById(R.id.textSurvey);
        btnNever=view.findViewById(R.id.btnNever);
        btnSometimes=view.findViewById(R.id.btnSometimes);
        btnOften=view.findViewById(R.id.btnOften);
        textScore= view.findViewById(R.id.textScore);
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX);
            changeText();
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void changeText() {
        textSurvey.setText(TEXT_DEMENTIA[currentIndex]);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPrevText();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnNever.isChecked()) {
                    testScore += 0;
                } else if (btnSometimes.isChecked()) {
                    testScore += 1;
                } else if (btnOften.isChecked()) {
                    testScore += 2;
                }
                showNextText();
            }
        });
    }

    private void showNextText() {
        if (currentIndex < TEXT_DEMENTIA.length - 1) {
            currentIndex++;
            changeText();
            btnNever.setChecked(false);
            btnSometimes.setChecked(false);
            btnOften.setChecked(false);
        } else {
            btnNext.setEnabled(false);
            Toast.makeText(getActivity(), "마지막 문제 입니다!", Toast.LENGTH_SHORT).show();
        }
    }


    private void showPrevText() {
        if (currentIndex > 0) {
            currentIndex--;
            changeText();
            btnNever.setChecked(false);
            btnSometimes.setChecked(false);
            btnOften.setChecked(false);
        } else {
            Toast.makeText(getActivity(), "첫번째 문제 입니다!", Toast.LENGTH_SHORT).show();
        }
    }


}