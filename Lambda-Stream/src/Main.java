import Entity.Learner;
import Entity.Schoolar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Learner> learnerList = learnerListGenerator();
        System.out.println(learnerList);
    }

    public static List<Learner> learnerListGenerator() {
        List<Learner> learnerList = new ArrayList<>();
        learnerList.add(new Schoolar("Ivan", 14, "Moscow", 8, 4.3));
        learnerList.add(new Schoolar("Maria", 15, "SPB", 9, 4.8));
        learnerList.add(new Schoolar("Alexey", 12, "Moscow", 6, 3.5));
        learnerList.add(new Schoolar("Daria", 11, "Moscow", 6, 4.1));
        learnerList.add(new Schoolar("Alexander", 17, "SPB", 10, 5.0));
        learnerList.add(new Schoolar("Victoria", 17, "SPB", 10, 4.7));
        return learnerList;
    }
}