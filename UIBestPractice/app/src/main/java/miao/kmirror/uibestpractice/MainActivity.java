package miao.kmirror.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import miao.kmirror.uibestpractice.Adapter.MsgAdapter;
import miao.kmirror.uibestpractice.Entity.Msg;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化消息
        initMsgs();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    // 当又新消息时刷新 RecyclerView 中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    // 将 RecyclerView 定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    // 清空输入框中的内容
                    inputText.setText("");

                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello Kmirror.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello Gmirror.", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Miao. Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}