package edu.android.appgame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import edu.android.appgame.game.GameDao;

import static edu.android.appgame.MainActivity.isLogin;
import static edu.android.appgame.MainActivity.currentMemberId;

public class ChartMainActivity extends AppCompatActivity {

    public static final int MAX = 100, MIN = 0;
    public static final int NB_QUALITIES = 5;
    private static final String TAG = "file_tag";

    private com.github.mikephil.charting.charts.RadarChart radarChart;
    private ArrayList<RadarEntry> radarEntries1, radarEntries2;
    private RadarDataSet radarDataSet1, radarDataSet2;
    private RadarData radarData;
    private GameDao dao = GameDao.getInstance(this);

    private String[] lables = {
            "기억력", "수리능력", "집중력", "언어능력", "인지능력"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_activity_main);

        onClickGetDBdata(currentMemberId);
        radarChart = findViewById(R.id.radarChart);
        setData();
        radarChartDecoration();
        coordinateLabelsDecoration();
        legendIndexDecoration();
    }

    private void setData() {
        radarEntries1 = dataValues1();
        radarEntries2 = dataValues2();

        radarDataSet1 = new RadarDataSet(radarEntries1, "My Scores");
        radarDataSet2 = new RadarDataSet(radarEntries2, "Friend Scores");
        radarData = new RadarData();
        radarData.addDataSet(radarDataSet1);
        radarData.addDataSet(radarDataSet2);

        radarChart.setData(radarData);
        radarChart.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.radar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addBuddy:
                // TODO - dao.method()
                break;
            case R.id.toggleValues:
                for (IDataSet<?> set : radarChart.getData().getDataSets()) {
                    set.setDrawValues(!set.isDrawValuesEnabled());
                }
                radarChart.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void legendIndexDecoration() {
        Legend l = radarChart.getLegend();
        l.setTextSize(17f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(30f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.WHITE);
    }

    private void coordinateLabelsDecoration() {
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(lables));
        xAxis.setTextSize(15f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setYOffset(0);
        xAxis.setXOffset(0);

        YAxis yAxis = radarChart.getYAxis();
        yAxis.setLabelCount(NB_QUALITIES, true);
        yAxis.setAxisMaximum(MAX);
        yAxis.setAxisMinimum(MIN);
        yAxis.setDrawLabels(false);
    }

    private void radarChartDecoration() {
        radarChart.setBackgroundColor(Color.rgb(50, 55, 62));
        radarChart.getDescription().setEnabled(false);
//        radarChart.setWebLineWidth(1f);
//        radarChart.setWebColor(Color.WHITE);
//        radarChart.setWebLineWidth(1f);
//        radarChart.setWebColorInner(Color.WHITE);
//        radarChart.setWebAlpha(100);
        radarDataSet1.setFillColor(ColorTemplate.colorWithAlpha(Color.RED, 120));
        radarDataSet2.setFillColor(ColorTemplate.colorWithAlpha(Color.GREEN, 120));
        radarDataSet1.setColor(Color.RED);
        radarDataSet2.setColor(Color.GREEN);
        radarDataSet1.setDrawFilled(true);
        radarDataSet2.setDrawFilled(true);
        radarDataSet1.setLineWidth(3f);
        radarDataSet2.setLineWidth(3f);
        radarDataSet1.setValueTextColor(Color.YELLOW);
        radarDataSet2.setValueTextColor(Color.CYAN);
        radarDataSet1.setValueTextSize(13f);
        radarDataSet2.setValueTextSize(13f);
        radarDataSet1.setDrawHighlightIndicators(false);
        radarDataSet1.setDrawHighlightCircleEnabled(true);
//        radarDataSet1.setColors(ColorTemplate.PASTEL_COLORS);
//        radarDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
        radarChart.animateXY(1400,1400, Easing.EaseInOutQuad, Easing.EaseInOutQuad);
    }

    private ArrayList<RadarEntry> dataValues1() {
        radarEntries1 = new ArrayList<>();
        radarEntries1.add(new RadarEntry(85)); // get first data -> put here
        radarEntries1.add(new RadarEntry(40));
        radarEntries1.add(new RadarEntry(70));
        radarEntries1.add(new RadarEntry(90));
        radarEntries1.add(new RadarEntry(100));
        return radarEntries1;
    }

    private ArrayList<RadarEntry> dataValues2() {
        radarEntries2 = new ArrayList<>();
//        radarEntries2.add(new RadarEntry(3)); // get second data -> put here
//        radarEntries2.add(new RadarEntry(2));
//        radarEntries2.add(new RadarEntry(1));
//        radarEntries2.add(new RadarEntry(3));
//        radarEntries2.add(new RadarEntry(4));
        return radarEntries2;
    }

    public void onClickGetDBdata(String currentMemberId) {
        final String userId = currentMemberId;

        dao.setOnReceivedFirebaseData(new GameDao.GetFirebaseData() {
              @Override
              public void onReceivedEvent() {
                  if (isLogin) {
                      Log.i(TAG, "11111111" + dao.gameScoreList.toString());
                      // calculate: 수리능력, card: 기억력, qclick: 집중력, quiz: 언어능력, word: 인지능력
                      radarEntries1 = new ArrayList<>();
                      radarEntries1.add(new RadarEntry(Integer.parseInt(dao.gameScoreList.get(0)))); // get first data -> put here
                      radarEntries1.add(new RadarEntry(Integer.parseInt(dao.gameScoreList.get(1))));
                      radarEntries1.add(new RadarEntry(Integer.parseInt(dao.gameScoreList.get(2))));
                      radarEntries1.add(new RadarEntry(Integer.parseInt(dao.gameScoreList.get(3))));
                      radarEntries1.add(new RadarEntry(Integer.parseInt(dao.gameScoreList.get(4))));
                  } else {
                      Toast.makeText(ChartMainActivity.this, "로그인 후 재실행 하세요!", Toast.LENGTH_SHORT).show();
                  }
              }
          }, userId);
    }
}
