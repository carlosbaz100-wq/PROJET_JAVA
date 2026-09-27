public class Bibliotheque {

    private String nom;
    private Document[] documents;
    private int nbDocuments;
    private static final int CAPACITE_MAX = 10000;


    public Bibliotheque(String nom) {
        this.nom = nom;
        this.documents = new Document[CAPACITE_MAX];
        this.nbDocuments = 0;
    }

    public void ajouterDocument(Document d) {
        if (nbDocuments < documents.length) {
            documents[nbDocuments] = d;
            nbDocuments = nbDocuments + 1;
        } else {
            System.out.println("Capacite maximale atteinte, impossible d'ajouter : " + d.getTitre());
        }
    }


    public void afficherCatalogue() {
        System.out.println("Catalogue de la bibliotheque " + nom);
        System.out.println("Nombre de documents : " + nbDocuments);
        for (int i = 0; i < nbDocuments; i++) {
            System.out.println(documents[i].description());
        }
    }


    public void afficherDisponibles() {
        System.out.println("Documents disponibles dans la bibliotheque " + nom);
        int count = 0;
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i].estDisponible()) {
                System.out.println(documents[i].description());
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("Aucun document disponible");
        }
    }


    public void afficherEmpruntesParLecteur(Lecteur l) {
        System.out.println("Documents empruntes par " + l.getPrenom() + " " + l.getNom());
        int count = 0;
        for (int i = 0; i < nbDocuments; i++) {
            Lecteur emp = documents[i].getEmprunteur();
            if (emp != null && emp.getNumero() == l.getNumero()) {
                System.out.println(documents[i].description());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Aucun document emprunte par ce lecteur");
        }
    }


    public Document chercherParTitre(String titre) {

        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i].getTitre().equalsIgnoreCase(titre)) {
                return documents[i];
            }
        }
        System.out.println("Aucun document trouve avec le titre : " + titre);
        return null;
    }


    public int getNbDocuments() {
        return nbDocuments;
    }

    public String getNom() {
        return nom;
    }
}