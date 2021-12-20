package miao.kmirror.viewlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView = findViewById(R.id.custom_view);
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: miao");
            }
        });
        /**
         * View 动画不能改变 View 的位置参数。如果对一个 Button 进行如上的平移动画操作，当 Buttom 平移 300 像素
         * 并停留在当前位置，我们点击这个 Button 无法触发点击事件，但是点击之前的位置可以
         * */
        customView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.traslate));

    }
}