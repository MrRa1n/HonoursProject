package dev.tobycook.benchmarks.helpers;

public class PersonFinaliser {

    private final String name;
    private int age;

    public PersonFinaliser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected void finalize() throws Throwable {
        age++;
    }
}
