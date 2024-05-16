package Entity;

import java.util.Objects;

public abstract class Learner implements Comparable<Learner> {
    private String name;
    private int age;
    private String city;

    public Learner(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getAge();

    public abstract void setAge(int age);

    public abstract String getCity();

    public abstract void setCity(String city);

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();

    @Override
    public abstract int compareTo(Learner o);
}
