package ru.Mirea.KharitonovaKM.Theme2.task1;

public class Cat extends Animal{
    protected int age;
    protected String name;
    private String color;
    private String breed;

    public Cat(String color, String breed ) {
        this.color=color;
        this.breed=breed;
    }
    @Override
    public void voice() {}
    @Override
    public void sleep() {}
    @Override
    public void wake() {}

}
