import java.util.*;
public class GestionEtudiants {
    public static Etudiant[] listeEtudiants = new Etudiant[1000];
    public static int nbEtudiants =0;

    static Scanner sc = new Scanner(System.in);

    public void ajouter() {
        if (nbEtudiants >= listeEtudiants.length) {
            System.out.println("La liste des étudiants est pleine.");
            return;
        }

        System.out.print("Nom de l'étudiant : ");
        String nom = sc.nextLine();

        System.out.print("Prénom de l'étudiant : ");
        String prenom = sc.nextLine();

        System.out.print("ID de l'étudiant : ");
        int id = sc.nextInt();
        sc.nextLine();

        Etudiant e = new Etudiant(nom, prenom, id);

        System.out.print("Combien d’UE à ajouter ? : ");
        int nbUE = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nbUE; i++) {
            System.out.println("UE numéro " + (i + 1) + " : ");
            e.ajouterUE();
        }

        listeEtudiants[nbEtudiants] = e;
        nbEtudiants++;

        System.out.println("Étudiant ajouté avec succès ");
    }



    public static Etudiant rechercher(){
        System.out.println("Donner l'Identifiant de l'etudiant recherché: ");
        int ID = sc.nextInt();
        sc.nextLine();
        for(int i =0 ; i<nbEtudiants ; i++){
            if(listeEtudiants[i].getID() == ID){
                return listeEtudiants[i];
            }
        }
        return null;
    }

    public void modifier() {
        System.out.println("Donner l'Identifiant de l'étudiant que vous voulez modifier : ");
        int ID = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nbEtudiants; i++) {
            if (listeEtudiants[i].getID() == ID) {
                System.out.println("Qu'est ce que vous pouvez modifier pour cet étudiant ?");
                System.out.println("Taper 1 pour modifier son nom | 2 pour modifier son prénom | 3 pour modifier son ID | 4 pour ajouter un UE | 5 pour supprimer un UE | 6 pour ajouter ou modifier une note");
                int choix = sc.nextInt();
                sc.nextLine();

                switch (choix) {
                    case 1: {
                        System.out.println("Donner le nouveau nom de ce etudiant : ");
                        listeEtudiants[i].setNom(sc.nextLine());
                    } break;

                    case 2: {
                        System.out.println("Donner le nouveau prénom de ce etudiant : ");
                        listeEtudiants[i].setPrenom(sc.nextLine());
                    } break;

                    case 3: {
                        System.out.println("Donner le nouvel Identifiant de ce etudiant : ");
                        listeEtudiants[i].setID(sc.nextInt());
                        sc.nextLine();
                    } break;

                    case 4: {
                        listeEtudiants[i].ajouterUE();
                    } break;

                    case 5: {
                        listeEtudiants[i].SupprimerUE();
                    } break;

                    case 6: {
                        listeEtudiants[i].ajouterOuModifierNote();
                    } break;
                    default:
                        System.err.println("donner une commande valide ");
                }
            }
        }
    }


    public void supprimer(){
        System.out.println("Donner l'Identifiant de l'étudiant que vous voulez supprimer: ");
        int ID = sc.nextInt();
        sc.nextLine();
        boolean trouve = false;
        for (int i=0 ; i<nbEtudiants ; i++){
            if (listeEtudiants[i].getID() == ID){
                for(int j=i ; j<nbEtudiants -1 ; j++){
                    listeEtudiants[j] = listeEtudiants[j+1];
                }
                trouve = true;
                listeEtudiants[nbEtudiants-1] = null;
                nbEtudiants--;
                System.out.println("L'etudiant supprimée avec succès ");
                break;
            }
        }
        if(!trouve){
            System.out.println("ID introuvable");
        }
    }

    public void afficher() {
        System.out.println("\nvoici  Liste des Étudiants ");

        if (nbEtudiants == 0) {
            System.out.println("Aucun étudiant n'est enregistré.");
            return;
        }

        for (int i = 0; i < nbEtudiants; i++) {
            System.out.println("\n Étudiant N° " + (i + 1) + " :");
            listeEtudiants[i].afficherEtudiant();
            System.out.println("____________________________________________________");
        }
    }

    public void afficherEtudiantMajeur() {
        if (nbEtudiants == 0) {
            System.out.println("Aucun étudiant n'est enregistré");
            return;
        }

        Etudiant meilleurEtudiant = null;
        double meilleureMoyenne = -1;

        for (int i = 0; i < nbEtudiants; i++) {
            Etudiant etudiant = listeEtudiants[i];
            double moyenne = etudiant.calculerMoyenneGenerale();

            if (moyenne > meilleureMoyenne) {
                meilleureMoyenne = moyenne;
                meilleurEtudiant = etudiant;
            }
        }

        if (meilleurEtudiant != null && meilleureMoyenne != -1) {
            System.out.println("\n le MAJEUR DE PROMOTION \n felicitations a l etudiant ");
            System.out.println( meilleurEtudiant.getNom() +"  "+ meilleurEtudiant.getPrenom());
            System.out.println("ID: " + meilleurEtudiant.getID());
            System.out.printf("Moyenne générale: %.2f / 20\n", meilleureMoyenne);

        } else {
            System.out.println("\nAucun étudiant n'a de notes complètes permettant de calculer une moyenne.");
        }
    }

    public void afficherRésultatsÉtudiants(){
        Etudiant[] admis = new Etudiant[1000];
        Etudiant[] refuse = new Etudiant[1000];
        int nbad =0;
        int nbre =0;
        for (int i =0 ; i<nbEtudiants ; i++){
            if(listeEtudiants[i].calculerMoyenneGenerale()>=10){
                admis[nbad] = listeEtudiants[i];
                nbad++;
            } else if (listeEtudiants[i].calculerMoyenneGenerale()<10 && listeEtudiants[i].calculerMoyenneGenerale()>=0) {
                refuse[nbre] = listeEtudiants[i];
                nbre++;
            }
        }
        System.out.println("Liste des Etudiants Admis: ");
        for (int i=0 ; i<nbad ; i++){
            String nom = admis[i].getNom();
            String prenom = admis[i].getPrenom();
            System.out.println(nom + " " + prenom);
        }
        System.out.println("Liste des Etudiants refusés: ");
        for (int i=0 ; i<nbre ; i++){
            String nom = refuse[i].getNom();
            String prenom = refuse[i].getPrenom();
            System.out.println(nom + " " + prenom);
        }
    }
}
