public class Main {

    public static void main(String[] args) {

        Bibliotheque biblio = new Bibliotheque("Bibliotheque 2iE");

        biblio.ajouterDocument(new Livre(1, "Une si longue lettre", "Mariama Ba"));
        biblio.ajouterDocument(new Livre(2, "Introduction a Java", "Kathy Sierra"));
        biblio.ajouterDocument(new Livre(3, "Clean Code", "Robert Martin"));
        biblio.ajouterDocument(new Periodique(4, "Pour la Science", 548));
        biblio.ajouterDocument(new Periodique(5, "Linux Magazine", 102));

        Lecteur l1 = new Lecteur("KOUSSE", "Souleymane", 1001, "Ouagadougou");
        Lecteur l2 = new Lecteur("BAZONGO", "Carlos", 1002, "Ouagadougou");
        Lecteur l3 = new Lecteur("DAMBA", "Aimee", 1003, "Kaya");

        // Catalogue initial
        biblio.afficherCatalogue();

        //  emprunt normal
        System.out.println();
        System.out.println("SCENARIO 1 : emprunt normal");
        Document d1 = biblio.chercherParTitre("Une si longue lettre");
        if (d1 != null && d1 instanceof Empruntable) {
            ((Empruntable) d1).emprunter(l1);
        }
        System.out.println(d1);

        // SCENARIO 2 : refus du deuxieme emprunt
        System.out.println();
        System.out.println("SCENARIO 2 : refus du deuxieme emprunt");
        if (d1 != null && d1 instanceof Empruntable) {
            ((Empruntable) d1).emprunter(l2);
        }

        //SCENARIO 3 : retour du livre
        System.out.println();
        System.out.println("SCENARIO 3 : retour du livre");
        if (d1 != null && d1 instanceof Empruntable) {
            ((Empruntable) d1).retourner();
        }
        System.out.println(d1);

        // SCENARIO 4 : refus du retour car livre deja disponible
        System.out.println();
        System.out.println("SCENARIO 4 : refus du retour car livre deja disponible");
        if (d1 != null && d1 instanceof Empruntable) {
            ((Empruntable) d1).retourner();
        }

        //  consultation d'un periodique
        System.out.println();
        System.out.println("SCENARIO 5 : consultation d un periodique");
        Document p1 = biblio.chercherParTitre("Pour la Science");
        if (p1 != null && p1 instanceof Consultable) {
            ((Consultable) p1).consulterSurPlace();
            System.out.println(p1);

            System.out.println();
            System.out.println("SCENARIO 5b : refus de deuxieme consultation");
            ((Consultable) p1).consulterSurPlace();

            System.out.println();
            System.out.println("SCENARIO 5c : fin de consultation");
            ((Consultable) p1).terminerConsultation();
            System.out.println(p1);

            System.out.println();
            System.out.println("SCENARIO 5d : refus de fin de consultation deja terminee");
            ((Consultable) p1).terminerConsultation();
        }

        //  recherche insensible à la casse + emprunt
        System.out.println();
        System.out.println("SCENARIO 6 : recherche ");
        Document d3 = biblio.chercherParTitre("clean code");
        if (d3 != null && d3 instanceof Empruntable) {
            ((Empruntable) d3).emprunter(l3);
        }

        // afficher les emprunts par lecteur
        System.out.println();
        System.out.println("SCENARIO 7 : afficher les emprunts par lecteur");
        biblio.afficherEmpruntesParLecteur(l3);
        biblio.afficherEmpruntesParLecteur(l1);
        biblio.afficherEmpruntesParLecteur(l2);

        // ===== SCENARIO 8
        System.out.println();
        System.out.println("SCENARIO 8 :voir l'emprunteur d'un periodique");
        Document pTest = biblio.chercherParTitre("Linux Magazine");
        if (pTest != null) {
            Lecteur emp = pTest.getEmprunteur();
            if (emp == null) {
                System.out.println("Le periodique \"" + pTest.getTitre() + "\" n'a pas d'emprunteur (attendu)");
            } else {
                System.out.println("ERREUR : un periodique ne devrait pas avoir d emprunteur");
            }
        }

        //Affichage final
        System.out.println();
        biblio.afficherDisponibles();
    }
}
