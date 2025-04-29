import java.util.Scanner;
public class Etudiant {
    String nom;
    String prenom;
    int ID;

    UE[] listeUE = new UE[100];
    int nbUEE = 0;


    Scanner sc = new Scanner(System.in);

    public Etudiant(String nom, String prenom, int ID) {
        this.nom = nom;
        this.prenom = prenom;
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNbUE() {
        return nbUEE;
    }

    public void ajouterUE() {
        UE uetrouve = GestionUE.rechercher();
        if(uetrouve != null){
            if(nbUEE < listeUE.length){
                listeUE[nbUEE] = uetrouve;
                nbUEE++;
                System.out.println("UE ajoutée avec succès ");
            }
            else{
                System.out.println("Limite d’UE atteinte pour cet étudiant ");
            }
        }
        else{
            System.out.println("matricule UE introuvable ");
        }
    }


    public void afficherEtudiant() {
        System.out.println("Nom: " + nom + " | Prénom: " + prenom + " | ID: " + ID );
        System.out.println("Liste des UE :");
        for (int i = 0; i < nbUEE; i++) {
            UE ue = listeUE[i];
            System.out.println("UE " + (i + 1) + ": " + ue.getNom() + " | Coefficient: " + ue.getCoefficient() + " | Matricule: " + ue.getMatricule());

            System.out.println("Liste des Matières:");
            for (int j = 0; j < ue.nbma; j++) {
                Matiere mat = ue.listeDesMatiers[j];
                System.out.print("- Matière " + (j + 1) + ": " + mat.getNom() + " | Coefficient: " + mat.getCoefficent() + " | Matricule: " + mat.getMatricule());

                if (mat.getNoteDs() != -1) {
                    System.out.print(" | Note DS: " + mat.getNoteDs());
                } else {
                    System.out.print(" | Note DS: Non notée");
                }

                if (mat.getNoteExamen() != -1) {
                    System.out.print(" | Note Examen: " + mat.getNoteExamen());
                } else {
                    System.out.print(" | Note Examen: Non notée");
                }
                System.out.println();
            }
        }
    }

    public void SupprimerUE() {
        System.out.println("Donner la matricule de la module à supprimer: ");
        int mat = sc.nextInt();
        sc.nextLine();
        boolean trouve = false;
        for(int i=0 ; i<nbUEE ; i++){
            if(listeUE[i].getMatricule() == mat){
                for (int j=i ; j<nbUEE-1 ; j++ ){
                    listeUE[j] = listeUE[j+1];
                }
                listeUE[nbUEE - 1] = null;
                nbUEE--;
                trouve =true;
                System.out.println("UE supprimée avec succès ");
                break;
            }
        }
        if (!trouve) {
            System.out.println("Aucune UE trouvée ");
        }
    }

    public void ajouterOuModifierNote() {
        System.out.print("Donner le nom du module (UE) : ");
        String nomModule = sc.nextLine();

        System.out.print("Donner le nom de la matière : ");
        String nomMatiere = sc.nextLine();

        boolean trouveModule = false;
        boolean trouveMatiere = false;

        for (int i = 0; i < nbUEE; i++) {
            if (listeUE[i].getNom().equalsIgnoreCase(nomModule)) {
                trouveModule = true;
                UE ue = listeUE[i];

                for (int j = 0; j < ue.nbma; j++) {
                    if (ue.listeDesMatiers[j].getNom().equalsIgnoreCase(nomMatiere)) {
                        trouveMatiere = true;
                        Matiere matiere = ue.listeDesMatiers[j];

                        System.out.println("Voulez-vous modifier : \n taper\n 1 pour la note ds \n 2  pour la note examen \n 3 les deux notes  ");

                        System.out.print("preciser votre commande  : ");
                        int choix = sc.nextInt();
                        sc.nextLine();

                        if (choix == 1) {
                            System.out.print("Entrer la nouvelle note DS : ");
                            double noteDs = sc.nextDouble();
                            sc.nextLine();
                            matiere.setNoteDs(noteDs);
                            System.out.println("Note DS modifiée avec succès ");
                        } else if (choix == 2) {
                            System.out.print("Entrer la nouvelle note Examen : ");
                            double noteExamen = sc.nextDouble();
                            sc.nextLine();
                            matiere.setNoteExamen(noteExamen);
                            System.out.println("Note Examen modifiée avec succès ");
                        } else if (choix == 3) {
                            System.out.print("Entrer la nouvelle note DS : ");
                            double noteDs = sc.nextDouble();
                            sc.nextLine();
                            matiere.setNoteDs(noteDs);
                            System.out.print("Entrer la nouvelle note Examen : ");
                            double noteExamen = sc.nextDouble();
                            sc.nextLine();
                            matiere.setNoteExamen(noteExamen);
                            System.out.println("Note DS modifiée avec succès !");
                            System.out.println("Note Examen modifiée avec succès !");
                        }
                        else {
                            System.out.println("donner une commande qui existe ");
                        }
                        return;
                    }
                }
            }
        }

        if (!trouveModule) {
            System.out.println("Ce module n'existe pas pour cet étudiant !");
        } else if (!trouveMatiere) {
            System.out.println("Cette matière n'existe pas dans le module spécifié !");
        }
    }

    public double calculerMoyenneGenerale() {
        double sommeNotes = 0;
        double sommeCoefficients = 0;
        int ueNotees = 0;

        for (int i = 0; i < nbUEE; i++) {
            double moyenneUE = listeUE[i].calculerMoyenneUE();
            if (moyenneUE != -1) {
                sommeNotes += moyenneUE * listeUE[i].getCoefficient();
                sommeCoefficients += listeUE[i].getCoefficient();
                ueNotees++;
            }
        }

        if (ueNotees == 0 || sommeCoefficients == 0) {
            return -1;
        }

        return sommeNotes / sommeCoefficients;
    }

    public void afficherBulletin() {
        System.out.println("\n BULLETIN DE NOTES ");
        System.out.println("Étudiant: " + prenom + " " + nom + " (ID: " + ID + ")");
        System.out.println("___________________________________________________________");

        double moyenneGenerale = calculerMoyenneGenerale();
        boolean auMoinsUneNote = false;

        for (int i = 0; i < nbUEE; i++) {
            UE ue = listeUE[i];
            double moyenneUE = ue.calculerMoyenneUE();

            System.out.println("\nUE: " + ue.getNom() + " (Coefficient: " + ue.getCoefficient() + ")");
            System.out.println("_______________________________________________________________");

            for (int j = 0; j < ue.nbma; j++) {
                Matiere mat = ue.listeDesMatiers[j];
                double noteFinaleMat = mat.calculerNoteFinaleMat();

                System.out.print("- " + mat.getNom() + " (Coef: " + mat.getCoefficent() + ")");

                if (mat.getNoteDs() != -1) {
                    System.out.print(" | DS: " + mat.getNoteDs());
                    auMoinsUneNote = true;
                } else {
                    System.out.print(" | DS: Non noté");
                }

                if (mat.getNoteExamen() != -1) {
                    System.out.print(" | Examen: " + mat.getNoteExamen());
                    auMoinsUneNote = true;
                } else {
                    System.out.print(" | Examen: Non noté");
                }

                if (noteFinaleMat != -1) {
                    System.out.printf(" | Note finale: %.2f", noteFinaleMat);
                } else {
                    System.out.print(" | Note finale: Non calculable");
                }

                System.out.println();
            }

            if (moyenneUE != -1) {
                System.out.printf("\nMoyenne UE: %.2f\n", moyenneUE);
            } else {
                System.out.println("\nMoyenne UE: Non calculable");
            }
        }

        System.out.println("\n___________________________________________________________________");
        if (moyenneGenerale != -1) {
            System.out.printf("MOYENNE GÉNÉRALE: %.2f / 20\n", moyenneGenerale);
        } else if (!auMoinsUneNote) {
            System.out.println("MOYENNE GÉNÉRALE: Aucune note saisie");
        } else {
            System.out.println("MOYENNE GÉNÉRALE: Non calculable");
        }
        System.out.println("__________________________________________________________\n");
    }
}