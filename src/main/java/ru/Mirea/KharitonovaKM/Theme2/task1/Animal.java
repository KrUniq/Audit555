package ru.Mirea.KharitonovaKM.Theme2.task1;

public abstract class Animal implements Voicable{
    protected int age;
    protected String name;
    public Animal() {}
    public abstract void sleep();
    public abstract void wake();
}
