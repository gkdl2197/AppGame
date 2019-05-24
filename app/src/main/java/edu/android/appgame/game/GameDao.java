package edu.android.appgame.game;

import java.util.ArrayList;
import java.util.List;

import edu.android.appgame.R;

public class GameDao {

    private List<Game> gameList = new ArrayList<>();

    private static GameDao instance = null;

    public static GameDao getInstance() {
        if (instance == null ){
            instance = new GameDao();
        }
        return instance;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    private GameDao(){
        makeDummyData();
    }

    private void makeDummyData() {
        gameList.add(new Game("공간지각능력게임", "공간 관계나 공간 위치를 감각을 통해 파악하는 능력을 개발해주는 게임입니다. ", R.drawable.game_1));
        gameList.add(new Game("수리능력게임 ", "정확하고 빠르게 계산하며 수에 관한 문제를 추리하고 이해하며 해결할 수 있는 능력 향상을 도와드립니다. ", R.drawable.gaming));
        gameList.add(new Game("도형지능게임", "점, 선, 면 등을 사용하여 이루어진 도형을 자유롭게 다룰수 있도록 도움을 주는 게임입니다.", R.drawable.cards));
        gameList.add(new Game("집중력게임 ", "모든 원인은 집중력 부족입니다. 집중력을 키워보세요!", R.drawable.puzzle));
        gameList.add(new Game("언어능력게임", "언어는 사회생활을 하는 필수적인 요소입니다. 언어는 중요한 능력입니다.", R.drawable.toys));

    } // end makeDummyData()

} // end class GameDao
