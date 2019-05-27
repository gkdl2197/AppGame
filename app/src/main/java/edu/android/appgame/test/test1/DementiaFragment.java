package edu.android.appgame.test.test1;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import edu.android.appgame.R;

public class DementiaFragment extends Fragment {

    interface RbSelectCallBack {
        void onRbSelected(int checkedId);
    }

    private RbSelectCallBack callback;
    private RadioGroup Rg;
    private Button btnNextSurvey;

    public DementiaFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof RbSelectCallBack) {
            callback = (RbSelectCallBack) context;
        } else {
            throw new AssertionError();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_dementia_fragment, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, final int checkedId) {
                btnNextSurvey = getView().findViewById(R.id.btnNextSurvey);
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callback.onRbSelected(checkedId);
                    }
                };
                btnNextSurvey.setOnClickListener(onClickListener);
            }
        };
        Rg.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
