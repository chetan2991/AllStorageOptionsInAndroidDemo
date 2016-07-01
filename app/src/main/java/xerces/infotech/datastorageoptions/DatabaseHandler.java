package xerces.infotech.datastorageoptions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chetan on 1/7/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "userDetailsManager";

    // Contacts table name
    private static final String TABLE_USERDETAILS = "UserDetails";

    // Contacts Table Columns names
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_CONTACT = "contact";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_DETAIL_TABLE = "CREATE TABLE " + TABLE_USERDETAILS + "("
                + KEY_USERNAME + " TEXT," + KEY_PASSWORD + " TEXT,"
                + KEY_CONTACT + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_USER_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERDETAILS);
        onCreate(sqLiteDatabase);

    }

    public void addUserDetails(UserDataModelClass userDataModelClass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, userDataModelClass.getUserName()); // USERNAME
        values.put(KEY_PASSWORD, userDataModelClass.getPassword()); // PASSWORD
        values.put(KEY_CONTACT, userDataModelClass.getContact());  // CONTACT NUMBER
        db.insert(TABLE_USERDETAILS, null, values);
        db.close();
    }

    public UserDataModelClass getContact(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERDETAILS, new String[]{KEY_USERNAME,
                        KEY_PASSWORD, KEY_CONTACT}, KEY_USERNAME + "=?",
                new String[]{username}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        UserDataModelClass userdetails = new UserDataModelClass(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        return userdetails;
    }
}
