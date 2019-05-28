package edu.android.appgame.game;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.android.appgame.R;

public class GameDao {

    private static final String TAG = "file_tag";
    private static final String AVERAGE_FILE_NAME = "allaverage.txt";


    private List<Game> gameList = new ArrayList<>();
    private static GameDao instance = null;
    private Context context;
    private List<String> gradeList = new ArrayList<>();
    private int averageGrade;


    public int lineCount =0;

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


    //editId.getText().toString().split("@")[0];

    // 각 게임에서 넘어온 게임 점수 각 게임 파일로 (회차,점수) 저장하기 위한 파일 내용 읽어오기 + 추가
    public void saveScoreToFileByGames(String gameName, String gameGrade) {
        StringBuilder builder = new StringBuilder();
        String fileName = gameName + ".txt";

        int time = 1; // 회차 저장을 위한 변수

        InputStream in = null;
        InputStreamReader reader = null;
        BufferedReader br = null;

        try {
            in = context.openFileInput(fileName);
            reader = new InputStreamReader(in, "UTF-8");
            br = new BufferedReader(reader);

            String line = br.readLine();
            while (line != null) {
                builder.append(line).append("\n");
                time++;
                gradeList.add(line.split(",")[1]);
                line = br.readLine();

            }

            String insert = time + "," + gameGrade;
            builder.append(insert).append("\n");

            gradeList.add(gameGrade);

            // TODO 각 게임 점수 평균 값 계산하는 메소드 호출
            calculateTotalAverageGameScore(gameName);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        addScoreToPrevFile(builder, fileName);

    }// end saveScoreToFileByGames()


    // 각 게임에서 넘어온 게임 점수 각 게임 파일로 (회차,점수) 저장 - 파일에 쓰기
    private void addScoreToPrevFile(StringBuilder scorePlus, String fileName){

//        scorePlus =null; // 파일 속 내용 초기화 하기 위한 코드 (일단)
        OutputStream out = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        try {
            out = context.openFileOutput(fileName, context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(writer);
            bw.write(scorePlus.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//                if (bw != null) {
                    bw.close();
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // end addScoreToPrevFile()


    // 각 게임 총 평균 점수 계산
    private void calculateTotalAverageGameScore(String gameName){
        int totalGrade =0;
        averageGrade =0;

        for(int i = 0; i< gradeList.size(); i++){
            String grade = gradeList.get(i).toString();
            Log.i(TAG,"grade:" + grade);

            switch (grade){
                case "A":
                    totalGrade += 90;
                    Log.i(TAG, "totalGrade : " + totalGrade);
                    break;
                case "B":
                    totalGrade += 80;
                    Log.i(TAG, "totalGrade : " + totalGrade);
                    break;
                case "C":
                    totalGrade +=70;
                    Log.i(TAG, "totalGrade : " + totalGrade);
                    break;
                case "D":
                    totalGrade += 60;
                    Log.i(TAG, "totalGrade : " + totalGrade);
                    break;
            } // end switch()
        } // end for()

        Log.i(TAG, "totalGrade : " + totalGrade);
        averageGrade = (int) (totalGrade/gradeList.size());
        Log.i(TAG, "averageGrade : " + averageGrade);

        // 평균 파일에 (게임이름, 평균 점수) 로 넣기

        String insert = gameName + "," + averageGrade;

        OutputStream out = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        try {
            out = context.openFileOutput(AVERAGE_FILE_NAME, context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(writer);

            bw.write(insert);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // end calculateTotalAverageGameScore()



} // end class GameDao
