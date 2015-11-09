package com.wesleyreisz.contentprovider_sqllite_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wesleyreisz on 11/8/15.
 */
public class CommentsDataSource {
    private static final String TAG = "COMMENTS-DATASOURCE";
    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
        MySQLiteHelper.COLUMN_ID,
        MySQLiteHelper.COLUMN_COMMENT
    };

    public CommentsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    private void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    private void close() {
        dbHelper.close();
    }

    public Comment createComment(String comment) {
        open();
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
        long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null, values);
        Cursor cursor = database.query(
                MySQLiteHelper.TABLE_COMMENTS,
                allColumns,
                MySQLiteHelper.COLUMN_ID + " = " + insertId,
                null, null, null, null);

        Log.d(TAG,"Inserted Comment");
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        close();
        return newComment;
    }

    public void deleteComment(Comment comment) {
        open();
        long id = comment.getId();
        Log.d(TAG,"Comment deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
        close();
    }

    public List<Comment> getAllComments() {
        open();
        Log.d(TAG,"Getting all Comments");
        List<Comment> comments = new ArrayList<Comment>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        close();
        return comments;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }
}
