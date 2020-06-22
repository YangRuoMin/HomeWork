package com.example.mebutton;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * 按钮
     */
    private MyButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButton = (MyButton) findViewById(R.id.button);
        mButton.setTranslationX(Shared.getInstance().getTranslationX());
        mButton.setTranslationY(Shared.getInstance().getTranslationY());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Shared.getInstance().setTranslationX(mButton.getLastX());
        Shared.getInstance().setTranslationY(mButton.getLastY());
    }
}
