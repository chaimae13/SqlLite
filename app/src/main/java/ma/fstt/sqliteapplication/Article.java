package ma.fstt.sqliteapplication;

// Article.java
public class Article {
    private int id;
    private String libelle;
    private double prixUnitaire;

    public Article(int id, String libelle, double prixUnitaire) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
    }

    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

// constructeurs, getters et setters
}
