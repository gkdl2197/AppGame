package edu.android.appgame.Prevention;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.android.appgame.R;

import static edu.android.appgame.Prevention.PreventionMainActivity.KEY_PREVENTION_INDEX;
import static edu.android.appgame.GameActivity.KEY_GAME_INDEX;

public class PreventionDetail extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevention_detail);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            position = intent.getIntExtra(KEY_PREVENTION_INDEX, 0);

            switch (position) {
                case 1:
                    Intent intent1 = new Intent(this, Prevention_1.class);
                    startActivity(intent1);
                    finish();
                    break;
                case 2:

                    break;
                case 3:

                    break;

            }
        }
    }
}