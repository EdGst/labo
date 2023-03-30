package menu;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        //Creation du menu Builder
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            // Ajout d'un item au menu
            menuBuilder.addItem("a", "option 1 ", getOption1());

            /////////////////////////////////////////////////////////////////
            menuBuilder.startMenu("b", "Menu Secondaire", new InlineVue());// Commencement d'un ajout de sous menu
            {
                menuBuilder.addItem("c", "option 2", getOption2());// ajout d'item au menu
                Menu menu = menuBuilder.startMenu("d", "Menu 3");// Commencement d'un ajout de sous menu
                {

                    menuBuilder.addItem("e", "option 3", getOption3());// ajout d'item au menu
                }

                menuBuilder.endMenu();// fin de l'ajout
            }
            //Permet de get le menu
            menuBuilder.endMenu();// fin de l'ajout
            menuBuilder.addItem("q", "Sortie", () -> menuPrincipal.setFinish(true));// ajout d'item au menu
        }
        menuBuilder.end();
        /////////////////////////////////////////////////////////////////


        while (!menuPrincipal.isFinish()) {
            menuPrincipal.execute();
        }
    }

    private static Menu getMenu() {
        Menu menuPrincipal = new Menu("Menu Principal", new MainVue());
        Menu menuSecondaire = new Menu("Menu Secondaire", new MainVue());
        ItemExecutable option1 = new ItemExecutable("Option 1", getOption1());
        ItemExecutable option2 = new ItemExecutable("Option 2", getOption2());
        ItemExecutable option3 = new ItemExecutable("Option 3", getOption3());
        ItemExecutable option4 = new ItemExecutable("Option 4", getOption4());
        ItemExecutable option5 = new ItemExecutable("Option 5", getOption5());
        menuSecondaire.addItem("a", option3);
        menuSecondaire.addItem("b", option4);
        menuPrincipal.addItem("i", option1);
        menuPrincipal.addItem("s", menuSecondaire);
        menuPrincipal.addItem("j", option2);
        menuPrincipal.addItem("k", option5);
        menuPrincipal.addItem("q", new ItemExecutable("Quitter", () -> menuPrincipal.setFinish(true)));
        return menuPrincipal;
    }

    private static Runnable getOption5() {
        return () -> System.out.println("Option 5 séléctionée");
    }

    private static Runnable getOption4() {
        return () -> System.out.println("Option 4 séléctionée");
    }

    private static Runnable getOption3() {
        return () -> System.out.println("Option 3 séléctionée");
    }

    private static Runnable getOption2() {
        return () -> System.out.println("Option 2 séléctionée");
    }

    private static Runnable getOption1() {
        return () -> System.out.println("Option 1 séléctionée");
    }
}