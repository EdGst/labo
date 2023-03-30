package menu;

import java.util.Map;
import java.util.Scanner;

public class InlineVue implements MenuVue{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getChoice(Menu menu) {
        Map<String, String> map = menu.getItemText();
        affiche(map);
        System.out.print("Votre choix: ");
        String choix = scanner.nextLine();
        System.out.println("--- --- --- --- ---");
        return choix;
    }
    @Override
    public void affiche(Map<String, String> map) {
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.printf("#%s - %s / ",e.getKey(),e.getValue());
        }
        System.out.println();
    }
}