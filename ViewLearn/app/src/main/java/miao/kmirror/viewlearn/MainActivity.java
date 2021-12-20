package miao.kmirror.viewlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
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
//        /**
//         * View 动画不能改变 View 的位置参数。如果对一个 Button 进行如上的平移动画操作，当 Bottom 平移 300 像素
//         * 并停留在当前位置，我们点击这个 Button 无法触发点击事件，但是点击之前的位置可以
//         * */
//        customView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));

//        /**
//         * 属性动画就能解决上述问题
//         * 0 为初始偏移位置
//         * 300 为偏移多少距离
//         * 1000 为偏移时间为 1s
//         * */
//        ObjectAnimator.ofFloat(customView, "translationX", 0, 300)
//                .setDuration(1000)
//                .start();


    }
}