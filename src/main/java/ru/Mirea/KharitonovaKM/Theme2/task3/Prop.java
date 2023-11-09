package ru.Mirea.KharitonovaKM.Theme2.task3;

public class Prop extends GameObject implements Movable{
    public Prop(int id, String name, Position position) {
        super(id, name, position);
    }
    @Override
    public void move(Position newposition) {}
}
