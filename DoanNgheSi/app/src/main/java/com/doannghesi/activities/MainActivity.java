package com.doannghesi.activities;

import android.Manifest;
import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.doannghesi.objects.Singer;
import com.doannghesi.utils.Constant;
import com.doannghesi.adapters.GridViewGoiYAdpater;
import com.doannghesi.objects.MyGridView;
import com.doannghesi.objects.OChu;
import com.doannghesi.utils.DatabaseManager;
import com.doannghesi.utils.PreferenceUtils;
import com.doannghesi.R;
import com.doannghesi.objects.ScratchImageView;
import com.doannghesi.utils.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GridViewGoiYAdpater.OnItemClick {
    private ScratchImageView scratchImageView;
    private ImageView ivKetQua,ivBack,ivShare;
    private ArrayList<TextView> listTvDapAn;
    private ArrayList<Integer> position;
    private MyGridView gridViewDapAn, gridViewGoiY;
    private TextView tvDapAn1, tvDapAn2, tvDapAn3, tvDapAn4,
            tvDapAn5, tvDapAn6, tvDapAn7, tvDapAn8, tvDapAn9,
            tvDapAn10, tvDapAn11, tvDapAn12, tvDapAn13, tvDapAn14, tvDapAn15, tvDapAn16, tvPercent, tvScore, tvTrueFalse, tvSinger, tvAddCoins, tvNext;
    private View viewPrevent;
    private int count = 0;
    private int length;
    private ArrayList<OChu> listOChuGoiY;
    private ImageView btCaoLai, btMo1O, btGoiY, btboQua;
    private ArrayList<Singer> singers=new ArrayList<>();
    private int level = 0;
    private int score = 0;
    private GridViewGoiYAdpater goiYAdpater;
    private LinearLayout lnDapAn;
    private static final String[] PERMISSION =
            {Manifest.permission.READ_EXTERNAL_STORAGE
                    , Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Utils.checkPermission(PERMISSION, MainActivity.this) == PackageManager.PERMISSION_GRANTED) {

            } else {
                MainActivity.this.requestPermissions(PERMISSION, 1);
            }
        }
        level = PreferenceUtils.getIntFromPreference(Constant.Preferences.LEVEL,this);
        score = PreferenceUtils.getIntFromPreference(Constant.Preferences.SCORE, this);
        initUI();
    }

    private void initUI() {
        singers.addAll(DatabaseManager.INSTANCE.getSingerList(this));
        tvPercent = (TextView) findViewById(R.id.tv_percent);
        ivShare=(ImageView)findViewById(R.id.iv_share_face);
        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View rootView = getWindow().getDecorView().findViewById(R.id.viewRoot);
                Utils.initShareIntent(MainActivity.this,"com.facebook.katana",Utils.getScreenShot(rootView));
            }
        });
        gridViewGoiY = (MyGridView) findViewById(R.id.grid_goi_y);
        scratchImageView = (ScratchImageView) findViewById(R.id.scratch_view);
        scratchImageView.setStrokeWidth(1);
        scratchImageView.setRevealListener(new ScratchImageView.IRevealListener() {
            @Override
            public void onRevealed(ScratchImageView iv) {

            }

            @Override
            public void onRevealPercentChangedListener(ScratchImageView siv, float percent) {
                DecimalFormat formatter = new DecimalFormat("#0.00");
                String get_value = formatter.format(percent * 100);
                tvPercent.setText("Đã cào: "+get_value+"%");
                if (percent >= 0.05) {
                    scratchImageView.setFillStyle();
                    tvPercent.setText("Đã cào: 5,00%");
                }
            }
        });
        scratchImageView.setImageResource(singers.get(level).getImg());
        ivKetQua = (ImageView) findViewById(R.id.iv_ket_qua);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        btCaoLai = (ImageView) findViewById(R.id.iv_cao_lai);
        btboQua = (ImageView) findViewById(R.id.iv_bo_qua);
        btGoiY = (ImageView) findViewById(R.id.iv_xem_huong_dan);
        btMo1O = (ImageView) findViewById(R.id.iv_mo_1_o_chu);
        btboQua.setOnClickListener(this);
        btCaoLai.setOnClickListener(this);
        btGoiY.setOnClickListener(this);
        btMo1O.setOnClickListener(this);
        ivBack.setOnClickListener(this);

        lnDapAn=(LinearLayout)findViewById(R.id.ln_dap_an);

        length = singers.get(level).getNameAnswer().length();
        Log.e("tét",singers.get(level).getNameAnswer());

        tvDapAn1 = (TextView) findViewById(R.id.tv_dap_an_1);
        tvDapAn2 = (TextView) findViewById(R.id.tv_dap_an_2);
        tvDapAn3 = (TextView) findViewById(R.id.tv_dap_an_3);
        tvDapAn4 = (TextView) findViewById(R.id.tv_dap_an_4);
        tvDapAn5 = (TextView) findViewById(R.id.tv_dap_an_5);
        tvDapAn6 = (TextView) findViewById(R.id.tv_dap_an_6);
        tvDapAn7 = (TextView) findViewById(R.id.tv_dap_an_7);
        tvDapAn8 = (TextView) findViewById(R.id.tv_dap_an_8);
        tvDapAn9 = (TextView) findViewById(R.id.tv_dap_an_9);
        tvDapAn10 = (TextView) findViewById(R.id.tv_dap_an_10);
        tvDapAn11 = (TextView) findViewById(R.id.tv_dap_an_11);
        tvDapAn12 = (TextView) findViewById(R.id.tv_dap_an_12);
        tvDapAn13 = (TextView) findViewById(R.id.tv_dap_an_13);
        tvDapAn14 = (TextView) findViewById(R.id.tv_dap_an_14);
        tvDapAn15 = (TextView) findViewById(R.id.tv_dap_an_15);
        tvDapAn16 = (TextView) findViewById(R.id.tv_dap_an_16);

        tvScore = (TextView) findViewById(R.id.tv_score);
        tvTrueFalse = (TextView) findViewById(R.id.tv_true_false);
        tvSinger = (TextView) findViewById(R.id.tv_singer);
        tvAddCoins = (TextView) findViewById(R.id.tv_add_coins);
        tvNext = (TextView) findViewById(R.id.tv_next);
        tvNext.setOnClickListener(this);

        tvScore.setText("Coins: "+score);

        listTvDapAn = new ArrayList<>();

        listTvDapAn.add(tvDapAn1);
        listTvDapAn.add(tvDapAn2);
        listTvDapAn.add(tvDapAn3);
        listTvDapAn.add(tvDapAn4);
        listTvDapAn.add(tvDapAn5);
        listTvDapAn.add(tvDapAn6);
        listTvDapAn.add(tvDapAn7);
        listTvDapAn.add(tvDapAn8);
        listTvDapAn.add(tvDapAn9);
        listTvDapAn.add(tvDapAn10);
        listTvDapAn.add(tvDapAn11);
        listTvDapAn.add(tvDapAn12);
        listTvDapAn.add(tvDapAn13);
        listTvDapAn.add(tvDapAn14);
        listTvDapAn.add(tvDapAn15);
        listTvDapAn.add(tvDapAn16);

        for (int i = length; i < 16; i++) {
            listTvDapAn.get(i).setVisibility(View.GONE);
        }
        for (int i = 0; i < 16; i++) {
            final int finalI = i;
            listTvDapAn.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listTvDapAn.get(finalI).getText().equals("")) {
                        int i = Integer.parseInt(listTvDapAn.get(finalI).getContentDescription() + "");
                        YoYo.with(Techniques.FlipInX).duration(500).playOn(gridViewGoiY.getChildAt(i));
                        gridViewGoiY.getChildAt(i).setVisibility(View.VISIBLE);
                        gridViewGoiY.getChildAt(i).setEnabled(true);
                        listTvDapAn.get(finalI).setText("");
                        Log.e("onClick", i + "");
                        for (int j=0;j<listTvDapAn.size();j++){
                            listTvDapAn.get(j).setBackground(getResources().getDrawable(R.drawable.button_blue));
                        }
                        tvTrueFalse.setVisibility(View.GONE);
                    }
                }
            });
        }


        ArrayList<String> stringArrayList = new ArrayList<>();
        listOChuGoiY = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String s1 = String.valueOf(singers.get(level).getNameAnswer().charAt(i));
            stringArrayList.add(s1.toUpperCase());
        }
        Random random = new Random();
        for (int i = 0; i < 16 - length; i++) {
            String symbol = (char) (random.nextInt(23) + 65) + "";
            stringArrayList.add(symbol);
        }
        Collections.shuffle(stringArrayList);
        for (int i = 0; i < 16; i++) {
            OChu oChuGoiY = new OChu(stringArrayList.get(i), i);
            listOChuGoiY.add(oChuGoiY);
        }
        goiYAdpater = new GridViewGoiYAdpater(this, listOChuGoiY, this);
        gridViewGoiY.setAdapter(goiYAdpater);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_cao_lai:
                final AlertDialog.Builder builder1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder1 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                } else {
                    builder1 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                }
                builder1.setTitle(null).setMessage("Bạn có muốn dùng 5 coin để cào lại")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (score>=5){
                                    score-=5;
                                    tvScore.setText("Coins: "+score);
                                    PreferenceUtils.save(Constant.Preferences.SCORE, score, MainActivity.this);
                                    scratchImageView.reScratch();
                                    tvPercent.setText("Đã cào: 0,00%");
                                }else {
                                    Toast.makeText(MainActivity.this, "Làm gì có tiền mà đòi", Toast.LENGTH_SHORT).show();
                                }

                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert).show();

                break;
            case R.id.iv_mo_1_o_chu:
                final AlertDialog.Builder builder2;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder2 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                } else {
                    builder2 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                }
                builder2.setTitle(null).setMessage("Bạn có muốn dùng 10 coin để mở 1 ô chữ")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (score>=10){
                                    for (int i = 0; i < length; i++) {
                                        String s = singers.get(level).getNameAnswer().charAt(i) + "";
                                        if (listTvDapAn.get(i).getText().equals("")) {
                                            for (int j = 0; j < listOChuGoiY.size(); j++) {
                                                if (listOChuGoiY.get(j).getText().equals(s)) {
                                                    if (gridViewGoiY.getChildAt(j).getVisibility() == View.VISIBLE) {
                                                        gridViewGoiY.getChildAt(listOChuGoiY.get(j).getPosition()).setVisibility(View.GONE);
                                                        listTvDapAn.get(i).setText(s);
                                                        listTvDapAn.get(i).setContentDescription(listOChuGoiY.get(j).getPosition() + "");
                                                        break;
                                                    }
                                                }
                                            }
                                            score-=10;
                                            tvScore.setText("Coins: "+score);
                                            PreferenceUtils.save(Constant.Preferences.SCORE, score, MainActivity.this);
                                            checkAnswer();
                                            break;
                                        }
                                    }
                                }else {
                                    Toast.makeText(MainActivity.this, "Làm gì có tiền mà đòi", Toast.LENGTH_SHORT).show();
                                }

                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert).show();
                break;
            case R.id.iv_xem_huong_dan:
                final AlertDialog.Builder builder3;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder3 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                } else {
                    builder3 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                }
                builder3.setTitle(null).setMessage("Bạn có muốn dùng 15 coin xem hướng dẫn")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                if (score>=15){
                                    score-=15;
                                    tvScore.setText("Coins: "+score);
                                    PreferenceUtils.save(Constant.Preferences.SCORE, score, MainActivity.this);
                                    final AlertDialog.Builder builder1;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        builder1 = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                                    } else {
                                        builder1 = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                                    }
                                    builder1.setTitle(null).setMessage(singers.get(level).getHint())
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .setIcon(android.R.drawable.ic_dialog_alert).show();
                                }else {
                                    Toast.makeText(MainActivity.this, "Làm gì có tiền mà đòi", Toast.LENGTH_SHORT).show();
                                }


                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert).show();

                break;
            case R.id.iv_bo_qua:
                final AlertDialog.Builder builder4;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder4 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                } else {
                    builder4 = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
                }
                builder4.setTitle(null).setMessage("Bạn có muốn dùng 20 coin để bỏ qua")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (score>=20) {
                                    score-=20;
                                    tvScore.setText("Coins: "+score);
                                    PreferenceUtils.save(Constant.Preferences.SCORE, score, MainActivity.this);
                                    nextLevel();
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(gridViewGoiY);
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(btboQua);
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(btMo1O);
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(btCaoLai);
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(btGoiY);
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(scratchImageView);
                                    YoYo.with(Techniques.FadeInRight).duration(500).playOn(lnDapAn);
                                }else{
                                    Toast.makeText(MainActivity.this, "Làm gì có tiền mà đòi", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert).show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_next:
                nextLevel();
                gridViewGoiY.setVisibility(View.VISIBLE);
                btboQua.setVisibility(View.VISIBLE);
                btMo1O.setVisibility(View.VISIBLE);
                btCaoLai.setVisibility(View.VISIBLE);
                btGoiY.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(gridViewGoiY);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(btboQua);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(btMo1O);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(btCaoLai);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(btGoiY);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(scratchImageView);
                YoYo.with(Techniques.FadeInRight).duration(500).playOn(lnDapAn);


                YoYo.with(Techniques.FlipOutX).onEnd(new YoYo.AnimatorCallback() {
                    @Override
                    public void call(Animator animator) {
                        tvNext.setVisibility(View.GONE);
                    }
                }).duration(500).playOn(tvNext);
                YoYo.with(Techniques.FlipOutX).onEnd(new YoYo.AnimatorCallback() {
                    @Override
                    public void call(Animator animator) {
                        tvTrueFalse.setVisibility(View.GONE);
                    }
                }).duration(500).playOn(tvTrueFalse);
                YoYo.with(Techniques.FlipOutX).onEnd(new YoYo.AnimatorCallback() {
                    @Override
                    public void call(Animator animator) {
                        tvSinger.setVisibility(View.GONE);
                    }
                }).duration(500).playOn(tvSinger);
                YoYo.with(Techniques.FlipOutX).onEnd(new YoYo.AnimatorCallback() {
                    @Override
                    public void call(Animator animator) {
                        tvAddCoins.setVisibility(View.GONE);
                    }
                }).duration(500).playOn(tvAddCoins);

                break;
            default:
                break;
        }
    }

    private void nextLevel() {
      if (level<=48){
          ivKetQua.setVisibility(View.GONE);
          scratchImageView.setVisibility(View.VISIBLE);
          level++;
          PreferenceUtils.save(Constant.Preferences.LEVEL,level,this);
          length = singers.get(level).getNameAnswer().length();
          for (int i = 0; i < length; i++) {
              listTvDapAn.get(i).setVisibility(View.VISIBLE);
              listTvDapAn.get(i).setText("");
              listTvDapAn.get(i).setClickable(true);
              listTvDapAn.get(i).setBackground(getResources().getDrawable(R.drawable.button_blue));
          }
          for (int i = length; i < 16; i++) {
              listTvDapAn.get(i).setVisibility(View.GONE);
          }
          ArrayList<String> stringArrayList = new ArrayList<>();
          listOChuGoiY.clear();
          for (int i = 0; i < length; i++) {
              String s1 = String.valueOf(singers.get(level).getNameAnswer().charAt(i));
              stringArrayList.add(s1.toUpperCase());
          }
          Random random = new Random();
          for (int i = 0; i < 16 - length; i++) {
              String symbol = (char) (random.nextInt(23) + 65) + "";
              stringArrayList.add(symbol);
          }
          Collections.shuffle(stringArrayList);
          for (int i = 0; i < 16; i++) {
              OChu oChuGoiY = new OChu(stringArrayList.get(i), i);
              listOChuGoiY.add(oChuGoiY);
          }
          goiYAdpater.notifyDataSetChanged();
          scratchImageView.setImageResource(singers.get(level).getImg());
          scratchImageView.reScratch();
          tvPercent.setText("Đã cào: 0,00%");
      }else {
          startActivity(new Intent(this,GameOverActivity.class));
          level++;
          PreferenceUtils.save(Constant.Preferences.LEVEL,level,this);
      }

    }

    @Override
    public void onClick(final int position) {
        for (int i = 0; i < length; i++) {
            if (listTvDapAn.get(i).getText().equals("")) {
                YoYo.with(Techniques.FlipOutX).duration(500).playOn(gridViewGoiY.getChildAt(position));
                gridViewGoiY.getChildAt(position).setVisibility(View.GONE);
                listTvDapAn.get(i).setText(listOChuGoiY.get(position).getText());
                YoYo.with(Techniques.DropOut).duration(500).playOn(findViewById(listTvDapAn.get(i).getId()));

                listTvDapAn.get(i).setContentDescription(position + "");
                checkAnswer();
                break;
            }
        }

    }

    private void checkAnswer() {
        Log.e("tét",length+"");
        int count=0;
        for (int i=0;i< length;i++){
            if (!listTvDapAn.get(i).getText().equals("")){
                count++;
                Log.e("tét",count+"");
            }
        }

        if (count == length) {
            String s = "";
            for (int i = 0; i < length; i++) {
                s += listTvDapAn.get(i).getText();
            }
            if (s.equals(singers.get(level).getNameAnswer())) {
                scratchImageView.setVisibility(View.GONE);
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .playOn(findViewById(R.id.iv_ket_qua));
                ivKetQua.setImageResource(singers.get(level).getImg());
                ivKetQua.setVisibility(View.VISIBLE);
                score += 10;
                tvScore.setText("Coins: "+score);
                answerTrue();
                PreferenceUtils.save(Constant.Preferences.SCORE, score, this);
            } else {
               for (int i=0;i<listTvDapAn.size();i++){
                   listTvDapAn.get(i).setBackground(getResources().getDrawable(R.drawable.button_red));
               }
               tvTrueFalse.setText("Sai rồi bạn ey ...");
                tvTrueFalse.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Shake).duration(500).playOn(lnDapAn);
                YoYo.with(Techniques.Shake).duration(500).playOn(tvTrueFalse);
            }
        }
    }

    private void answerTrue() {

        for (int i=0;i<listTvDapAn.size();i++){
            listTvDapAn.get(i).setBackground(getResources().getDrawable(R.drawable.button_green));
            listTvDapAn.get(i).setClickable(false);
        }
        gridViewGoiY.setVisibility(View.GONE);
        btboQua.setVisibility(View.GONE);
        btMo1O.setVisibility(View.GONE);
        btCaoLai.setVisibility(View.GONE);
        btGoiY.setVisibility(View.GONE);

        tvTrueFalse.setText("Bạn trả lời thật chính xác !!");
        tvNext.setVisibility(View.VISIBLE);
        tvTrueFalse.setVisibility(View.VISIBLE);
        tvSinger.setVisibility(View.VISIBLE);
        tvAddCoins.setVisibility(View.VISIBLE);
        tvSinger.setText(singers.get(level).getFullName());

        YoYo.with(Techniques.Tada).duration(500).playOn(tvNext);
        YoYo.with(Techniques.Tada).duration(500).playOn(tvTrueFalse);
        YoYo.with(Techniques.Tada).duration(500).playOn(tvSinger);
        YoYo.with(Techniques.Tada).duration(500).playOn(tvAddCoins);
        YoYo.with(Techniques.Tada).duration(500).playOn(lnDapAn);
    }

    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }

}
