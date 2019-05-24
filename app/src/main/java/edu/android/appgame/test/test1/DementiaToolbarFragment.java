package edu.android.appgame.test.test1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.android.appgame.R;

public class DementiaToolbarFragment extends Fragment {

    interface ToolbarCallback {
        void onTextInput(String text);
    }

    private ToolbarCallback callback;
    private Button btnNever;
    private Button btnSometimes;
    private Button btnOften;
    private Button btnNextSurvey;

    public DementiaToolbarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ToolbarCallback) {
            callback = (ToolbarCallback) context;
        } else {
            throw new AssertionError(context + "는 반드시 ToolbarCallback을 구현해야 합니다.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dementia_toolbar, container, false);
        btnNever = view.findViewById(R.id.btnNever);
        btnSometimes = view.findViewById(R.id.btnSometimes);
        btnOften = view.findViewById(R.id.btnOften);

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        // TODO 6. onStart 메소드를 override
        // -> button을 찾아서 OnClickListener를 설정
        btnNextSurvey = getView().findViewById(R.id.btnNextSurvey);
        btnNextSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // -> MainActivity에게 editText의 내용과 seekBar의 progress 값을 전달


            }
        });


    }

}
