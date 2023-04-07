package com.example.mentalgame.DAO;

import android.content.Context;

public class PersoBaseHelper extends DataBaseHelper {
    public PersoBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + PersoDao.TABLE_NAME + " (" +

                PersoDao.COLUMN_RESULTAT + " INTEGER NOT NULL)";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+PersoDao.TABLE_NAME;
    }
}