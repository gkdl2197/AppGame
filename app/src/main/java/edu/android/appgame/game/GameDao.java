package edu.android.appgame.game;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import edu.android.appgame.R;

public class GameDao {


    private static final String TAG = "debug";
    private List<Game> gameList = new ArrayList<>();
    private static GameDao instance = null;
    private Context context;

    public static GameDao getInstance(Context context) {
        if (instance == null ){
            instance = new GameDao(context);
        }
        return instance;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    private GameDao(Context context) {
        this.context = context/*.getApplicationContext()*/;
        makeDummyData();
    }

    private void makeDummyData() {
        gameList.add(new Game("공간지각능력게임", "공간 관계나 공간 위치를 감각을 통해 파악하는 능력을 개발해주는 게임입니다. ", R.drawable.game_1));
        gameList.add(new Game("수리능력게임 ", "정확하고 빠르게 계산하며 수에 관한 문제를 추리하고 이해하며 해결할 수 있는 능력 향상을 도와드립니다. ", R.drawable.gaming));
        gameList.add(new Game("도형지능게임", "점, 선, 면 등을 사용하여 이루어진 도형을 자유롭게 다룰수 있도록 도움을 주는 게임입니다.", R.drawable.cards));
        gameList.add(new Game("집중력게임 ", "모든 원인은 집중력 부족입니다. 집중력을 키워보세요!", R.drawable.puzzle));
        gameList.add(new Game("언어능력게임", "언어는 사회생활을 하는 필수적인 요소입니다. 언어는 중요한 능력입니다.", R.drawable.toys));
        gameList.add(new Game("게임", "...", R.drawable.toys));
        gameList.add(new Game("관계순서인지능력게임", "숫자/문자들의 순서관계를 인지함과 동시에 기억의 집중을 통해 유연한 두뇌활동을 향상시킵니다.", R.drawable.potential));

    } // end makeDummyData()

    public void saveScoreToFileByGames(String gameName, int gameCount, String gameGrade) {
        String insert = gameCount + "," + gameGrade;
        String fileName = gameName + ".txt";
        Log.i(TAG,"insert: " + insert);

        StringBuilder builder = new StringBuilder();
        OutputStream out = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        try {
            out = context.openFileOutput(fileName, context.MODE_PRIVATE);
            Log.i(TAG, "out ");
            writer = new OutputStreamWriter(out, "UTF-8");
            Log.i(TAG, "writer ");
            bw = new BufferedWriter(writer);
            builder.append("123").append("/");
            bw.write(builder.toString());
//            bw.write(insert);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }// end saveScoreToFileByGames()

} // end class GameDao
