package miao.kmirror.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

import java.util.List;

import miao.kmirror.litepaltest.entity.Book;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Kmirror 的第一本书");
                book.setAuthor("Kmirror");
                book.setPages(454);
                book.setPrice(12.12);
                book.setPress("喵喵星");
                book.save();
            }
        });

        Button updateData = findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Book book = new Book();
//                book.setName("Gmirror 的第一本书");
//                book.setAuthor("Gmirror");
//                book.setPages(1231);
//                book.setPrice(12312.12);
//                book.setPress("Unknow");
//                book.save();
//                book.setPrice(10.99);
//                book.save();

//                Book book = new Book();
//                book.setPrice(14.95);
//                book.setPress("地球");
//                book.updateAll("name = ? and author = ?", "Gmirror 的第一本书", "Gmirror");

                Book book = new Book();
                book.setToDefault("pages");
                book.updateAll();
            }
        });

        Button deleteData = findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class, "price < ?", "15");
            }
        });

        Button queryData = findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book : books) {
                    Log.d(TAG, "Book name is " + book.getName());
                    Log.d(TAG, "Book author is " + book.getAuthor());
                    Log.d(TAG, "Book pages is " + book.getPages());
                    Log.d(TAG, "Book price is " + book.getPrice());
                    Log.d(TAG, "Book press is " + book.getPress());
                }
            }
        });
    }
}