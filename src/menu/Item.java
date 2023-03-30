package menu;

public abstract class Item{
    private final String libele;
    private boolean active = true;

    public Item(String libele) {
        if (libele.isBlank() || libele == null) throw new IllegalArgumentException("Le libele est vide ou null");
        this.libele = libele;
    }

    public String getLibele() {
        return libele;
    }

    public abstract void execute();

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}