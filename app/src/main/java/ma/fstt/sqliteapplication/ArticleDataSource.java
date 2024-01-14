package ma.fstt.sqliteapplication;
// ArticleDataSource.java
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ArticleDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public ArticleDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long ajouterArticle(Article article) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_LIBELLE, article.getLibelle());
        values.put(DatabaseHelper.COLUMN_PU, article.getPrixUnitaire());

        return database.insert(DatabaseHelper.TABLE_ARTICLES, null, values);
    }

    public Cursor getTousLesArticles() {
        String[] allColumns = { DatabaseHelper.COLUMN_ID + " as _id", DatabaseHelper.COLUMN_LIBELLE, DatabaseHelper.COLUMN_PU };

        return database.query(DatabaseHelper.TABLE_ARTICLES, allColumns, null, null, null, null, null);
    }
}