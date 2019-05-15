package edu.android.appgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameDetailActivity extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        if(savedInstanceState == null){
            Intent intent = getIntent();
            position = intent.getIntExtra(KEY_GAME_INDEX, 0);


        }

    } // end onCreate()

} // end class GameDetailActivity
