package com.wdpfm.week08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //创建ListView控件对象
    private ListView myListView;
    //创建一个数据适配器
    private PersonAdapter myAdapter;
    //创建数组，作为ListView的数据来源
    private String[] names = {"Sheldon Cooper","Amy Farrah Fowler","Leonard Hofstadter","Penny","Raj Koothrappali"};
    private String[] infos = {"\t\t谢尔顿·李·库珀博士（英语：Sheldon Lee Cooper）是CBS推出的情景喜剧《生活大爆炸》（The Big Bang Theory）中的一个智商高达187的物理天才，该角色具有二次元思维特点，由吉姆·帕森斯饰演。在《少年谢尔顿》由伊恩·阿米蒂奇饰演。剧中帕森斯因为扮演这个角色在2010年获得艾美奖，2011年1月获得金球奖。2013年9月22日荣获艾美奖喜剧类最佳男主角。","\t\tAmy,在第三季的最后一集，她的出现实在太炫目，使观众对第四季的期待直接拔高了N个层次。Amy的职业是神经生物学家大家叫她和Sheldon为“Shamy”（Sheldon&Amy）她与耳朵有很多相似之处。","\t\t莱纳德·李奇·霍夫斯塔特博士（英语：Leonard Leakey Hofstadter,Ph.D，亦译为莱纳德·霍夫斯塔德）是哥伦比亚广播公司（CBS）电视剧《生活大爆炸》中的一个虚构角色，由约翰尼·盖尔克奇饰演。莱纳德是一位实验物理学家，与同事兼好友的谢尔顿·库珀（吉姆·帕森斯饰）共住一间公寓。莱纳德的角色名称来自于演员和制片人谢尔顿·莱纳德，及诺贝尔奖获得者罗伯特·霍夫施塔特。","\t\t佩妮，是CBS推出的情景喜剧《生活大爆炸》中的一个主要角色，由美国演员凯莉·库柯饰演。另有美国卡通片《神探加杰特》人物。","\t\t全名为：拉杰什·罗摩衍那·库斯拉帕里博士，（英语：Rajesh Ramayan \"Raj\" Koothrappali, Ph.D，亦译为拉杰什·库斯拉帕里 ）是哥伦比亚广播公司（CBS）电视剧《生活大爆炸》中的一个虚构角色，由昆瑙·内亚饰演。"};
    private int[] imgs = {R.mipmap.s,R.mipmap.a, R.mipmap.h, R.mipmap.p, R.mipmap.r};
    //作为ListView的数据来源
    private List<Actor> actors = new ArrayList<Actor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("生活大爆炸角色介绍");
        //显示ListView
        //1.获取ListView
        myListView = findViewById(R.id.ListView);
        //初始化数据
        initDataActors();
        //2.创建适配器对象(参数1：数据源,参数2：context 上下文)
        myAdapter = new PersonAdapter(actors,MainActivity.this);
        //3.加载适配器
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(this);
    }

    //初始化数据
    private void initDataActors(){
        for (int i=0;i<names.length;i++){
            //新建Person对象,存放头像及姓名
            Actor actor = new Actor(names[i],imgs[i],infos[i]);
            //将数据存入数据列表
            actors.add(actor);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Actor actor = actors.get(position);
        Toast.makeText(this, actor.getName(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(MainActivity.this,ItemActivity.class);
        intent.putExtra("person_data", actor);
        startActivity(intent);
    }
}
