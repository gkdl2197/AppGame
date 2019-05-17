package edu.android.appgame.controller;

import java.util.ArrayList;
import java.util.List;

import edu.android.appgame.R;
import edu.android.appgame.model.Game;

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
        gameList.add(new Game("공간지각능력게임", "게임1입니다", R.drawable.game_1));
        gameList.add(new Game("수리능력게임", "게임2입니다", R.drawable.gaming));
        gameList.add(new Game("도형지능게임", "게임3입니다", R.drawable.cards));
        gameList.add(new Game("집중력게임", "게임4입니다", R.drawable.puzzle));
        gameList.add(new Game("언어능력게임", "게임5입니다", R.drawable.toys));

    } // end makeDummyData()

} // end class GameDao
