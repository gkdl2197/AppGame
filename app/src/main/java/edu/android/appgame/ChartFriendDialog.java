package edu.android.appgame;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChartFriendDialog extends Dialog {
    private static final String TAG = "chart_tag";

    private FirebaseDatabase mDatabase;
    private DatabaseReference  mReference;

    private ListView listFriends;
    private ArrayAdapter<String> adapter;
    List<String> arrayF = new ArrayList<>();
    private Context context;

    private Button btnAddFriends;
    private TextView textFriends;

    public ChartFriendDialog(@NonNull Context context) {
        super(context);

        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chart_friend);


        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Member");

        listFriends = findViewById(R.id.listFriends);
        textFriends = findViewById(R.id.textFriends);

        adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_expandable_list_item_1, arrayF);
        listFriends.setAdapter(adapter);


            mReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.i(TAG,"11" );
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        Log.i(TAG,"22");
                        String name = snapshot.getKey();
                        arrayF.add(name);
                        Log.i(TAG,"??" + name);
                        Log.i(TAG, " arrayF" + arrayF.toString());
                    }
                    adapter.notifyDataSetChanged();
                    mReference.removeEventListener(this);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.i(TAG, "ValueEventListener cancelled");
                }
            });

        listFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO 그래프 띄우기

            }
        });
    }


} // end class ChartFriendDialogFragment
