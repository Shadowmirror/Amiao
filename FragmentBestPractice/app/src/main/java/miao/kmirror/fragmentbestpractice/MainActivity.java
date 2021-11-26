package miao.kmirror.fragmentbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * @author Kmirror
 *
 * 主活动
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /**
         * 根据屏幕大小或者最小限定符进入哪个activity_main.xml
         * */
        setContentView(R.layout.activity_main);
    }
}