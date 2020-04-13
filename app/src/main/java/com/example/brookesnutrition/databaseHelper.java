package com.example.brookesnutrition;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Food.db";
    private static final String TABLE_NAME = "food_table";
    private static final String COL_1 = "FOOD";
    private static final String COL_2 = "CALORIES";
    private static final String COL_3 = "TOTAL_CALORIES";



    public databaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (FOOD STRING PRIMARY KEY, CALORIES STRING, TOTAL_CALORIES DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertFood(String food_name, String calories) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, food_name);
        contentValues.put(COL_2, calories);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getFood(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }

        public String getTotalCalories(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select calories from " + TABLE_NAME, null);
        boolean accepted = false;
        Double temp_total = 0.0;
        String final_total = null;
        if (res.getCount() != 0){
            accepted = true;
            String temp_strCal;
            while (res.moveToNext()){
                temp_strCal = res.getString(0);
                temp_total += Double.parseDouble(temp_strCal);
            }
        }
        if (accepted){
            final_total = Double.toString(temp_total);
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_3, final_total);
            String where = "rowid=(SELECT MIN(rowid) FROM " + TABLE_NAME + ")";
            db.update(TABLE_NAME, contentValues, where, null);
        }

        return final_total;

    }
    public int delete(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "FOOD = ?", new String[] {name});
    }
    public double getCalories(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();
        String strcal = cursor.getString( cursor.getColumnIndex("TOTAL_CALORIES") );
        return Double.parseDouble(strcal);

    }

}
