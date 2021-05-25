package com.example.stopasci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void start(View view){
        setContentView(R.layout.activity_main);
    }

    int a = 0, b = 0, wina = 0, winb = 0;
    String msg;

    public void toastMsg(String msg)
    {
        Toast t = Toast.makeText(getApplicationContext(), msg, 2000);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
    }

    public void comp() {
        Random r = new Random();
        b = r.nextInt(4 - 1) + 1;

        if (b == 1) {

            dispImgB(R.drawable.stone1);

        } else if (b == 2) {

            dispImgB(R.drawable.paper1);

        } else if (b == 3) {

            dispImgB(R.drawable.sci1);

        }
    }

    public void winner() {
        if ((a == 1) && (b == 3)) {
            wina = wina + 1;
            toastMsg("YOU WIN");
            clear();
        } else if ((a == 1) && (b == 2)) {
            winb = winb + 1;
            toastMsg("COMP WIN");
            clear();
        } else if ((a == 2) && (b == 1)) {
            wina = wina + 1;
            toastMsg("YOU WIN");
            clear();
        } else if ((a == 2) && (b == 3)) {
            winb = winb + 1;
            toastMsg("COMP WIN");
            clear();
        } else if ((a == 3) && (b == 1)) {
            winb = winb + 1;
            toastMsg("COMP WIN");
            clear();
        } else if ((a == 3) && (b == 2)) {
            wina = wina + 1;
            toastMsg("YOU WIN");
            clear();
        }else{
            toastMsg("It's a DRAW");
            clear();
        }
        dispA(wina);
        dispB(winb);
    }

    public void clear() {
        a = 0;
        b = 0;
    }

    public void stone(View view) {
        a = 1;
        dispImgA(R.drawable.stone1);
        comp();
        winner();
    }

    public void paper(View view) {
        a = 2;
        dispImgA(R.drawable.paper1);
        comp();
        winner();
    }

    public void sci(View view) {
        a = 3;
        dispImgA(R.drawable.sci1);
        comp();
        winner();
    }


    public void dispA(int msg) {
        TextView text = (TextView) findViewById(R.id.scoreA);
        text.setText("" + msg);
    }

    public void dispB(int msg) {
        TextView text = (TextView) findViewById(R.id.scoreB);
        text.setText("" + msg);
    }

    public void dispImgA(int imgId) {
        ImageView img = (ImageView) findViewById(R.id.imgA);
        img.setImageResource(imgId);
    }

    public void dispImgB(int imgId) {
        ImageView img = (ImageView) findViewById(R.id.imgB);
        img.setImageResource(imgId);
    }
}