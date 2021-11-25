package miao.kmirror.listviewtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    // FruitAdapter 重写了父类的一组构造函数，用于将上下文、ListView 子项布局的 id 和数据都传递进来。
    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    // 重写 getView() 方法，这个方法在每个子项被滚动到屏幕内的时候会被调用。在 getView() 方法中，首先通过 getItem()
    // 方法得到当前项的 Fruit 实例，然后使用 LayoutInflater 来为这个子项加载我们传入的布局。

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        // 这里 LayoutInflater 的 inflate() 方法接收 3 个参数，前两个参数我们已经知道什么意思了，
        // 第三个参数指定成 false，表示只让我们在父布局中声明的 layout 属性生效，但不会为这个 View 添加父布局，
        // 因为一旦 View 有了父布局之后，它就不能再添加到 ListView 中了。
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imageView = view.findViewById(R.id.fruit_image);
        TextView textView =  view.findViewById(R.id.fruit_name);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());
        return view;
    }
}
