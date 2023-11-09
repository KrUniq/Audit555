package ru.Mirea.KharitonovaKM.Theme2.task3;

public class Creature extends GameObject implements Movable{
    private int hp;

    public Creature(int id, String name, Position position, int hp) {
        super(id, name, position);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
    @Override
    public void move(Position newposition) {}
}
