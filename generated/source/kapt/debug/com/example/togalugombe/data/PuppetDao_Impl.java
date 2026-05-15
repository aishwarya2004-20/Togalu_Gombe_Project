package com.example.togalugombe.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PuppetDao_Impl implements PuppetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Puppet> __insertionAdapterOfPuppet;

  private final EntityDeletionOrUpdateAdapter<Puppet> __updateAdapterOfPuppet;

  public PuppetDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPuppet = new EntityInsertionAdapter<Puppet>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `puppets` (`id`,`name`,`role`,`description`,`image`,`isSaved`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Puppet entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getRole() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getRole());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getImage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getImage());
        }
        final int _tmp = entity.isSaved() ? 1 : 0;
        statement.bindLong(6, _tmp);
      }
    };
    this.__updateAdapterOfPuppet = new EntityDeletionOrUpdateAdapter<Puppet>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `puppets` SET `id` = ?,`name` = ?,`role` = ?,`description` = ?,`image` = ?,`isSaved` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Puppet entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getRole() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getRole());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getImage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getImage());
        }
        final int _tmp = entity.isSaved() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public void insertAll(final Puppet... puppet) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPuppet.insert(puppet);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Puppet puppet) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPuppet.handle(puppet);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Puppet> getAll() {
    final String _sql = "SELECT * FROM puppets";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfIsSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSaved");
      final List<Puppet> _result = new ArrayList<Puppet>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Puppet _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpRole;
        if (_cursor.isNull(_cursorIndexOfRole)) {
          _tmpRole = null;
        } else {
          _tmpRole = _cursor.getString(_cursorIndexOfRole);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final boolean _tmpIsSaved;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSaved);
        _tmpIsSaved = _tmp != 0;
        _item = new Puppet(_tmpId,_tmpName,_tmpRole,_tmpDescription,_tmpImage,_tmpIsSaved);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Puppet> getSaved() {
    final String _sql = "SELECT * FROM puppets WHERE isSaved = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfIsSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSaved");
      final List<Puppet> _result = new ArrayList<Puppet>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Puppet _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpRole;
        if (_cursor.isNull(_cursorIndexOfRole)) {
          _tmpRole = null;
        } else {
          _tmpRole = _cursor.getString(_cursorIndexOfRole);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final boolean _tmpIsSaved;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSaved);
        _tmpIsSaved = _tmp != 0;
        _item = new Puppet(_tmpId,_tmpName,_tmpRole,_tmpDescription,_tmpImage,_tmpIsSaved);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
