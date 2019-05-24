package edu.android.appgame.test.test1;

import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import edu.android.appgame.R;

public class TestDementia extends AppCompatActivity implements DementiaFragment.OnFragmentInteractionListener {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    speech();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dementia);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        View view = findViewById(R.id.container);
        if(view != null){
            if(savedInstanceState != null){
            } else {
                DementiaFragment fragment = new DementiaFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, fragment)
                        .commit();
            }
        }
    }

    @Override
    public void onInit(int status) {

    }

    private void speech() {
//        String myText1 = editText.getText().toString();
////        String myText2 = "말하는 스피치 입니다.";
//        myTTS.speak(myText1, TextToSpeech.QUEUE_FLUSH, null);
////        myTTS.speak(myText2, TextToSpeech.QUEUE_ADD, null);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
