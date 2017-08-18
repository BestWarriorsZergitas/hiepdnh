package com.doannghesi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.doannghesi.R;
import com.doannghesi.luckyview.LuckyWheel2Activity;
import com.doannghesi.utils.Constant;
import com.doannghesi.utils.PreferenceUtils;

/**
 * Created by Peih Gnaoh on 8/10/2017.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView buttonPlay,buttonSpin,buttonExit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        initUI();
    }

    private void initUI() {
        buttonPlay=(TextView)findViewById(R.id.iv_play);
        buttonSpin=(TextView)findViewById(R.id.lucky_spin);
        buttonExit=(TextView)findViewById(R.id.iv_exit);

        buttonPlay.setOnClickListener(this);
        buttonSpin.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_play:
                int level= PreferenceUtils.getIntFromPreference(Constant.Preferences.LEVEL,this);
                if (level<=49){
                    startActivity(new Intent(this,MainActivity.class));
                }else {
                    startActivity(new Intent(this,GameOverActivity.class));
                }

                break;
            case R.id.lucky_spin:
                startActivity(new Intent(this,LuckyWheel2Activity.class));
                break;
            case R.id.iv_exit:
                finish();
                break;
        }
    }
}
