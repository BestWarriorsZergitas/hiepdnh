package com.doannghesi.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.doannghesi.R;


/**
 * Created by binhnk on 7/25/2017.
 */

public class RateAppDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private OnButtonClicked onButtonClicked;

    private TextView tvRateApp, tvNotNow;

    public RateAppDialog(@NonNull Context context, OnButtonClicked onButtonClicked) {
        super(context);
        this.context = context;
        this.onButtonClicked = onButtonClicked;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_rate_app);

        tvRateApp = (TextView) findViewById(R.id.tv_rate_app);
        tvNotNow = (TextView) findViewById(R.id.tv_not_now);

        tvRateApp.setOnClickListener(this);
        tvNotNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_not_now:
                dismiss();
                onButtonClicked.onCancelClicked();
                break;

            case R.id.tv_rate_app:
                dismiss();
                onButtonClicked.onRateClicked();
                break;

            default:
                dismiss();
                break;
        }
    }

    public interface OnButtonClicked {
        void onRateClicked();

        void onCancelClicked();
    }
}
