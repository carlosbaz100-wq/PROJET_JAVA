public class Lecteur {
    //attributs
    private String nom;
    private String prenom;
    private int numero;
    private String adresse;

    public Lecteur(String nom, String prenom, int numero, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.adresse = adresse;

    }
    public void afficher() {
        System.out.println("Adherent n°" + numero + " : " + nom + " " + prenom);
    }

}
