package menu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuBuilder {
    MenuVue defaultVue = new MainVue();
    private Deque<Menu> pileMenu = new ArrayDeque<>();

    public Menu getMenu() {
        return pileMenu.peek();
    }

    public Item addItem(String key, String libel, Runnable action) {
        ItemExecutable itemExecutable = new ItemExecutable(libel, action);
        pileMenu.peek().addItem(key,itemExecutable);
        return itemExecutable;
    }

    public Menu startMenu(String key, String libel) {
        return startMenu(key,libel,defaultVue);
    }
    public Menu startMenu(String key, String libel, MenuVue vue) {
        Menu menu = new Menu(libel, vue);
        pileMenu.peek().addItem(key,menu);
        pileMenu.push(menu);
        return menu;
    }

    public Menu endMenu() {
        return pileMenu.pop();
    }

    public Menu start(String libel) {
        return start(libel,defaultVue);
    }
    public Menu start(String libel, MenuVue vue) {
        Menu menu = new Menu(libel,vue);
        pileMenu.push(menu);
        return  menu;
    }
    public void end(){
        pileMenu.clear();
    }

}