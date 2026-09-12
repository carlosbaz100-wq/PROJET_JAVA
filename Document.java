public class Document {

    private int id;
    private String titre;
    private String auteur;
    private boolean disponible;

    public Document(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = true;
    }


    public void emprunter() {
        disponible = false;
    }

    public void retourner() {
        disponible = true;
    }

   @Override
    public String toString() {
        return "Document n° " + numero + "Titre : " + titre + " Auteur : " + auteurPrincipal+ ".";
    }
}
