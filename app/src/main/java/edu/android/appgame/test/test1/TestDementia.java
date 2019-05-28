package edu.android.appgame.test.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.android.appgame.R;

public class TestDementia extends AppCompatActivity implements DementiaFragment.RbSelectCallBack {

    private TextView textNextSurvey;
    private TextFragment textFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dementia);

        View view = findViewById(R.id.container);
        if (view != null) {
            if (savedInstanceState != null) {

            } else {textFragment = new TextFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, textFragment)
                        .commit();

            }
        }
    }

    @Override
    public void onRbSelected(int checkedId) {

    }
}
