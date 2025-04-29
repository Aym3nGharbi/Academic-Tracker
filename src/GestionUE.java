import java.util.Scanner;

public class GestionUE{
    public static UE[] ListeDesModules = new UE[100];
    public static int nbUE;
    static Scanner sc = new Scanner(System.in);

    public void ajouter() {
        if (nbUE >= ListeDesModules.length) {
            System.out.println("La liste des Modules est pleine.");
            return;
        }
        System.out.print("Nom du UE: ");
        String nom = sc.nextLine();

        System.out.print("Coefficient de UE : ");
        float coefficient = sc.nextFloat();
        sc.nextLine();

        System.out.print("Matricule de UE : ");
        int matricule = sc.nextInt();
        sc.nextLine();

        UE ue = new UE(nom, coefficient, matricule);

        System.out.print("Combien de matière à ajouter dans ce module ? : ");
        int nbma = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nbma; i++) {
            System.out.println("Matière numéro " + (i + 1) + " : ");
            ue.ajouterMatiere();
        }

        ListeDesModules[nbUE] = ue;
        nbUE++;
    }


    public static UE rechercher(){
        System.out.println("Donner la matricule de module recherché: ");
        int matricule = sc.nextInt();
        for (int i = 0 ; i<nbUE ; i++){
            if(ListeDesModules[i].getMatricule() == matricule){
                return ListeDesModules[i];
            }
        }
        return null;
    }

    public void modifier() {
        System.out.println("Donner le matricule du module que vous voulez modifier : ");
        int mat = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nbUE; i++) {
            if (ListeDesModules[i].getMatricule() == mat) {
                System.out.println("Qu'est-ce que vous pouvez modifier pour ce Module: ");
                System.out.println("Taper 1 pour modifier son nom | 2 pour modifier son Coefficient | 3 pour modifier son Matricule | taper 4 pour ajouter un autre Matière à ce module | taper 5 pour supprimer une Matière à ce module: ");
                int choix = sc.nextInt();
                sc.nextLine();

                switch (choix) {
                    case 1: {
                        System.out.println("Donner le nouveau nom du module : ");
                        String nom = sc.nextLine();
                        ListeDesModules[i].setNom(nom);
                    }
                    break;

                    case 2: {
                        System.out.println("Donner le nouveau Coefficient du ce module: ");
                        float coef = sc.nextFloat();
                        ListeDesModules[i].setCoefficient(coef);
                        sc.nextLine();
                    }
                    break;

                    case 3: {
                        System.out.println("Donner le nouveau Matricule de ce module : ");
                        int matr = sc.nextInt();
                        ListeDesModules[i].setMatricule(matr);
                        sc.nextLine();
                    }
                    break;

                    case 4: {
                        ListeDesModules[i].ajouterMatiere();
                    }
                    break;

                    case 5: {
                        ListeDesModules[i].SupprimerMatiere();
                    }
                    break;
                    default:
                        System.out.println("choisir une commande recommandé ");
                }
            }
        }
    }


    public void supprimer(){
        System.out.println("Donner la matricule d'UE que vous voulez supprimer: ");
        int mat = sc.nextInt();
        sc.nextLine();
        boolean trouve = false;
        for (int i=0 ; i<nbUE ; i++){
            if (ListeDesModules[i].getMatricule() == mat){
                for(int j=i ; j<nbUE -1 ; j++){
                    ListeDesModules[j] = ListeDesModules[j+1];
                }
                trouve = true;
                ListeDesModules[nbUE-1] = null;
                nbUE--;
                System.out.println("UE est supprimée avec succès !");
                break;
            }
        }
        if(!trouve){
            System.out.println("Aucune UE trouvée avec cette matricule.");
        }
    }

    public void afficher(){
        if(nbUE==0)
        {
            System.out.println("la liste des modules est ");
        }
        else
        {
            for (int i=0 ; i<nbUE ; i++){
                System.out.print("Module " + (i + 1) + ": ");
                ListeDesModules[i].afficherModule();
            }
        }   }
}