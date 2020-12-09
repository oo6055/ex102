package com.example.ex102;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * The type Main activity.
 *
 *  @author Ori Ofek <oriofek106@gmail.com> 8/12/2020
 *  @version 1.0
 *  @since 23/11/2020
 *  sort description:
 *  this is the activty the implement the exercise that my teacher gave...
 */
public class MainActivity extends AppCompatActivity {
    LinearLayout screen;
    AlertDialog.Builder builder;
    Intent si;
    int[] color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (LinearLayout)findViewById(R.id.screen);
    }

    /**
     * First sit.
     * short dec: create alert with text
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
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

    /**
     * sit2.
     * short dec: do a very specail action with colors and allow to the user to change the color as he wish
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
    public void sit2(View view) {
        color = new int[] {0,0,0};
        String[] colors={"Red","Green","Blue"};

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b) color[i] = 255;
                else if (color[i] == 255) color[i] = 0;

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

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog,
                                int which) {

                // When the user click yes button
                // then app will close
                screen.setBackgroundColor(Color.rgb(color[0],color[1],(color[2])));
            }
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }

    /**
     * sit4.
     * short dec: print the contance of the et
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
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

    /**
     * sit3.
     * short dec: reset the color to white
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
    public void sit3(View view) {
        screen.setBackgroundColor(Color.WHITE);
    }

    /**
     * sit5.
     * short dec: the bounos that presents two et and than it to doast to the summery of them
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
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
    /**
     * onCreateContextMenu
     * Short description.
     * onCreateContextMenu listener use for the ContextMenu
     * <p>
     *     ContextMenu menu
     *     View v
     *     ContextMenu.ContextMenuInfo menuInfo
     *
     * @param  menu - the object,v - the item that selected ,menuInfo - the info
     * @return	true if it success
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.generalmenu, menu);
        return true;
    }

    /**
     * onOptionsItemSelected
     * Short description.
     * what happen if an item was selected
     * <p>
     *     MenuItem item
     *
     * @param  item - the menuItem
     * @return	true if it success
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String whatClicked = (String) item.getTitle();

        if(whatClicked.equals("credits"))
        {
            si = new Intent(this, credits.class);
            startActivity(si);
        }

        return  true;
    }
}