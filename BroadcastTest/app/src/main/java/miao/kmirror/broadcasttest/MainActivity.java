package miao.kmirror.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeRecevier networkChangeRecevier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        // 当网络状态发生变化时，系统发出的正式一条值为 android.net.conn.CONNECTIVITY_CHANGE 的广播
        // 也就是说我们的广播接收器想监听什么广播,就在这里添加相应的 action.
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeRecevier = new NetworkChangeRecevier();
        registerReceiver(networkChangeRecevier, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 动态注册的广播接收器一定都要取消注册才行，这里我们是在 onDestroy()方法中通过调用 unregisterReceiver()
        // 方法来实现的。
        unregisterReceiver(networkChangeRecevier);
    }

    class NetworkChangeRecevier extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
        }
    }
}