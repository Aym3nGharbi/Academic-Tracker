public class Matiere{
    String nom;
    float coefficent;
    int matricule;
    private double noteDs;
    private double noteExamen;

    public Matiere(String nom, float coefficent, int matricule){
        this.nom = nom;
        this.coefficent = coefficent;
        this.matricule = matricule;
        this.noteDs = -1;
        this.noteExamen = -1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getCoefficent() {
        return coefficent;
    }

    public void setCoefficent(float coefficent) {
        this.coefficent = coefficent;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public double getNoteDs() {
        return noteDs;
    }

    public void setNoteDs(double noteDs) {
        this.noteDs = noteDs;
    }

    public double getNoteExamen() {
        return noteExamen;
    }

    public void setNoteExamen(double noteExamen) {
        this.noteExamen = noteExamen;
    }

    public void afficherMatiere() {
        System.out.println("matiere  " + nom + " | Coefficient: " + coefficent + " | matricule: " + matricule);
    }

    public double calculerNoteFinaleMat() {
        if (noteDs == -1 || noteExamen == -1) {
            return -1;
        }
        return (noteDs * 0.4) + (noteExamen * 0.6);
    }
}