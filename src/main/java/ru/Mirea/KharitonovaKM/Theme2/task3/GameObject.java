package ru.Mirea.KharitonovaKM.Theme2.task3;

public class GameObject {
    private int id;
    private String name;
    private Position position;
    public GameObject(int id, String name, Position position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
