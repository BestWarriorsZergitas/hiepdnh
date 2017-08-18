package com.doannghesi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.doannghesi.R;
import com.doannghesi.objects.OChu;

import java.util.ArrayList;

/**
 * Created by Peih Gnaoh on 7/28/2017.
 */

public class GridViewGoiYAdpater extends BaseAdapter {
    private Context context;
    private ArrayList<OChu> listOChu;
    private OnItemClick onItemClick;

    public GridViewGoiYAdpater(Context context, ArrayList<OChu> list,OnItemClick onItemClick) {
        this.context = context;
        listOChu = list;
        this.onItemClick=onItemClick;
    }

    @Override
    public int getCount() {
        return listOChu.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemActivity = inflater.inflate(R.layout.item_goi_y, parent, false);
        TextView textView = (TextView) itemActivity.findViewById(R.id.tv_char);
        textView.setText(listOChu.get(position).getText());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });
        return itemActivity;
    }
    public interface OnItemClick{
        void onClick(int position);
    }
}
