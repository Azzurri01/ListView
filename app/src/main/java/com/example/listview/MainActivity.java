package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String item[]={
            "Student",
            "Phone",
            "Email",
            "LinkedIn",
            "Twitter",
            "Facebook",
            "Instagram",
            "Whatsapp",
            "Skype"};

    int image[]={
            R.drawable.student,
            R.drawable.phone,
            R.drawable.email,
            R.drawable.linkedin,
            R.drawable.twitter,
            R.drawable.facebook,
            R.drawable.instagram,
            R.drawable.whatsapp,
            R.drawable.skype};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listView);

        CustAdapter custAdapter= new CustAdapter();
        lv.setAdapter(custAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "U clicked:" + item[position],Toast.LENGTH_SHORT).show();
            }
        });
}

class CustAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return image.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.activity_list_view, null);

            ImageView i = (ImageView)  v.findViewById(R.id.itemName);
            TextView t = (TextView) v.findViewById(R.id.itemPic);

            i.setImageResource(image[position]);
            t.setText(item[position]);

            return v;
        }
    }
}