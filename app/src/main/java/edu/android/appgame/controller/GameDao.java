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
        gameList.add(new Game("게임1", "게임1입니다", R.drawable.game_game1));
        gameList.add(new Game("게임2", "게임2입니다", R.drawable.game_game2));
        gameList.add(new Game("게임3", "게임3입니다", R.drawable.game_game3));
        gameList.add(new Game("게임4", "게임4입니다", R.drawable.game_game4));
        gameList.add(new Game("게임5", "게임5입니다", R.drawable.game_game5));
        gameList.add(new Game("게임6", "게임6입니다", R.drawable.game_game6));
        gameList.add(new Game("게임7", "게임7입니다", R.drawable.game_game7));
        gameList.add(new Game("게임8", "게임8입니다", R.drawable.game_game8));
    } // end makeDummyData()

} // end class GameDao
