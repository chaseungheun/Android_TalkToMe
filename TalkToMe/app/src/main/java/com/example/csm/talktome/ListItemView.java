package com.example.csm.talktome;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by CSH on 2017-12-05.
 */

public class ListItemView extends LinearLayout {
    TextView textTitle;
    TextView textContent;
    TextView textDate;
    public ListItemView(Context context) {
        super(context);
        init(context);
    }

    public ListItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item,this,true);
        textTitle =(TextView) findViewById(R.id.textTitle);
        textContent =(TextView) findViewById(R.id.textContent);
        textDate =(TextView) findViewById(R.id.textDate);

    }
    public void setTitle(String title)
    {
        textTitle.setText(title);
    }
    public void setContent(String content)
    {
        textContent.setText(content);
    }
    public void setDate(String date)
    {
        textDate.setText(date);
    }

}
