package Entity;

import java.util.Objects;

public class Schoolar extends Learner {
    private int classNumber;
    private double avgGrade;

    public Schoolar(String name, int age, String city, int classNumber, double avgGrade) {
        super(name, age, city);
        this.classNumber = classNumber;
        this.avgGrade = avgGrade;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public boolean equals(Object anotherSchoolar) {
        if (this == anotherSchoolar) return true;
        if (anotherSchoolar == null || getClass() != anotherSchoolar.getClass()) return false;
        Schoolar schoolar = (Schoolar) anotherSchoolar;
        return classNumber == schoolar.classNumber && Double.compare(avgGrade, schoolar.avgGrade) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCity(), getAge(), classNumber, avgGrade);
    }

    @Override
    public String toString() {
        return "Schoolar{" +
                "name=" + super.getName() +
                "age=" + super.getAge() +
                "city=" + super.getCity() +
                "classNumber=" + classNumber +
                ", avgGrade=" + avgGrade +
                '}';
    }

    @Override
    public int compareTo(Learner anotherLearner) {
        return this.toString().compareTo(anotherLearner.toString());
    }
}
