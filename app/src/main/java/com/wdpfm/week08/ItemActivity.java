package com.wdpfm.week08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Actor actor = (Actor) getIntent().getSerializableExtra("person_data");
        Toast.makeText(this, actor.getName(), Toast.LENGTH_SHORT).show();
        ImageView myimg = (ImageView)findViewById(R.id.iImageView);
        TextView myname = (TextView)findViewById(R.id.iTextView);
        TextView myinfo = (TextView)findViewById(R.id.iTextView2);
        myimg.setImageResource(actor.getImg());
        myname.setText(actor.getName());
        myinfo.setText(actor.getInfo());
    }
}
