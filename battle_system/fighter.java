package battle_system;

public abstract class fighter {
    protected int hp;
    protected int atk;
    protected int def;
    protected int specAtk;
    protected int specDef;
    protected int spe;

    abstract void useMove(String move);
}
