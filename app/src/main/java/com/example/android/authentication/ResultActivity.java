package com.example.android.authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.authentication.Playing.Play1;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResultActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b;
    float score=0;
    int c,t;
    FirebaseDatabase database;
    DatabaseReference q;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        t1=(TextView)findViewById(R.id.textView10);
        t2=(TextView)findViewById(R.id.textView11);
        t3=(TextView)findViewById(R.id.textView12);
        b=(Button)findViewById(R.id.buttonok);
        Intent i=getIntent();
        String questions=i.getStringExtra("total");
        String correct=i.getStringExtra("correct");
        String wrong=i.getStringExtra("incorrect");
        int t=Integer.parseInt(questions);
        int c=Integer.parseInt(correct);
        score=(float)c/t*100;

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, Final.class));
            }
        });
        database=FirebaseDatabase.getInstance();
        q=database.getReference("Question_Score");
        q.child("user").setValue(Common.currentUser.getUsername());
        q.child("score").setValue(String.valueOf(score));


    }
}
