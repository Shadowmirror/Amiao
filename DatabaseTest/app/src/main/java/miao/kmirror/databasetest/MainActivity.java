package miao.kmirror.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);
                values.clear();
                // 开始组装第二条数据
                values.put("name", "The Lost Symbol");
                values.put("author", "Kmirror");
                values.put("pages", 510);
                values.put("price", 19.76);
                db.insert("Book", null, values);


            }
        });

        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "id=?", new String[]{"1"});
            }
        });

        Button DeleteData = (Button) findViewById(R.id.delete_data);
        DeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"500"});
            }
        });

        Button QueryData = (Button) findViewById(R.id.query_data);
        QueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor book = db.query("Book", null, null, null, null, null, null);
                if(book.moveToFirst()){
                    do{
                        // 遍历Cursor对象，取出数据并打印
                        @SuppressLint("Range") String name = book.getString(book.getColumnIndex("name"));
                        @SuppressLint("Range") String author = book.getString(book.getColumnIndex("author"));
                        @SuppressLint("Range") int pages = book.getInt(book.getColumnIndex("pages"));
                        @SuppressLint("Range") double  price = book.getDouble(book.getColumnIndex("price"));
                        Log.d(TAG, "Book name is " + name);
                        Log.d(TAG, "Book author is " + author);
                        Log.d(TAG, "Book pages is " + pages);
                        Log.d(TAG, "Book price is " + price);
                    }while (book.moveToNext());
                }
                book.close();
            }
        });
    }
}