
public class Livre extends Document implements Empruntable {

    private String auteur;
    private Lecteur emprunteur;


    public Livre(int id, String titre, String auteur) {
        super(id, titre);

        this.auteur = auteur;
        this.emprunteur = null;
    }

    public String getAuteur() {

        return auteur;
    }

    @Override
    public Lecteur getEmprunteur() {

        return emprunteur;
    }

    @Override
    public void emprunter(Lecteur l) {
        if (!estDisponible()) {
            System.out.println("Ce livre est deja emprunte par " + emprunteur.getPrenom() + " " + emprunteur.getNom());
            return;
        }
        this.emprunteur = l;
        changerDisponibilite(false);
        System.out.println(l.getPrenom() + " " + l.getNom() + " a emprunte le livre : " + getTitre());
    }

    @Override
    public void retourner() {
        if (estDisponible()) {
            System.out.println("Ce livre est deja disponible, pas besoin de le retourner");
            return;
        }
        this.emprunteur = null;
        changerDisponibilite(true);
        System.out.println("Le livre " + getTitre() + " a ete retourne avec succes");
    }

    @Override
    public String description() {
        String etat;
        if (estDisponible()) {
            etat = "disponible";
        } else {
            etat = "emprunte par " + emprunteur.getPrenom() + " " + emprunteur.getNom();
        }
        return "Livre numero " + getId() + " : " + getTitre() + " de " + auteur + " (" + etat + ")";
    }

    @Override
    public String toString() {
        return description();
    }
}
