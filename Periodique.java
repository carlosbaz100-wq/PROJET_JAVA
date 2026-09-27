public class Periodique extends Document implements Consultable {

    private int numeroParution;

    public Periodique(int id, String titre, int numeroParution) {
        super(id, titre);
        this.numeroParution = numeroParution;
    }

    public int getNumeroParution() {
        return numeroParution;
    }


    @Override
    public Lecteur getEmprunteur() {
        return null;
    }

    @Override
    public void consulterSurPlace() {
        if (!estDisponible()) {
            System.out.println("Ce periodique est deja en cours de consultation");
            return;
        }
        changerDisponibilite(false);
        System.out.println("Consultation en cours pour : " + getTitre());
    }

    @Override
    public void terminerConsultation() {
        if (estDisponible()) {
            System.out.println("Ce periodique n est pas en cours de consultation");
            return;
        }
        changerDisponibilite(true);
        System.out.println("Consultation terminee pour : " + getTitre());
    }

    @Override
    public String description() {
        String etat;
        if (estDisponible()) {
            etat = "disponible";
        } else {
            etat = "en consultation";
        }
        return "Periodique numero " + getId() + " : " + getTitre() + " parution " + numeroParution + " (" + etat + ")";
    }

    @Override
    public String toString() {
        return description();
    }
}
