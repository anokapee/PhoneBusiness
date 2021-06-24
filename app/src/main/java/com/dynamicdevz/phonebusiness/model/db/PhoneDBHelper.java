package com.dynamicdevz.phonebusiness.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dynamicdevz.phonebusiness.model.data.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "phone.db";
    public static int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Phone";
    private static final String COLUMN_PHONE_ID = "phone_id";
    public static final String COLUMN_MANUFACTURER = "manufacturer";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_PRICE= "price";

    public PhoneDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCommand = "CREATE TABLE " + TABLE_NAME + " ( "+ COLUMN_PHONE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MANUFACTURER + " TEXT, " +
                COLUMN_MODEL + " TEXT, " +
                COLUMN_PRICE + " INTEGER " +
                ")";
        db.execSQL(createCommand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(upgrade);
        onCreate(db);
    }

    public void insertPhone(Phone phone){
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_MANUFACTURER, phone.getManufacturer());
        contentValues.put(COLUMN_MODEL, phone.getModel());
        contentValues.put(COLUMN_PRICE, phone.getPrice());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void deletePhone(int phoneID){
        String deleteQuery = TABLE_NAME + " WHERE " + COLUMN_PHONE_ID + " = " + phoneID;
        getWritableDatabase().delete(deleteQuery, null, null);
    }

    public List<Phone> getAllPhones(){
        List<Phone> phones = new ArrayList<>();
        String getQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = getReadableDatabase().rawQuery(getQuery, null);
        cursor.move(-1);
        while(cursor.moveToNext()){
            Phone phone = new Phone(
                    cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_MANUFACTURER)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_MODEL)),
                    cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE))
            );
            phones.add(phone);
        }
        return phones;
    }
}
