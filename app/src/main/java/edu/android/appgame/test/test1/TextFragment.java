package edu.android.appgame.test.test1;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.android.appgame.R;

public class TextFragment extends Fragment {

    private TextView textSurvey;

    public TextFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_text_fragment, container, false);
        textSurvey = view.findViewById(R.id.textSurvey);

        return view;
    }
}