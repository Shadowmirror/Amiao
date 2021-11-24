package miao.kmirror.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // 此处添加逻辑

                /*
                * ProgressDialog 和 AlertDialog 有点类似，都可以在界面上弹出一个对话框，都能够屏蔽掉其他控件的交互能力
                * 不同的是， ProgressDialog 会在对话框中显示一个进度条，一般用于表示当前操作比较耗时
                *
                * 注意：如果在 setCancelable() 中传入了 false，表示 ProgressDialog 是不能通过 Back 键取消掉的，
                *   此时就一定要在代码中做好控制，当数据加载完成后必须要调用 ProgressDialog 的 dismiss() 方法
                *   来关闭对话框，否则 ProgressDialog 将会一直存在。
                * */
                // 构建一个ProgressDialog对象
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                // 设置标题
                progressDialog.setTitle("这是ProgressDialog的标题");
                // 设置内容
                progressDialog.setMessage("这是ProgressDialog的内容");
                // 设置可否取消
                progressDialog.setCancelable(true);
                progressDialog.show();


                break;
            default:
                break;
        }
    }
}