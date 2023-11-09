package ru.Mirea.KharitonovaKM.Theme2.task1;

public class Dog extends Animal{
    protected int age;
    protected String name;
    private String breed;

    public Dog(String breed ) {
        this.breed=breed;
    }
    @Override
    public void voice() {}
    @Override
    public void sleep() {}
    @Override
    public void wake() {}
}

