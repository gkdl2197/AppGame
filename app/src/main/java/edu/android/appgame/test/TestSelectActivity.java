package edu.android.appgame.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.android.appgame.R;

// import edu.android.appgame.game.Sudoku.SudokuMain;

public class TestSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_select);
    }


    public void onClickDementia(View view) {
        Intent intent = new Intent(this, ExplainDementia.class);
        startActivity(intent);
        finish();
    }

    public void onClickMemory(View view) {
    }

    public void onClickGloomy(View view) {
    }
}