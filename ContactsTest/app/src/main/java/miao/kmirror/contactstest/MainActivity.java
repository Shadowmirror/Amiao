package miao.kmirror.contactstest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kmirror
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    ArrayAdapter<String> adapter;

    List<String> contactsList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView contactsView = findViewById(R.id.contacts_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList);
        contactsView.setAdapter(adapter);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            Log.d(TAG, "是否进入readContacts");
            readContacts();
        }
    }

    private void readContacts() {
        Cursor cursor = null;
        try{
            Log.d(TAG, "readContacts: 是否获取CONTENT_URI" + ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);
            if(cursor != null){
                while(cursor.moveToNext()){
                    Log.d(TAG, "readContacts: 是否获取cursor");
                    // 获取联系人姓名
                    @SuppressLint("Range") String displayName =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    // 获取联系人手机号
                    @SuppressLint("Range") String number =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    // 添加至 contactsList
                    contactsList.add(displayName + "\n" + number);
                    Log.d("MainActivity", "miao");
                }
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(cursor != null){
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    readContacts();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}