
public abstract class Document {

    private int id;
    private String titre;
    private boolean disponible;


    public Document(int id, String titre) {

        this.id = id;
        this.titre = titre;
        this.disponible = true;
    }

    public int getId() {

        return id;
    }

    public String getTitre() {

        return titre;
    }

    public boolean estDisponible() {

        return disponible;
    }

    protected void changerDisponibilite(boolean valeur) {

        this.disponible = valeur;
    }

    public Lecteur getEmprunteur() {

        return null;
    }


    public abstract String description();

    @Override
    public String toString() {
        return description();
    }
}
