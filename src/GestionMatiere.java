import java.util.Scanner;

public class GestionMatiere {
    public static Matiere[] listeDesMatiere = new Matiere[100];
    public static int nbMa;
    static Scanner sc = new Scanner(System.in);

    public static Matiere rechercher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner la matricule de matiére recherché: ");
        int matricule = sc.nextInt();
        sc.nextLine();
        for (int i = 0 ; i<nbMa ; i++){
            if(listeDesMatiere[i].getMatricule() == matricule){
                return listeDesMatiere[i];
            }
        }
        return null;
    }

    public void ajouter() {
        if (nbMa >= listeDesMatiere.length) {
            System.out.println("La liste des matières est pleine.");
            return;
        }

        System.out.print("Nom du matiere : ");
        String nom = sc.nextLine();

        System.out.print("Coefficient du matiére : ");
        float coefficient = sc.nextFloat();
        sc.nextLine();

        System.out.print("matricule du matiére: ");
        int matricule = sc.nextInt();
        sc.nextLine();

        Matiere ma = new Matiere(nom, coefficient, matricule);

        listeDesMatiere[nbMa] = ma;
        nbMa++;
    }


    public void supprimer(){
        System.out.println("Donner la matricule de la matiére que vous voulez supprimer: ");
        int mat = sc.nextInt();
        sc.nextLine();
        boolean trouve = false;
        for (int i=0 ; i<nbMa ; i++){
            if (listeDesMatiere[i].getMatricule() == mat){
                for(int j=i ; j<nbMa -1 ; j++){
                    listeDesMatiere[j] = listeDesMatiere[j+1];
                }
                trouve = true;
                listeDesMatiere[nbMa-1] = null;
                nbMa--;
                System.out.println("matiére est supprimée avec succès ");
                break;
            }
        }
        if(!trouve){
            System.out.println("matricule introuvable");
        }
    }

    public void afficher(){
        if (nbMa == 0) {
            System.out.println("liste de matiére es vide: ");
        } else {
            System.out.println("La liste des Matières: ");
            for (int i = 0; i < nbMa; i++) {
                listeDesMatiere[i].afficherMatiere();
            }
        }}

    public void modifier() {
        System.out.println("Donner le matricule de la matière que vous voulez modifier : ");
        int ID = sc.nextInt();
        sc.nextLine(); // nettoyage !

        for (int i = 0; i < nbMa; i++) {
            if (listeDesMatiere[i].getMatricule() == ID) {
                System.out.println("Qu'est-ce que vous pouvez modifier pour cette matière ?");
                System.out.println("Taper 1 pour modifier son nom | 2 pour modifier son coefficient | 3 pour modifier son matricule");
                int choix = sc.nextInt();
                sc.nextLine();

                switch (choix) {
                    case 1: {
                        System.out.println("Donner le nouveau nom du matiere : ");
                        String nom = sc.nextLine();
                        listeDesMatiere[i].setNom(nom);
                    }
                    break;

                    case 2: {
                        System.out.println("Donner le nouveau coefficient du matiére : ");
                        float coef = sc.nextFloat();
                        listeDesMatiere[i].setCoefficent(coef);
                        sc.nextLine();
                    }
                    break;

                    case 3: {
                        System.out.println("Donner le nouvel matricule du matiére : ");
                        int mat = sc.nextInt();
                        listeDesMatiere[i].setMatricule(mat);
                        sc.nextLine();
                    }
                    break;
                    default:
                        System.out.println("donner unne commande valide ");
                }
            }
        }
    }

}