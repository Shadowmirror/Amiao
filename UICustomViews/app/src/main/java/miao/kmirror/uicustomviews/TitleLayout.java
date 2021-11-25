package miao.kmirror.uicustomviews;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout {
    // 我们重写了 LinearLayout 中带有两个参数的构造函数，在布局中引入 TitleLayout
    // 就会调用这个构造函数。然后在这个构造函数中需要对标栏布局进行动态加载，这就要借助
    // LayoutInflater 来实现了。
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // LayoutInflater 的 from() 方法可以构建出一个 LayoutInflater 对象，
        // 然后调用 inflate() 方法就可以动态加载一个布局文件
        // inflate() 方法接收两个参数
        //  第一个参数是要加载的布局文件的 id，这里我们传入的是R.layout.title
        //  第二个参数是给加载好的布局再添加一个父布局，这里我们想要指定 TitleLayout
        //  于是直接传入 this
        LayoutInflater.from(context).inflate(R.layout.title, this);
    }
}
