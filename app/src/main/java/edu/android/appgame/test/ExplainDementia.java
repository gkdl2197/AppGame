package edu.android.appgame.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.android.appgame.R;

public class ExplainDementia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain_dementia);
    }

    public void btnStart(View view) {
        Intent intent = new Intent(this, TestDementia.class);
        startActivity(intent);
        finish();
    }
}
