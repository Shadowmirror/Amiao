package com.zyx.pwdmanager.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ITEM".
*/
public class ItemDao extends AbstractDao<Item, Long> {

    public static final String TABLENAME = "ITEM";

    /**
     * Properties of entity Item.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property GroupId = new Property(1, Long.class, "groupId", false, "GROUP_ID");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Account = new Property(3, String.class, "account", false, "ACCOUNT");
        public final static Property Password = new Property(4, String.class, "password", false, "PASSWORD");
        public final static Property Remark = new Property(5, String.class, "remark", false, "REMARK");
    }

    private DaoSession daoSession;

    private Query<Item> group_ItemListQuery;

    public ItemDao(DaoConfig config) {
        super(config);
    }
    
    public ItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ITEM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"GROUP_ID\" INTEGER," + // 1: groupId
                "\"TITLE\" TEXT," + // 2: title
                "\"ACCOUNT\" TEXT," + // 3: account
                "\"PASSWORD\" TEXT," + // 4: password
                "\"REMARK\" TEXT);"); // 5: remark
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_ITEM_GROUP_ID ON \"ITEM\"" +
                " (\"GROUP_ID\" ASC);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_ITEM_TITLE ON \"ITEM\"" +
                " (\"TITLE\" ASC);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_ITEM_ACCOUNT ON \"ITEM\"" +
                " (\"ACCOUNT\" ASC);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_ITEM_PASSWORD ON \"ITEM\"" +
                " (\"PASSWORD\" ASC);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_ITEM_REMARK ON \"ITEM\"" +
                " (\"REMARK\" ASC);");
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_ITEM_GROUP_ID_DESC_TITLE_DESC ON \"ITEM\"" +
                " (\"GROUP_ID\" DESC,\"TITLE\" DESC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ITEM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Item entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long groupId = entity.getGroupId();
        if (groupId != null) {
            stmt.bindLong(2, groupId);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(4, account);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(5, password);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(6, remark);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Item entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long groupId = entity.getGroupId();
        if (groupId != null) {
            stmt.bindLong(2, groupId);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(4, account);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(5, password);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(6, remark);
        }
    }

    @Override
    protected final void attachEntity(Item entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Item readEntity(Cursor cursor, int offset) {
        Item entity = new Item( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // groupId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // account
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // password
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // remark
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Item entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGroupId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAccount(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPassword(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRemark(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Item entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Item entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Item entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "itemList" to-many relationship of Group. */
    public List<Item> _queryGroup_ItemList(Long groupId) {
        synchronized (this) {
            if (group_ItemListQuery == null) {
                QueryBuilder<Item> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GroupId.eq(null));
                group_ItemListQuery = queryBuilder.build();
            }
        }
        Query<Item> query = group_ItemListQuery.forCurrentThread();
        query.setParameter(0, groupId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getGroupDao().getAllColumns());
            builder.append(" FROM ITEM T");
            builder.append(" LEFT JOIN GROUP T0 ON T.\"GROUP_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Item loadCurrentDeep(Cursor cursor, boolean lock) {
        Item entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Group group = loadCurrentOther(daoSession.getGroupDao(), cursor, offset);
        entity.setGroup(group);

        return entity;    
    }

    public Item loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Item> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Item> list = new ArrayList<Item>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Item> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Item> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
