public class Livre extends Document {
    private int nbPages;

    public Livre(int numero, String titre, String auteurPrincipal, int nbPages) {
        super(numero, titre, auteurPrincipal);
        this.nbPages = nbPages;
    }

    @Override
    public int dureeMaxPret() {
        return 21;
    }

    @Override public String toString() {
        return super.toString() + "\nPages : " + nbPages + "Durée max prêt : " + dureeMaxPret() + " jours";
    }
}