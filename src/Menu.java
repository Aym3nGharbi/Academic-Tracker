import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // matiere
        GestionMatiere gestionMatiere = new GestionMatiere();

        Matiere mat = new Matiere("math", 3f, 101);
        Matiere phy = new Matiere("phy",2f, 102);
        Matiere scie = new Matiere("science",2.5f, 103);
        Matiere java  = new Matiere("java", 2f, 104);

        gestionMatiere.listeDesMatiere[0]=mat;
        gestionMatiere.listeDesMatiere[1]=phy;
        gestionMatiere.listeDesMatiere[2]=scie;
        gestionMatiere.listeDesMatiere[3]=java;
        gestionMatiere.nbMa+=4;

        // UE
        GestionUE gestionUE = new GestionUE();
        UE mp = new UE("sceince appliqué", 4f, 101);

        mp.listeDesMatiers[0] = mat;
        mp.listeDesMatiers[1] = phy;
        mp.nbma+=2;

        UE svt = new UE("science naturelle ",3f,102);
        svt.listeDesMatiers[0]=scie;
        svt.nbma++;

        UE res = new UE("reseau ", 3f, 12);
        res.listeDesMatiers[0]=java;
        res.nbma++;

        gestionUE.ListeDesModules[0]=mp;
        gestionUE.ListeDesModules[1]=svt;
        gestionUE.ListeDesModules[2]=res;
        gestionUE.nbUE+=3;

        // etudiant
        GestionEtudiants gestionEtudiants = new GestionEtudiants();
        Etudiant med = new Etudiant("kammoun", "sami", 101);
        Etudiant wal = new Etudiant("walha", "walid", 102);
        Etudiant sal = new Etudiant("neifar", "samiha ", 103);
        Etudiant lam = new Etudiant("ahmed", "mohsen", 104);
        gestionEtudiants.listeEtudiants[0]=med;
        gestionEtudiants.listeEtudiants[1]=wal;
        gestionEtudiants.listeEtudiants[2]=sal;
        gestionEtudiants.listeEtudiants[3]=lam;
        gestionEtudiants.nbEtudiants+= 4;

        med.listeUE[0] = mp;
        med.listeUE[1] = svt;
        med.nbUEE += 2;


        Matiere mathWal = new Matiere("math", 3f, 201);
        mathWal.setNoteDs(13.0);
        mathWal.setNoteExamen(14.5);

        Matiere phyWal = new Matiere("phy", 2f, 202);
        phyWal.setNoteDs(12.5);
        phyWal.setNoteExamen(13.0);

        Matiere javaWal = new Matiere("java", 2f, 204);
        javaWal.setNoteDs(16.0);
        javaWal.setNoteExamen(15.5);

        UE mpWal = new UE("sceince appliqué", 4f, 201);
        mpWal.listeDesMatiers[0] = mathWal;
        mpWal.listeDesMatiers[1] = phyWal;
        mpWal.nbma += 2;

        UE resWal = new UE("reseau ", 3f, 202);
        resWal.listeDesMatiers[0] = javaWal;
        resWal.nbma++;

        wal.listeUE[0] = mpWal;
        wal.listeUE[1] = resWal;
        wal.nbUEE += 2;

        Matiere scieSal = new Matiere("science", 2.5f, 301);
        scieSal.setNoteDs(14.5);
        scieSal.setNoteExamen(15.0);

        Matiere javaSal = new Matiere("java", 2f, 302);
        javaSal.setNoteDs(16.5);
        javaSal.setNoteExamen(15.0);

        UE svtSal = new UE("science naturelle ", 3f, 301);
        svtSal.listeDesMatiers[0] = scieSal;
        svtSal.nbma++;

        UE resSal = new UE("reseau ", 3f, 302);
        resSal.listeDesMatiers[0] = javaSal;
        resSal.nbma++;

        sal.listeUE[0] = svtSal;
        sal.listeUE[1] = resSal;
        sal.nbUEE += 2;

        Matiere mathLam = new Matiere("math", 3f, 401);
        mathLam.setNoteDs(18.0);
        mathLam.setNoteExamen(19.0);

        Matiere phyLam = new Matiere("phy", 2f, 402);
        phyLam.setNoteDs(16.5);
        phyLam.setNoteExamen(17.0);

        Matiere scieLam = new Matiere("science", 2.5f, 403);
        scieLam.setNoteDs(15.0);
        scieLam.setNoteExamen(16.0);

        Matiere javaLam = new Matiere("java", 2f, 404);
        javaLam.setNoteDs(14.0);
        javaLam.setNoteExamen(15.5);

        UE mpLam = new UE("sceince appliqué", 4f, 401);
        mpLam.listeDesMatiers[0] = mathLam;
        mpLam.listeDesMatiers[1] = phyLam;
        mpLam.nbma += 2;

        UE svtLam = new UE("science naturelle ", 3f, 402);
        svtLam.listeDesMatiers[0] = scieLam;
        svtLam.nbma++;

        UE resLam = new UE("reseau ", 3f, 403);
        resLam.listeDesMatiers[0] = javaLam;
        resLam.nbma++;

        lam.listeUE[0] = mpLam;
        lam.listeUE[1] = svtLam;
        lam.listeUE[2] = resLam;
        lam.nbUEE += 3;

        int choix;
        do {
            System.out.println("\nBinevenue a notre plateforme  veillez choisir une commande \n taper 1 pour acceder au page matiére \n taper 2 pour aceder a la page module (UE)\n taper 3 pour acceder a la page d Etudiant \n taper 0 pour quiter le plateforme  ");

            System.out.print("Veillez donner une  commande  : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    int choixMatiere;
                    do {
                        System.out.println("\n Bienvenue a espace matiere veuillez choisir une commande  \n taper 1 pour ajouter une matiére \n taper pour modifier une matiére \n taper 3 pour la suppression d une matiére \n taper 4 pour afficher les matiérer \n taper 0 pour retourner a la page plateforme ");

                        System.out.print("choisir une commande  : ");
                        choixMatiere = sc.nextInt();
                        sc.nextLine();

                        switch (choixMatiere) {
                            case 1: gestionMatiere.ajouter(); break;
                            case 2: gestionMatiere.modifier(); break;
                            case 3: gestionMatiere.supprimer(); break;
                            case 4: gestionMatiere.afficher(); break;
                            default:
                                System.out.println("veuillez entrer une commande existante ");
                        }
                    } while (choixMatiere != 0);
                    break;

                case 2:
                    int choixUE;
                    do {
                        System.out.println("\nbienvenue a la page   Module (UE) veuillez choisir une commande \n taper 1 pour ajouter un module \n taper 2 pour afficher les modules \n taper 3 pour supprimer un module \n taper 4 pour modifier les modules   \n taper 0 pour retourner a la page plateforme  ");

                        System.out.print("donner votre commande  : ");
                        choixUE = sc.nextInt();
                        sc.nextLine();

                        switch (choixUE) {
                            case 1: gestionUE.ajouter(); break;
                            case 2: gestionUE.afficher(); break;
                            case 3: gestionUE.supprimer(); break;
                            case 4: gestionUE.modifier(); break;

                            default:
                                System.err.println("donner une commande valide ");
                        }
                    } while (choixUE != 0);
                    break;

                case 3:
                    int choixEtudiant;
                    do {
                        System.out.println("\nBienvenue a la page   Étudiant veuillez choisir une commande \n taper 1 pour l ajout d un nouveau etudiant \n taper 2 pour la modiication dun etudiant existant \n taper 3 pour supprimer un etudiant \n taper 4 pour afficher la liste des etudiant \n taper 5 pour voir la fiche de note d un etudiant \n taper 6 pour connaitre le majeur de promo \n taper 0 pour retourner a la page plateforme ");

                        System.out.print("préciser votre commande : ");
                        choixEtudiant = sc.nextInt();
                        sc.nextLine();

                        switch (choixEtudiant) {
                            case 1: gestionEtudiants.ajouter(); break;
                            case 2: gestionEtudiants.modifier(); break;
                            case 3: gestionEtudiants.supprimer(); break;
                            case 4: gestionEtudiants.afficher(); break;
                            case 5: {
                                Etudiant etudiantTrouve = GestionEtudiants.rechercher();
                                if (etudiantTrouve != null) {
                                    etudiantTrouve.afficherBulletin();
                                } else {
                                    System.out.println("Aucun étudiant trouvé avec cet ID.");
                                }
                            } break;
                            case 6: gestionEtudiants.afficherEtudiantMajeur(); break;
                            default:
                                System.out.println("donner une commande existante ");
                        }
                    } while (choixEtudiant != 0);
                    break;

                case 0:
                    System.out.println("A bientot , a la prochaine fois ");
                    break;

                default:
                    System.out.println("donner une commande qui est dans la liste ");
                    break;
            }

        } while (choix != 0);

        sc.close();
    }
}