package com.example.android.authentication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.authentication.Interface.RankingCallback;
import com.example.android.authentication.Model.Question;
import com.example.android.authentication.Model.QuestionScore;
import com.example.android.authentication.Model.Ranking;
import com.example.android.authentication.Model.User;
import com.example.android.authentication.ViewHolder.RankingViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class RankingFragment extends Fragment {
    View myFragment;
    RecyclerView rankingList;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Ranking, RankingViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference questionScore, rankingTbl;
    String k;
    int sum=0;

    public static RankingFragment newInstance() {
        RankingFragment rankingFragment = new RankingFragment();
        return rankingFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        questionScore = database.getReference("Question_Score");
        rankingTbl = database.getReference("Ranking");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_ranking, container, false);
        rankingList = (RecyclerView) myFragment.findViewById(R.id.rankingList);
        layoutManager = new LinearLayoutManager(getActivity());
        rankingList.setHasFixedSize(true);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rankingList.setLayoutManager(layoutManager);



     updateScore(Common.currentUser.getUsername(), new RankingCallback<Ranking>() {
            @Override
            public void callback(Ranking ranking) {
                rankingTbl.child(ranking.getUsername()).setValue(ranking);
                //showRanking();

            }
        });
        adapter = new FirebaseRecyclerAdapter<Ranking, RankingViewHolder>(
                Ranking.class, R.layout.layout_ranking, RankingViewHolder.class, rankingTbl.orderByChild("marks")
        ) {
            @Override
            protected void populateViewHolder(final RankingViewHolder viewHolder, Ranking model, int position) {
                viewHolder.txt_name.setText(model.getUsername());
                viewHolder.txt_score.setText(k);

            }
        };


        rankingList.setAdapter(adapter);
        return myFragment;
    }


private void updateScore(final String username, final RankingCallback<Ranking> callback) {
        questionScore.orderByChild("user").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    QuestionScore ques = data.getValue(QuestionScore.class);
                    sum+=Integer.parseInt(ques.getScore());
                    if(sum>=50)
                        k="pass";
                    else
                        k="fail";

                }
                Ranking ranking = new Ranking(username, sum);
                callback.callback(ranking);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


