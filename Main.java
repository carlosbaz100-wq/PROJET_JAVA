public class Main {

    public static void main(String[] args) {

        // Création des documents
        Document d1 = new Document(101, "Les Miserables", "Victor Hugo");
        Document d2 = new Document(102, "L'Etranger", "Albert Camus");

        // Création des lecteurs
        Lecteur a1 = new Lecteur("Moussa", "Kone", 1234, "Kaya");
        Lecteur a2 = new Lecteur("Amed", "Traore", 12345, "Ouaga");

        //  Affichage de tous les documents
        System.out.println("Affichage des Documents ");
        d1.afficher();
        d2.afficher();

        //  Affichage de tous les lecteurs
        System.out.println(" Affichage des Lecteurs ");
        a1.afficher();
        a2.afficher();

        // Emprunt de d1 par a1
        System.out.println(" Emprunt d'un document");
        if (d1.estDisponible()) {
            d1.emprunter();
        }
        else {
            System.out.println("document indisponible.");
        }
        d1.afficher();


        //  Retour du document
        System.out.println("Retour d'un Document");
        d1.retourner();
        d1.afficher();
    }
}