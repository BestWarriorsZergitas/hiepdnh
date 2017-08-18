package com.doannghesi.luckyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doannghesi.R;
import com.doannghesi.activities.MainActivity;
import com.doannghesi.utils.Constant;
import com.doannghesi.utils.PreferenceUtils;
import com.doannghesi.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by binhnk on 7/12/2017.
 */

public class LuckyWheel2Activity extends AppCompatActivity {
    private List<LuckyItem> data = new ArrayList<>();
    private int score;
    private TextView tvLucky,tvScore;
    private ImageView ivBack,ivShare;
    private CountdownView mCvCountdownView ;
    private Button btSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.lucky_activity_2);
        score= PreferenceUtils.getIntFromPreference(Constant.Preferences.SCORE,this);
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvScore.setText("Coins: "+score);

        tvLucky=(TextView)findViewById(R.id.tv_lucky);
        btSpin=(Button)findViewById(R.id.play);
        tvLucky.setVisibility(View.GONE);
        ivShare=(ImageView)findViewById(R.id.iv_share_face);
        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View rootView = getWindow().getDecorView().findViewById(R.id.viewRoot);
                Utils.initShareIntent(LuckyWheel2Activity.this,"com.facebook.katana",Utils.getScreenShot(rootView));
            }
        });
        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCvCountdownView=(CountdownView)findViewById(R.id.cd_view);
        mCvCountdownView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                cv.setVisibility(View.GONE);
                btSpin.setEnabled(true);
            }
        });
        long outTime=PreferenceUtils.getLongFromPreference(Constant.Preferences.OUT_TIME,this);
        long residualTime=PreferenceUtils.getLongFromPreference(Constant.Preferences.RESIDUAL_TIME,this);

        if (System.currentTimeMillis()-outTime>=residualTime){
            mCvCountdownView.setVisibility(View.GONE);
            btSpin.setEnabled(true);
        }else {
            mCvCountdownView.setVisibility(View.VISIBLE);
            mCvCountdownView.start(residualTime-(System.currentTimeMillis()-outTime));
            btSpin.setEnabled(false);
        }

        final LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        LuckyItem luckyItem1 = new LuckyItem("1", R.drawable.test1, 0xffFFF3E0);
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem("2", R.drawable.test2, 0xffFFE0B2);
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem("3", R.drawable.test3, 0xffFFCC80);
        data.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem("4", R.drawable.test4, 0xffFFF3E0);
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem("5", R.drawable.test5, 0xffFFE0B2);
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem("6", R.drawable.test6, 0xffFFCC80);
        data.add(luckyItem6);

        LuckyItem luckyItem7 = new LuckyItem("7", R.drawable.test7, 0xffFFF3E0);
        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem("8", R.drawable.test8, 0xffFFE0B2);
        data.add(luckyItem8);

        LuckyItem luckyItem9 = new LuckyItem("9", R.drawable.test9, 0xffFFCC80);
        data.add(luckyItem9);

        LuckyItem luckyItem10 = new LuckyItem("10", R.drawable.test10, 0xffFFF3E0);
        data.add(luckyItem10);

        LuckyItem luckyItem11 = new LuckyItem("20", R.drawable.test10, 0xffFFE0B2);
        data.add(luckyItem11);

        LuckyItem luckyItem12 = new LuckyItem("30", R.drawable.test10, 0xffFFCC80);
        data.add(luckyItem12);

        luckyWheelView.setData(data);
        luckyWheelView.setRound(6);


        btSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luckyWheelView.startLuckyWheelWithTargetIndex(getRandomIndex());
            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                tvLucky.setText("Bạn đã nhận được "+Integer.parseInt(data.get(index-1).getText())+" coins");
                score+=Integer.parseInt(data.get(index-1).getText());
                tvScore.setText("Coins: "+score);
                PreferenceUtils.save(Constant.Preferences.SCORE,score,LuckyWheel2Activity.this);
                tvLucky.setVisibility(View.VISIBLE);
                mCvCountdownView.setVisibility(View.VISIBLE);
                mCvCountdownView.start(86400000);
                btSpin.setEnabled(false);

            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size())+1;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceUtils.save(Constant.Preferences.OUT_TIME,System.currentTimeMillis(),this);
        PreferenceUtils.save(Constant.Preferences.RESIDUAL_TIME,mCvCountdownView.getRemainTime(),this);
    }
}
