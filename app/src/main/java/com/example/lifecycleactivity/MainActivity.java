package com.example.lifecycleactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY_BUNDLE = "oldBundle";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getCharSequence(KEY_BUNDLE));
        } else {
            logView("onCreate (" + null + ")");
        }
        logView("onCreate");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        logView("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        logView("onSaveInstanceState");
        outState.putCharSequence(KEY_BUNDLE, textView.getText());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        logView("onBackPressed");
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        logView("onKeyDown");
        Toast.makeText(this,
                String.valueOf(keyCode),
                Toast.LENGTH_SHORT).show();
        event.startTracking();
        return true;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        logView("onKeyLongPress");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    protected void onStart(){
        super.onStart();
        logView("onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        logView("onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        logView("onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        logView("onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        logView("onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        logView("onRestart");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        logView("onPostCreate");
    }

    @Override
    protected void onPostResume(){
        super.onPostResume();
        logView("onPostResume");
    }

    private void logView(String msg) {
        Log.d(TAG, msg);
        textView.append("\n" + msg);
    }
}