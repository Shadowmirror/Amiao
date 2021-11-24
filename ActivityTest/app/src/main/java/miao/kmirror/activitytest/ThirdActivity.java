package miao.kmirror.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends BaseActivity {

    public static final String  TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_third);
    }
}