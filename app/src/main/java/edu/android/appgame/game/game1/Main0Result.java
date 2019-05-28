package edu.android.appgame.game.game1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.android.appgame.R;
import static edu.android.appgame.game.game1.Main0Animal.TEXT_SCORE;

public class Main0Result extends AppCompatActivity {

    public static final String TEXT_SCORE = "text_score";
    public static final String TEXT_BEST = "text_best";

    private TextView textAML, textKr, textItw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_result);

    textAML = findViewById(R.id.textAML);
    textKr = findViewById(R.id.textKr);
    textItw = findViewById(R.id.textItw);

    }

}