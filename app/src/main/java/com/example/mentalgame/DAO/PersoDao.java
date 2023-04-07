package com.example.mentalgame.DAO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.mentalgame.entities.Perso;


public class PersoDao extends BaseDao<Perso> {
    public static String TABLE_NAME = "PERSO";
    public static String COLUMN_RESULTAT = "ID";

    public PersoDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void putValues(ContentValues values, Perso entity) {
        values.put(COLUMN_RESULTAT, entity.getId());
    }

    @Override
    protected Perso getEntity(Cursor cursor) {

        Integer indexColumnResultat = cursor.getColumnIndex(COLUMN_RESULTAT);
        if( cursor.getCount()>0){
            Perso monCalcul = new Perso( cursor.getInt(indexColumnResultat));
            return monCalcul;
        }
        return null;
    }
}
