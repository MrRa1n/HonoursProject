package dev.tobycook.benchmarks.helpers;

public class PersonFinaliser {

    private int age;

    public PersonFinaliser(int age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        age++;
    }
}
