package com.example.csm.talktome;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class RoomActivity extends AppCompatActivity {
    EditText con,ti;
    AlertDialog.Builder aDialog;
    ListAdapter adapter;
    View layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        aDialog = new AlertDialog.Builder(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        Button addbtn = (Button) findViewById(R.id.button_add);
        adapter = new ListAdapter();

        addbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                layout = inflater.inflate(R.layout.list_add,null);


                aDialog.setTitle("새 메모 만들기");
                aDialog.setView(layout);
                aDialog.setPositiveButton("확인",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        ti=(EditText)layout.findViewById(R.id.editTitle);
                        con=(EditText)layout.findViewById(R.id.editContent);
                        adapter.addItem(new ListItem(ti.getText().toString(),con.getText().toString(),getDateString()));
                    }

                });
                aDialog.setNegativeButton("취소",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                    }
                });
                AlertDialog ad = aDialog.create();
                ad.show();
            }
        });

        listView.setAdapter(adapter);
    }
    class ListAdapter extends BaseAdapter {
        ArrayList<ListItem> items= new ArrayList<ListItem>();
        @Override
        public int getCount() {
            return items.size(); //리스트뷰 사이즈 반환
        }
        public void addItem(ListItem item){
            items.add(item);
        }
        @Override
        public Object getItem(int position) {
            return items.get(position);  //리스트뷰 아이템 반환
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListItemView view = new ListItemView(getApplicationContext());
            ListItem item = items.get(position);
            view.setTitle(item.getItemTitle());
            view.setContent(item.getItemcontent());
            view.setDate(item.getItemdate());
            return view;
        }
    }
    public String getDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd", Locale.KOREA);
        String str_date = df.format(new Date());

        return str_date;
    }

}
