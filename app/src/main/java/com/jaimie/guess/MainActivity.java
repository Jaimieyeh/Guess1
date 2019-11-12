package com.jaimie.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    int secret = new Random().nextInt(10) + 1;
    private TextView edGuess;
    private TextView edResult;
    int counter;
    private TextView edCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edGuess = findViewById(R.id.guess);
        edResult = findViewById(R.id.result);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(counter + "");

        Log.d(TAG, "secret" + secret);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void test (View view){

        int guess = Integer.parseInt(edGuess.getText().toString());
        if (guess > secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("smaller")
                    .setPositiveButton("Ok", null)
                    .show();
        } else if (guess < secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("bigger")
                    .setPositiveButton("Ok", null)
                            .show();

        } else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("bingo")
                    .setPositiveButton("Ok", null)
                    .show();

        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
