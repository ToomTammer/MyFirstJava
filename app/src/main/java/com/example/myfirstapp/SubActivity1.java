package com.example.myfirstapp;

import static android.view.MotionEvent.actionToString;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        int index = event.getActionIndex();
        int xPos = -1;
        int yPos = -1;

      //  Log.d("MultiTouch","The finger : " + index + " is " + actionToString(action));
        Toast.makeText(this, "The finger : " + index + " is " + actionToString(action), Toast.LENGTH_LONG).show();
        if (event.getPointerCount() > 1) {
            Log.d("The finger ","Multitouch event");
            Toast.makeText(this, "Multitouch event is " + actionToString(action), Toast.LENGTH_LONG).show();
            // The coordinates of the current screen contact, relative to
            // the responding View or Activity.
            xPos = (int) MotionEventCompat.getX(event, index);
            yPos = (int)MotionEventCompat.getY(event, index);

        } else {
            // Single touch event
            Log.d("The finger ","Single touch event");
            Toast.makeText(this, "Single touch event is " + actionToString(action), Toast.LENGTH_LONG).show();

            xPos = (int)MotionEventCompat.getX(event, index);
            yPos = (int)MotionEventCompat.getY(event, index);
        }

        switch (action) {

            case MotionEvent.ACTION_DOWN:
                Log.d("MultiTouch", "DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("MultiTouch", "MOVE");
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.d("MultiTouch", "POINTER DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("MultiTouch", "UP");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.d("MultiTouch", "POINTER UP");
                break;
            case MotionEvent.ACTION_OUTSIDE:
                Log.d("MultiTouch", "OUTSIDE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("MultiTouch", "CANCEL");
                break;
        }
        return true;
    }
}