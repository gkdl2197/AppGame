package edu.android.appgame;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.android.appgame.Game.GameDao;
import edu.android.appgame.Game.Game;

public class GameActivity extends AppCompatActivity {

    public static final String KEY_GAME_INDEX = "game_index";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private GameDao dao = GameDao.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);





        recyclerView = findViewById(R.id.mRecyclerview);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GameAdapter adpater = new GameAdapter();

        recyclerView.setAdapter(adpater);
    } // end onCreate()

    public void onClickBtnHome(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= getLayoutInflater().inflate(R.layout.game_item,parent,false);
            ViewHolder vh= new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
            Game gameDetail = dao.getGameList().get(position);

            viewHolder.imageGame.setImageResource(gameDetail.getPhotoId());
            viewHolder.itemName.setText(gameDetail.getgName());
            viewHolder.itemDesc.setText(gameDetail.getgDesc());

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showGameDetail(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dao.getGameList().size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageGame;
            private TextView itemName, itemDesc;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageGame = itemView.findViewById(R.id.imageGame);
                itemName = itemView.findViewById(R.id.itemName);
                itemDesc = itemView.findViewById(R.id.itemDesc);
            }
        }
    }

    private void showGameDetail(int position) {
        Intent intent = new Intent(this, GameDetailActivity.class);
        intent.putExtra(KEY_GAME_INDEX, position);
        startActivity(intent);
    } // end showGameDetail()

} // end class GameActivity
