package ru.Mirea.KharitonovaKM.Theme3.task2;

public class PrimeRequest {
    private String name;
    private int length;
    private String numbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
    public static void main(String[] args) {
        PrimeRequest primeRequest = new PrimeRequest();
        primeRequest.setName("Иванов Иван Иванович");
        primeRequest.setLength(10);
        primeRequest.setNumbers("10, 32, 40, 21, 56, 40, 90, 23, 91, 40");

        System.out.println("Name: " + primeRequest.getName());
        System.out.println("Length: " + primeRequest.getLength());
        System.out.println("Numbers: " + primeRequest.getNumbers());
    }
}