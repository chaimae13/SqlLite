package ma.fstt.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText etLibelle, etPU;
    private Button btnAjouter;
    private ListView listView;

    private ArticleDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLibelle = findViewById(R.id.etLibelle);
        etPU = findViewById(R.id.etPU);
        btnAjouter = findViewById(R.id.btnAjouter);
        listView = findViewById(R.id.listView);

        dataSource = new ArticleDataSource(this);
        dataSource.open();

        afficherArticles();

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterArticle();
                afficherArticles();
            }
        });
    }

    private void ajouterArticle() {
        String libelle = etLibelle.getText().toString();
        double prixUnitaire = Double.parseDouble(etPU.getText().toString());

        Article nouvelArticle = new Article();
        nouvelArticle.setLibelle(libelle);
        nouvelArticle.setPrixUnitaire(prixUnitaire);

        dataSource.ajouterArticle(nouvelArticle);

        etLibelle.setText("");
        etPU.setText("");
    }

    private void afficherArticles() {
        Cursor cursor = dataSource.getTousLesArticles();

        String[] fromColumns = { "_id", DatabaseHelper.COLUMN_LIBELLE, DatabaseHelper.COLUMN_PU };
        int[] toViews = { R.id.tvId,R.id.tvLibelle, R.id.tvPU };
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item,
                cursor,
                fromColumns,
                toViews,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        listView.setAdapter(cursorAdapter);
    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}