package com.example.td_android.DAO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.td_android.entities.Score;


public class CalculDao extends BaseDao<Score> {

    public static String TABLE_NAME = "SCORES";
    public static String COLUMN_NOM = "NOM";
    public static String COLUMN_SCORE = "SCORE";

    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(COLUMN_NOM,entity.getNom());
        values.put(COLUMN_SCORE,entity.getScore());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Integer indexColumnCalcul = cursor.getColumnIndex(COLUMN_NOM);
        Integer indexColumnResultat = cursor.getColumnIndex(COLUMN_SCORE);
        if(cursor.getCount()>0){
            Score monScore = new Score(cursor.getString(indexColumnCalcul), cursor.getInt(indexColumnResultat));
            return monScore;
        }
        return null;
    }
}
