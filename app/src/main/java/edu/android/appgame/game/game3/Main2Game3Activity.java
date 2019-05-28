package edu.android.appgame.game.game3;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.android.appgame.R;

public class Main2Game3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_main2);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorDarkBlue)));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

    }

    public void onClickGameStart(View view) {


        Intent intent = new Intent(this, MainGame3Activity.class);
        startActivity(intent);
    } // end onClickGameStart()

} // end class Main2Game3Activity
