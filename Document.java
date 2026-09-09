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

    public void afficher() {
        System.out.println("Document n°" + id +" titre "+ titre +" auteur " + auteur);
        if (disponible) {
            System.out.println("Disponible");
        } else {
            System.out.println("Indisponible");
        }
    }
}