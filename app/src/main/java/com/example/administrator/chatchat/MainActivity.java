package com.example.administrator.chatchat;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private Button btnSend,btnReceive;
    private EditText inputText;
    private ListView msgListView;
    private MsgAdapter adapter;
    private List<Msg> msgList=new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//extends Activity 才可使用特色
        setContentView(R.layout.activity_main);

        initMsgs();
        adapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);

        msgListView= (ListView) findViewById(R.id.msg_list_view);
        inputText= (EditText) findViewById(R.id.input_text);
        btnSend= (Button) findViewById(R.id.send);
        btnReceive= (Button) findViewById(R.id.receive);

        msgListView.setAdapter(adapter);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    msgList.add(new Msg(content,Msg.TYPE_SEND));
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    msgList.add(new Msg(content,Msg.TYPE_RECEIVE));
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
    }

    private  void initMsgs(){
        msgList.add(new Msg("你是叉鸡啊",Msg.TYPE_SEND));
        msgList.add(new Msg("对啊",Msg.TYPE_RECEIVE));
        msgList.add(new Msg("I'm Charge Stark, the son of Tony Stark.I'm the right king of the seven kingdom.The iron throne ought to be mine.",Msg.TYPE_RECEIVE));
    }
}
