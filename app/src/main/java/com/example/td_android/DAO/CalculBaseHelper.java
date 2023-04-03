package com.example.td_android.DAO;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper{
    public CalculBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + CalculDao.TABLE_NAME + " (" +
                CalculDao.COLUMN_NOM + " VARCHAR(32), " +
                CalculDao.COLUMN_SCORE + " INTEGER NOT NULL)";

    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS " + CalculDao.TABLE_NAME;
    }
}
