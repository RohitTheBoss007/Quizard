package com.example.android.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.authentication.Playing.Play;
import com.example.android.authentication.Playing.Play1;
import com.example.android.authentication.Playing.Play2;
import com.example.android.authentication.Playing.Play3;
import com.example.android.authentication.Playing.Play4;
import com.example.android.authentication.Playing.Play5;
import com.example.android.authentication.Playing.Play6;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        String pos=i.getStringExtra("pos");
        final int p= Integer.parseInt(pos);
        b=(Button) findViewById(R.id.start);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (p)
                {
                    case 1:
                        startActivity(new Intent(StartScreen.this, Play1.class));
                        break;
                    case 2:
                        startActivity(new Intent(StartScreen.this, Play2.class));
                        break;
                    case 3:
                        startActivity(new Intent(StartScreen.this, Play3.class));
                        break;
                    case 4:
                        startActivity(new Intent(StartScreen.this, Play4.class));
                        break;
                    case 5:
                        startActivity(new Intent(StartScreen.this, Play5.class));
                        break;
                    case 6:
                        startActivity(new Intent(StartScreen.this, Play6.class));
                        break;
                    case 7:
                        startActivity(new Intent(StartScreen.this, Play.class));
                        break;

                }


            }

        });
    }
}
