public class Livre extends Document implements Empruntable {

    private String auteur;

    public Livre(int id, String titre, String auteur) {
        super(id, titre);
        if (auteur == null || auteur.isBlank()) {
            throw new IllegalArgumentException("auteur invalide");
        }
        this.auteur = auteur;
    }

    @Override
    public void emprunter() {
        if (!estDisponible()) {
            throw new IllegalStateException("livre indisponible");
        }
        changerDisponibilite(false);
    }

    @Override
    public void retourner() {
        if (estDisponible()) {
            throw new IllegalStateException("livre deja disponible");
        }
        changerDisponibilite(true);
    }

    @Override
    public String description() {
        return "Livre n°" + getId() + " : " + getTitre() + " - " + auteur + " (disponible : " + estDisponible() + ")";
    }
}
