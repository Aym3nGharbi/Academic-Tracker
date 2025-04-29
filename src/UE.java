import java.util.Scanner;

public class UE {
    String nom;
    float coefficient;
    int matricule;
    Matiere [] listeDesMatiers ;
    int nbma = 0;
    Scanner sc = new Scanner(System.in);

    public UE(String nom, float coefficient, int matricule){
        this.nom = nom;
        this.coefficient = coefficient;
        this.matricule = matricule;
        this.listeDesMatiers = new Matiere[10];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void afficherModule() {
        System.out.println("Module : " + nom + " | Coefficient: " + coefficient + " | matricule: " + matricule);
        System.out.println("Liste des Matiéres:");
        for (int i = 0; i < nbma; i++) {
            System.out.print("Matiére " + (i + 1) + ": ");
            listeDesMatiers[i].afficherMatiere();
        }
    }

    public void ajouterMatiere(){
        Matiere matrouve = GestionMatiere.rechercher();
        if(matrouve != null){
            if( nbma < listeDesMatiers.length){
                listeDesMatiers[nbma] = matrouve;
                nbma++;
                System.out.println("Matiére ajoutée avec succès ");
            }
            else{
                System.out.println("on peut plus ajouter a ce module  ");
            }
        }
        else{
            System.out.println("matricule introuvable ");
        }
    }

    public void SupprimerMatiere() {
        System.out.println("Donner la matricule de la matiére à supprimer: ");
        int mat = sc.nextInt();
        sc.nextLine();
        boolean trouve = false;
        for(int i=0 ; i<nbma ; i++){
            if(listeDesMatiers[i].getMatricule() == mat){
                for (int j=i ; j<nbma-1 ; j++ ){
                    listeDesMatiers[j] = listeDesMatiers[j+1];
                }
                listeDesMatiers[nbma - 1] = null;
                nbma--;
                trouve =true;
                System.out.println("Matiére supprimée avec succès ");
                break;
            }
        }
        if (!trouve) {
            System.out.println("matricule introuvable ");
        }
    }

    public double calculerMoyenneUE() {
        double sommeNotes = 0;
        double sommeCoefficients = 0;
        int matiereNotees = 0;

        for (int i = 0; i < nbma; i++) {
            double noteFinaleMat = listeDesMatiers[i].calculerNoteFinaleMat();
            if (noteFinaleMat != -1) {
                sommeNotes += noteFinaleMat * listeDesMatiers[i].getCoefficent();
                sommeCoefficients += listeDesMatiers[i].getCoefficent();
                matiereNotees++;
            }
        }

        if (matiereNotees == 0 || sommeCoefficients == 0) {
            return -1;
        }

        return sommeNotes / sommeCoefficients;
    }
}
