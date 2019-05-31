package edu.android.appgame.game.game1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import edu.android.appgame.R;

import static edu.android.appgame.MainActivity.isLogin;

public class Main0Result extends AppCompatActivity {

    private static Main0Result instance = null;
    private TextView textAML, textKr, textItw;
    private ArrayList<String> scoreList;
    private int bestScore;
    private Context context;
    private String gameName1 = "animal.txt";
    private String gameName2 = "korea.txt";
    private String gameName3 = "itw.txt";

    public Main0Result(){}

    private Main0Result(Context context){
        this.context = context;
    }

    public static Main0Result getInstance(Context context){
        if(instance == null) {
            instance = new Main0Result(context);
        }
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_result);
        context = this;
        textAML = findViewById(R.id.textAML);
        textKr = findViewById(R.id.textKr);
        textItw = findViewById(R.id.textItw);
        isInFile(gameName1.split("\\.")[0]);
        isInFile(gameName2.split("\\.")[0]);
        isInFile(gameName3.split("\\.")[0]);
        textAML.setText("동식물게임 최고점수 : " + String.valueOf(readContentsFromTxtFile(gameName1)));
        textKr.setText("사자성어게임 최고점수 : " + String.valueOf(readContentsFromTxtFile(gameName2)));
        textItw.setText("아이티윌게임 최고점수 : " + String.valueOf(readContentsFromTxtFile(gameName3)));
    }

    public int saveScoreToFileByGames(String gameName, int scoreByGames) {
        if(!isLogin) {
            return scoreByGames;
        }
        isInFile(gameName); // 최고점수가 기록된 파일이 있는지 여부 검사
        bestScore = readContentsFromTxtFile(gameName + ".txt");// 최고점수가 기록된 파일에서 점수를 가져오기
        if (bestScore >= scoreByGames) { // 가져온 점수와 지금 점수중 어느것이 큰지 비교
            return bestScore;
        }
        writeToFile(gameName, scoreByGames); // 그중에 큰 값을 파일에 저장
        return scoreByGames;
    }// end saveScoreToFileByGames()

    private void isInFile(String gameName) {
        Log.i("tag", "gameName: " + gameName);
        try {
            context.openFileInput(gameName + ".txt");
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream f = context.openFileOutput(gameName + ".txt", MODE_PRIVATE);
                f.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    } // end isInFile()

    private void writeToFile(String gameName, int scoreByGames){
        String insertData = String.format("%s,%d\n", gameName, scoreByGames);

        OutputStream out = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        try {
            out = context.openFileOutput(gameName + ".txt", MODE_PRIVATE);
            writer = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(writer);

            bw.write(insertData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int readContentsFromTxtFile(String fileName) {
        bestScore = 0;
        InputStream in = null;
        InputStreamReader reader = null;
        BufferedReader br = null;

        try {
            in = context.openFileInput(fileName);
            reader = new InputStreamReader(in, "UTF-8");
            br = new BufferedReader(reader);

            String line = br.readLine();
            while (line != null) {
                bestScore = Integer.parseInt(line.split(",")[1]);
                line = br.readLine();
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bestScore;
    } // end readContentsFromTxtFile()


//    // 각 게임에서 넘어온 게임 점수 각 게임 파일로 (회차,점수) 저장 - 파일에 쓰기
//    private void addScoreToPrevFile(StringBuilder scorePlus, String fileName){
//
//        // scorePlus =null; // 파일 속 내용 초기화 하기 위한 코드 (일단)
//        OutputStream out = null;
//        OutputStreamWriter writer = null;
//        BufferedWriter bw = null;
//        try {
//            out = openFileOutput(fileName, MODE_PRIVATE);
//            writer = new OutputStreamWriter(out, "UTF-8");
//            bw = new BufferedWriter(writer);
//            bw.write(scorePlus.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bw.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    } // end addScoreToPrevFile()
//
//
//    // 각 게임 총 평균 점수 계산
//    private void calculateTotalAverageGameScore(String gameName){
//        int totalGrade =0;
//        averageGrade =0;
//
//        for(int i = 0; i< gradeList.size(); i++){
//            String grade = gradeList.get(i).toString();
//            Log.i(TAG,"grade:" + grade);
//
//            switch (grade){
//                case "A":
//                    totalGrade += 90;
//                    Log.i(TAG, "totalGrade : " + totalGrade);
//                    break;
//                case "B":
//                    totalGrade += 80;
//                    Log.i(TAG, "totalGrade : " + totalGrade);
//                    break;
//                case "C":
//                    totalGrade +=70;
//                    Log.i(TAG, "totalGrade : " + totalGrade);
//                    break;
//                case "D":
//                    totalGrade += 60;
//                    Log.i(TAG, "totalGrade : " + totalGrade);
//                    break;
//            } // end switch()
//        } // end for()
//
//        Log.i(TAG, "totalGrade : " + totalGrade);
//        averageGrade = (int) (totalGrade/gradeList.size());
//        Log.i(TAG, "averageGrade : " + averageGrade);
//
//        // TODO 평균 파일에 (게임이름, 평균 점수) 로 넣기
//        String fileName = AVERAGE_FILE_NAME.split("\\.")[0];
//
//        isInFile(fileName);
//        List<String> oldData =readContentsFromTxtFile(AVERAGE_FILE_NAME);
//
//        String quiz = oldData.get(0);
//        String card = oldData.get(1);
//        String word = oldData.get(2);
//        String calculate = oldData.get(3);
//        String qclick = oldData.get(4);
//
//        switch (gameName) {
//            case "quiz" :
//                quiz = String.format("%s,%s", gameName, averageGrade);
//                oldData.set(0, quiz);
//                break;
//            case "card" :
//                card = String.format("%s,%s", gameName, averageGrade);
//                oldData.set(1, card);
//                break;
//            case "word" :
//                word = String.format("%s,%s", gameName, averageGrade);
//                oldData.set(2, word);
//                break;
//            case "calculate" :
//                calculate = String.format("%s,%s", gameName, averageGrade);
//                oldData.set(3, calculate);
//                break;
//            case "qclick" :
//                qclick = String.format("%s,%s", gameName, averageGrade);
//                oldData.set(4, qclick);
//                break;
//        }
//        String insert = String.format("%s\n%s\n%s\n%s\n%s",
//                oldData.get(0), oldData.get(1), oldData.get(2), oldData.get(3), oldData.get(4));
//
//        OutputStream out = null;
//        OutputStreamWriter writer = null;
//        BufferedWriter bw = null;
//        try {
//            out = openFileOutput(AVERAGE_FILE_NAME, MODE_PRIVATE);
//            writer = new OutputStreamWriter(out, "UTF-8");
//            bw = new BufferedWriter(writer);
//
//            bw.write(insert);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bw.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    } // end calculateTotalAverageGameScore()
//

}
