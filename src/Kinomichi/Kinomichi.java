package Kinomichi;

import Menu.Menu;
import Menu.MenuBuilder;

public class Kinomichi {
    static Controller test = new Controller();
    public static void main(String[] args) {


        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            menuBuilder.startMenu("1", ": Gestion des participants");
            {
                menuBuilder.startMenu("1", ": Ajouter un participant");
                {
//                    menuBuilder.addItem(..........);
                    //Ajouter la méthode encodageParticipant()


                    menuBuilder.addItem("1", ": Ajout participant", getOption2());
                    menuBuilder.addItem("2", ": Afficher la liste des participants", getOption3());
                    menuBuilder.addItem("3", ": Retour", () -> menuPrincipal.execute());

                }
                menuBuilder.endMenu();
                menuBuilder.startMenu("2", ": Supprimer un participant");
                {
                    //Ajouter la méthode suppressionParticipant()
                    menuBuilder.addItem("1", ": Supprimer participant", getOption2());  // à modifier pour suppression
                    menuBuilder.addItem("2", ": Afficher la liste des participants", getOption3());
                    menuBuilder.addItem("3", ": Retour", () -> menuPrincipal.execute());
                }
                menuBuilder.endMenu();
                menuBuilder.startMenu("3", ": Modifier un participant");
                {
                    //Ajouter la méthode modificationParticipant()
                    menuBuilder.addItem("1", ": Modifier participant", getOption2());  // à modifier pour modifier un participant
                    menuBuilder.addItem("2", ": Afficher la liste des participants", getOption3());
                    menuBuilder.addItem("3", ": Retour", () -> menuPrincipal.execute());
                }
                menuBuilder.endMenu();
                menuBuilder.startMenu("4", ": Inscrire un participant à une activité");
                {
                    menuBuilder.startMenu("1", ": Activé");
                    {
                        //Ajouter la méthode affichage(Activites)
                        //Ajouter la méthode d'ajout à la liste des activités
                        menuBuilder.addItem("2", ": Retour", () -> menuPrincipal.execute());
                    }
                    menuBuilder.endMenu();
                    menuBuilder.startMenu("2", ": Logement");
                    {
                        //Ajouter la méthode affichage(Logement)
                        //Ajouter la méthode d'ajout à la liste des logements
                        menuBuilder.addItem("2", ": Retour", () -> menuPrincipal.execute());
                    }
                    menuBuilder.endMenu();
                    menuBuilder.startMenu("3", ": Repas");
                    {
                        //Ajouter la méthode affichage(Repas)
                        //Ajouter la méthode d'ajout à la liste des repas
                        menuBuilder.addItem("2", ": Retour", () -> menuPrincipal.execute());
                    }
                    menuBuilder.endMenu();
                    menuBuilder.addItem("4", ": Retour", () -> menuPrincipal.execute());
                }
                menuBuilder.endMenu();
                menuBuilder.addItem("5", ": Retour", () -> menuPrincipal.execute());
            }
            menuBuilder.endMenu();
            menuBuilder.startMenu("2", ": Gestion du stage");
            {
                menuBuilder.startMenu("1", ": Activités");
                {
                    //Ajout méthode ajoutActivite()
                    //Ajout méthode suppressionActivite()
                    menuBuilder.addItem("3", ": Retour", () -> menuPrincipal.execute());
                }
                menuBuilder.endMenu();
                menuBuilder.startMenu("2", ": Logements");
                {
                    //Ajout méthode ajoutLogement()
                    //Ajout méthode suppressionLogement()
                    menuBuilder.addItem("3", ": Retour", () -> menuPrincipal.execute());
                }
                menuBuilder.endMenu();
                menuBuilder.startMenu("3", ": Repas");
                {
                    //Ajout méthode ajoutRepas()
                    //Ajout méthode suppressionRepas()
                    menuBuilder.addItem("3", ": Retour", () -> menuPrincipal.execute());
                }
                menuBuilder.endMenu();
                menuBuilder.addItem("4", ": Retour", () -> menuPrincipal.execute());
            }
            menuBuilder.endMenu();
            menuBuilder.addItem("3", ": Quitter le programme", () -> menuPrincipal.setFinish(true));
        }
        menuBuilder.end();

        while (!menuPrincipal.isFinish()) {
            menuPrincipal.execute();
        }

    }
    private static Runnable ajoutPart() {
        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    private static Runnable getOption2() {
        return () -> test.addPersonne();
    }

    private static Runnable getOption3() {
        return () -> test.printListePersonnes();
    }

    private static Runnable getOption4() {
        return () -> System.out.println("Vous avez choisi l'option 4");
    }

    private static Runnable getOption5() { return () -> test.modifierPersonne(); }

    private static Runnable getOption6(){ return () -> test.supprimerPersonne(); }



    private static Runnable getOption7() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Vous avez choisi l'option 5 !");
            }
        };
    }

}
    //Kinomichi.Controller test = new Kinomichi.Controller();
   //         test.addPersonne();
    //        test.addPersonne();
    //        test.printListePersonnes();