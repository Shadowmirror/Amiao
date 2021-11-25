package miao.kmirror.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 数组中的数据时无法直接传递给 ListView 的，我们还需要借助适配器来完成。Android 中提供了很多适配器的实现类，
        // 第一行代码用的是 ArrayAdapter。 它可以通过泛型指定为 String，然后再 ArrayAdapter 的构造函数中一次传入
        // 当前上下文、ListView 子项布局的id，以及要适配的数据。

        // 注意：我们使用了 android.R.layout.simple_list_item_1 作为 ListView 子项布局的 id，
        // 这是一个 Android 内置的布局文件，里面只有一个 TextView，可用于简单地显示一段文本。这样适配器就构建好了
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        // 调用 ListView 的 setAdapter() 方法，将构建好的适配器对象传递进去，这样 ListView 和数据之间的关联就建立完成了。
        listView.setAdapter(adapter);
    }
}