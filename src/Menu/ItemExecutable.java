package Menu;

public class ItemExecutable extends Item{
    private Runnable action;

    public ItemExecutable(String libele,Runnable action) {
        super(libele);
        this.action = action;
    }

    @Override
    public void execute() {
        if (this.isActive())this.action.run();

    }
}