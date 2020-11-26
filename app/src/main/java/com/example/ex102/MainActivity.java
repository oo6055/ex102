package com.example.ex102;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout screen;
    AlertDialog.Builder builder;
    Random rnd;
    Intent si;
    int[] color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (LinearLayout)findViewById(R.id.screen);
    }

    public void sit1(View view) {
        color = new int[] {0,0,0};
        String[] colors={"Red","Green","Blue"};

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                screen.setBackgroundColor(Color.rgb(color[0],color[1],(color[2])));

            }
        });

        builder.setTitle("Alert !");


        builder.setPositiveButton("exit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog,
                                int which) {

                // When the user click yes button
                // then app will close
                dialog.cancel();
            }
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }

    public void sit2(View view) {
        color = new int[] {0,0,0};
        String[] colors={"Red","Green","Blue"};

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b) color[i] = 255;
                else if (color[i] == 255) color[i] = 0;
                screen.setBackgroundColor(Color.rgb(color[0],color[1],(color[2])));
            }
        });

        builder.setTitle("Alert !");


        builder.setPositiveButton("exit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog,
                                int which) {

                // When the user click yes button
                // then app will close
                dialog.cancel();
            }
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }

    public void sit4(View view) {

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("et Widget");
        final EditText et = new EditText(this);
        builder.setView(et);

        builder.setPositiveButton("exit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog,
                                int which) {

                // When the user click yes button
                // then app will close
                Toast.makeText(MainActivity.this,
                        et.getText().toString(), Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }

    public void sit3(View view) {
        screen.setBackgroundColor(Color.WHITE);
    }

    public void sit5(View view) {
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("et Widget");
        final EditText et = new EditText(this);
        final EditText et2 = new EditText(this);

        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(et);
        ll.addView(et2);
        builder.setView(ll);

        builder.setPositiveButton("exit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog,
                                int which) {

                // When the user click yes button
                // then app will close
                Toast.makeText(MainActivity.this,
                        et.getText().toString()+ et2.getText().toString(), Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }
}