public class Main {

    public static void main(String[] args) {

        // Création des documents demandés
        Document L1 = new Livre(101, "Introduction à Java", "Kathy Sierra", 320);
        Document L2 = new Periodique(202, "Science et technique", "Philippe Ribeau-Gésippe", 12);

        Lecteur a1 = new Lecteur("KOUSSE", "SOULEY", 123465, "CIV");
        Lecteur a2 = new Lecteur("BAZONGO", "CARLOS", 1234567, "Ouagadougou");

        // Affichage des documents
        System.out.println("Les documents creés");
        System.out.println(L1);
        System.out.println(L2);


        //  Vérification des durées
        System.out.println("\nVérification des durées");
        System.out.println("Durée max livre      : " + L1.dureeMaxPret() + " jours");
        System.out.println("Durée max périodique : " + L2.dureeMaxPret() + " jours");

        // Vérification disponibilité
        System.out.println("\n Disponibilité initiale ");
        System.out.println(L1.getTitre()+"     : " + L1.getDisponible());
        System.out.println(L2.getTitre()+ ": " + L2.getDisponible());

        // Emprunt du livre
        System.out.println("\n Emprunt du livre ");
        if (L1.getDisponible()) {
            L1.emprunter(a1);
            System.out.println(L1.getEmprunteur().getNom()+" emprunte " +L1.getTitre()+" : disponibilite actualisée du document : " + L1.getDisponible());
        }

        //  Retour du livre
        System.out.println("\n Retour du livre ");
        L1.retourner();
        System.out.println(L1.getTitre()+" :  disponibilite actualisée du document : " + L1.getDisponible());
    }
}
