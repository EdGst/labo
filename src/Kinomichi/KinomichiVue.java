package Kinomichi;


import Kinomichi.Activite.Activite;
import Kinomichi.Menu.Menu;
import Kinomichi.Menu.MenuBuilder;
import Kinomichi.Personne.Personne;

import java.time.DateTimeException;
import java.util.List;

    public class KinomichiVue {
        private Controller controller = new Controller();

        private MenuBuilder menuBuilder = new MenuBuilder();

//        public void getVue(){
//            RecupData recupData = new RecupData();
//            recupData.load();
//            Data data = recupData.getData();
//
////            List<PersonneModel> fileListPersonneModel = data.getFileListPersonneModel();
////            List<AbstractActivitesModel> fileListActivite = data.getFileListActivite();
//
//            Menu menuPrincipal = getMenuPrincipal(fileListPersonneModel, fileListActivite);
//            while (!menuPrincipal.isFinish()){
//                menuPrincipal.execute();
//                recupData.save();
//            }
//        }

        public Menu getMenuPrincipal(){
            Menu menuPrincipal = menuBuilder.start("Kinomichi.Menu Principal");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("----------------------------Kinomichi.Menu principal-----------------------------");
            System.out.println("-----------------------------------------------------------------------");
            getGestionPersonne();
            getGestionActivite();
//            getGestionInscription(personne, activite);
            menuBuilder.addItem("q", "Quitter", () -> menuPrincipal.setFinish(true));
            menuBuilder.end();

            while (!menuPrincipal.isFinish()) {
                menuPrincipal.execute();
            }
            return menuPrincipal;
        }

        public void getGestionPersonne(){

            Menu menuGestionPersonne = menuBuilder.startMenu("1", "Gestion des personnes");
            menuBuilder.addItem("1", "Ajouter une personne", () -> controller.addPersonne());
            menuBuilder.addItem("2", "Afficher la liste", () -> controller.printListePersonnes());
            menuBuilder.addItem("3", "Supprimer une personne", () -> controller.supprimerPersonne());
            menuBuilder.addItem("4", "Modifier une personne", () -> controller.modifierPersonne());
            menuBuilder.addItem("q", "Quitter", () -> menuGestionPersonne.setFinish(true));
            menuBuilder.endMenu();

        }

        public void getGestionActivite(){
            Menu gestionDesActivites = menuBuilder.startMenu("2", "Gestion des activités");
            try{
                menuBuilder.addItem("1", "Ajouter une activité",() -> controller.addActivite());
            }catch (DateTimeException e){
                System.out.println(e.getMessage());
            }
            menuBuilder.addItem("2", "Liste des activité", () ->controller.printListeActivite());
            menuBuilder.addItem("3", "Supprimer une activité",() -> controller.supprimerActivite());
            menuBuilder.addItem("4", "Modifier une activité", () ->controller.modifierActivite());
            menuBuilder.addItem("q", "Quitter", () -> gestionDesActivites.setFinish(true));
            menuBuilder.endMenu();
        }

        public void getGestionInscription(){
            Menu gestionDesInscriptions = menuBuilder.startMenu("3", "Gestion des inscriptions");
            menuBuilder.addItem("1", "Inscrire une personne a une activité", () -> controller.inscrirePersonneActivite());
            menuBuilder.addItem("2", "Afficher la liste des activités et des inscrits", () -> controller.printActiviteEtParticipants());
            menuBuilder.addItem("q", "Retour", () -> gestionDesInscriptions.setFinish(true));
            menuBuilder.endMenu();
        }


    }

