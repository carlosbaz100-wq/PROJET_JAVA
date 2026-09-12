public class Lecteur {
    //attributs
    String nom;
    String prenom;
    int numero;
    String adresse;

    public Lecteur(String nom, String prenom, int numero, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.adresse = adresse;

    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }
    public void afficher() {
        System.out.println("Adherent n°" + numero + " : " + nom + " " + prenom);
    }

}
