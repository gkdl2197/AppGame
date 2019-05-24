package edu.android.appgame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FacilityInfoActivity  extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FacilityDao dao = FacilityDao.getInstance();
    private List<String> facilityList = new ArrayList<>();
    private static final String TAG = "tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_info);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        FacilityAdapter adapter = new FacilityAdapter();

        recyclerView.setAdapter(adapter);


    } // end onCreate(){



    class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            Log.i(TAG, "onCreateViewHolder: ");
            View itemView = getLayoutInflater().inflate(R.layout.activity_facility_item, parent, false);
            ViewHolder holder = new ViewHolder(itemView);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
            Log.i(TAG, "1: ");
            InputStream in = null;
            InputStreamReader reader = null;
            BufferedReader br = null;
            try {
                in = getAssets().open("facility_list.txt");
                reader = new InputStreamReader(in, "UTF-8");
                br = new BufferedReader(reader);

                StringBuilder builder = new StringBuilder();
                String line = br.readLine();
                Log.i(TAG, "2: " + line);
                while (line != null) {
                    String[] list = line.split(",");
                    viewHolder.textCenterName.setText(list[0]);
                    viewHolder.textCenterTel.setText(list[1]);
                    viewHolder.textCenterAddr.setText(list[2]);
                    Log.i(TAG, "체크: " + viewHolder.textCenterName.getText().toString());

                    facilityList.add(list[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

        @Override
        public int getItemCount() {
            return facilityList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textCenterName, textCenterAddr, textCenterTel;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                Log.i(TAG, "2: ");
                textCenterAddr = itemView.findViewById(R.id.textCenterAddr);
                textCenterName = itemView.findViewById(R.id.textCenterName);
                textCenterTel = itemView.findViewById(R.id.textCenterTel);
                Log.i(TAG, "3: ");
            }
        } // end class ViewHolder
    }



} // end class FacilityInfoActivity
