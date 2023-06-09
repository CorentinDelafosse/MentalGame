package com.example.mentalgame.DAO;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper {
    public CalculBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + CalculDao.TABLE_NAME + " (" +

                CalculDao.COLUMN_RESULTAT + " INTEGER NOT NULL)";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+CalculDao.TABLE_NAME;
    }
}
