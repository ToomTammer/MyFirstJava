package com.example.myfirstapp;

import static android.view.MotionEvent.actionToString;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{

    GestureDetectorCompat detectorCompat;

    TextView textView;
    Button button;

    Activity activity;
    MenuItem itemThai;
    MenuItem itemEnglish;
    Menu optionMenu;

    Button buttonSubAc1;

    String DEBUG_TAG = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        textView = findViewById(R.id.textView);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d(DEBUG_TAG, "textView was Down");
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(DEBUG_TAG, "textView was move");
                        return true;
                    default:
                        return false;
                }

            }
        });

        button = findViewById(R.id.button);
        buttonSubAc1 = findViewById(R.id.buttonSubAc1);
        buttonSubAc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SubActivity1.class);
                startActivity(intent);
            }
        });

        detectorCompat = new GestureDetectorCompat(this, this);
        detectorCompat.setOnDoubleTapListener(this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(this.detectorCompat.onTouchEvent(event)){
            return true;
        }

        /*
        String s = event.getPointerCount() + "point" ;
        for ( int i = 0; i< event.getPointerCount();i++){
            s += event.getX() + "," + event.getY() + "";
        }
        Log.d("vac","OnTouchEvent: " + s);*/


        /*
        DEBUG_TAG = "onTouchEvent()";
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(DEBUG_TAG, "Action was down");
                Toast.makeText(this,"Action down", Toast.LENGTH_SHORT).show();
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d(DEBUG_TAG, "Action move");
                Toast.makeText(this,"Action move", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onTouchEvent(event);
        }*/

        return  super.onTouchEvent(event);
    }

    public void buttonClicked(View v) {
        if (button.getText() == "Thai") {
            textView.setText("สวัสดีชาวโลก");
            textView.setTypeface(null, Typeface.ITALIC);
            button.setText("อังกฤษ");
            Toast.makeText(this, "You press Thai", Toast.LENGTH_SHORT).show();
        } else {
            textView.setText("Hello World!!!");
            textView.setTypeface(null, Typeface.NORMAL);
            button.setText("Thai");
            Toast.makeText(this, "คุณกดอังกฤษ", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        itemThai = menu.findItem(R.id.itemThai);
        itemEnglish = menu.findItem(R.id.itemEnglish);
        optionMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemThai:
                textView.setText("สวัสดีชาวโลก");
                textView.setTypeface(null, Typeface.ITALIC);
                button.setText("อังกฤษ");
                Toast.makeText(this, "You press Thai", Toast.LENGTH_SHORT).show();
                itemThai.setEnabled(false);
                itemEnglish.setEnabled(true);
                return true;
            case R.id.itemEnglish:
                textView.setText("Hello World!!!");
                textView.setTypeface(null, Typeface.NORMAL);
                button.setText("Thai");
                Toast.makeText(this, "คุณกดอังกฤษ", Toast.LENGTH_LONG).show();
                itemThai.setEnabled(true);
                itemEnglish.setEnabled(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        //Toast.makeText(this, "SingleTapConfirmed gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Toast.makeText(this, "DoubleTap gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
       // Toast.makeText(this, "DoubleTapEvent gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Toast.makeText(this, "Down gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        //Toast.makeText(this, "ShowPress gesture is activated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        //Toast.makeText(this, "SingleTapUp gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Toast.makeText(this, "Scroll gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
       Toast.makeText(this,"LongPress gesture is activated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Toast.makeText(this, "Fling gesture is activated", Toast.LENGTH_SHORT).show();
        return false;
    }



}
