package edu.android.appgame.test.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.android.appgame.R;

public class ExplainMemory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain_memory);
    }

    public void btnStart(View view) {
        Intent intent = new Intent(this, MemoryButton.class);
        startActivity(intent);
        finish();

    }
}
