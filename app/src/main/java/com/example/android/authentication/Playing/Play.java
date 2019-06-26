package com.example.android.authentication.Playing;


import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.authentication.Model.Question;
import com.example.android.authentication.R;
import com.example.android.authentication.ResultActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.Collections;


/** Created by Rohit Pal on 01/06/2019 */

public class Play extends AppCompatActivity {
    Button b1, b2, b3, b4;
    TextView t1_question, timerTxt;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    int i1=0;

    Integer[] arr = new Integer[15];



    //Random r = new Random();

    DatabaseReference reference;
    //Firebase.getDefaultConfig().setPersistenceEnabled(true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Firebase.setAndroidContext(this);
        //Integer[] arr = new Integer[15];
        for (int i = 0; i <15; i++) {
            arr[i] = i+1;
        }

        Collections.shuffle(Arrays.asList(arr));
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        b1 = (Button) findViewById(R.id.Button1);
        b2 = (Button) findViewById(R.id.Button2);
        b3 = (Button) findViewById(R.id.Button3);
        b4 = (Button) findViewById(R.id.Button4);
        t1_question = (TextView) findViewById(R.id.questionsTxt);
        timerTxt = (TextView) findViewById(R.id.timerTxt);

        updateQuestions();
        reverseTimer(30, timerTxt);
    }

    private void updateQuestions() {


        //int i1 = r.nextInt(15 - 0) + 0;
        total++;
        if (total > 15) {
            total--;
            //open the result activity
            Intent i = new Intent(Play.this, ResultActivity.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("incorrect", String.valueOf(wrong));
            startActivity(i);

        } else {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(arr[i1]));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    t1_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (b1.getText().toString().equals(question.getAnswer())) {
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9f4"));
                                        updateQuestions();
                                    }

                                }, 1500);
                            } else {
                                wrong++;
                                b1.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestions();
                                    }

                                }, 1500);

                            }

                        }


                    });
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (b2.getText().toString().equals(question.getAnswer())) {
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#03A9f4"));
                                        updateQuestions();
                                    }

                                }, 1500);
                            } else {
                                wrong++;
                                b2.setBackgroundColor(Color.RED);
                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestions();
                                    }

                                }, 1500);

                            }


                        }
                    });
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (b3.getText().toString().equals(question.getAnswer())) {
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#03A9f4"));
                                        updateQuestions();
                                    }

                                }, 1500);
                            } else {
                                wrong++;
                                b3.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestions();
                                    }

                                }, 1500);

                            }

                        }
                    });
                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (b4.getText().toString().equals(question.getAnswer())) {
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#03A9f4"));
                                        updateQuestions();
                                    }

                                }, 1500);
                            } else {
                                wrong++;
                                b4.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestions();
                                    }

                                }, 1500);

                            }


                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }


            });


        }
        i1++;

    }

    public void reverseTimer(int seconds, final TextView tv)


    {
        new CountDownTimer(seconds * 1000 + 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent myIntent = new Intent(Play.this, ResultActivity.class);
                myIntent.putExtra("total", String.valueOf(total));
                myIntent.putExtra("correct", String.valueOf(correct));
                myIntent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(myIntent);
            }
        }.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update) {
            Toast toast=Toast.makeText(this,"Update feature is coming soon",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


