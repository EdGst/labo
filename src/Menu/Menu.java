package Menu;

import java.util.*;

public class Menu extends Item{


    private Map<String, Item> itemMap = new LinkedHashMap<>();
    private MenuVue vue;
    private boolean finish = false;

    public Menu(String libele, MenuVue vue) {
        super(libele);
        // regarde si la vue est null, si oui , leve une exception
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    @Override
    public void execute() {
        String choix = vue.getChoice(this);
        while (!this.itemMap.containsKey(choix))
            choix = vue.getChoice(this);
        itemMap.get(choix).execute();
    }

    public Item addItem(String key, Item value) {
        return itemMap.put(key, value);
    }
    public MenuVue getVue() {
        return vue;
    }

    public void setVue(MenuVue vue) {
        // regarde si la vue est null, si oui , leve une exception
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public Map<String, String> getItemText() {
        Map<String,String> map = new LinkedHashMap<>();
        for (Map.Entry<String, Item> e : this.itemMap.entrySet()) {
            map.put(e.getKey(),e.getValue().getLibele());
        }
        return map;
    }
}