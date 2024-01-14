package ma.fstt.sqliteapplication;
// DatabaseHelper.java
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "articles.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ARTICLES = "articles";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LIBELLE = "libelle";
    public static final String COLUMN_PU = "prix_unitaire";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_ARTICLES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_LIBELLE
            + " text not null, " + COLUMN_PU
            + " real not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
        onCreate(db);
    }
}
