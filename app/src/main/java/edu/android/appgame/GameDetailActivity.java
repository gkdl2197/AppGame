package edu.android.appgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static edu.android.appgame.GameActivity.KEY_GAME_INDEX;

public class GameDetailActivity extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        if(savedInstanceState == null){
            Intent intent = getIntent();
            position = intent.getIntExtra(KEY_GAME_INDEX, 0);

            GameDetailFragment fragment = GameDetailFragment.newFragment(position);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }

    } // end onCreate()

} // end class GameDetailActivity