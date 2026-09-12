public abstract class Document {

    private int     numero;
    private String  titre;
    private String  auteurPrincipal;
    private boolean disponible;
    private Lecteur emprunteur;

    public Document(int numero, String titre, String auteurPrincipal) {
        this.numero          = numero;
        this.titre           = titre;
        this.auteurPrincipal = auteurPrincipal;
        this.disponible      = true;
    }

    public int     getNumero()          { return numero; }
    public String  getTitre()           { return titre; }
    public String  getAuteurPrincipal() { return auteurPrincipal; }


    public boolean getDisponible() {
        return disponible;
    }


    public abstract int dureeMaxPret();

    public void emprunter(Lecteur l) {
        this.disponible = false;
        this.emprunteur = l;
    }
    public Lecteur getEmprunteur() {
        return emprunteur;
    }

    public void retourner() {
        this.disponible = true;
        this.emprunteur = null;
    }

    @Override
    public String toString() {
        return "Document n° " + numero + "Titre : " + titre + " Auteur : " + auteurPrincipal+ ".";
    }
}
