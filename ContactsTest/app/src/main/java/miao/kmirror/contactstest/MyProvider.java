package miao.kmirror.contactstest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;

    public static final int TABLE1_ITEM = 1;

    public static final int TABLE2_DIR = 2;

    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example");
    }

    /**
     * 初始化内容提供器的时候调用。通常会在这里完成对数据库的创建和升级等操作，返回 true 表示内容提供器初始化成功，
     * 返回 false 则表示失败。
     * */
    @Override
    public boolean onCreate() {
        return false;
    }

    /**
     * 从内容提供器中查询数据。使用 uri 参数来确定查询那张表，projection 参数用于确定查询哪些列，selection 和
     * selectionArgs 参数用于对结果进行排序，查询结果存放在 Cursor 对象中返回。
     * */
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    /**
     * 根据传入的内容 URI 来返回相应的 MIME 类型
     * */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    /**
     * 向内容提供器中已有的数据。使用 uri 参数来确定要添加到的表，待添加的数据保存在 values 参数中。添加完成后，返回
     * 一个用于表示这条行记录的 URI。
     * */
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    /**
     * 从内容提供器中删除数据。使用 uri 参数来确定删除哪一张表中的数据，selection 和 selectionArgs 参数用于约束删除
     * 哪些行，受影响的行数作为返回值返回。
     * */
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    /**
     * 更新内容提供器中已有的数据。使用 uri 参数来确定更新哪一张表中的数据，新数据保存在 values 参数中，selection 和
     * selectionArgs 参数用于约束更新那些行，受影响的行数将作为返回值返回。
     * */
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        return 0;
    }
}
