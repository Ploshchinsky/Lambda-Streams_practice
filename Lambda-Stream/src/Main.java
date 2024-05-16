import Entity.Learner;
import Entity.Schoolar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Learner> learnerList = learnerListGenerator();
        System.out.println("Original List: ");
        learnerList.forEach(System.out::println);
        System.out.println("----------------");

        System.out.println("Filtered List (avg >= 4.3): ");
        learnerList.stream()
                .map(learner -> (Schoolar) learner)
                .filter(schoolar -> schoolar.getAvgGrade() >= 4.3)
                .forEach(System.out::println);
        System.out.println("----------------");

        System.out.println("Filtered List (Learners from Moscow in another list): ");
        List<Learner> learnersFromMoscow = learnerList.stream()
                .filter(l -> l.getCity() == "Moscow")
                .toList();
        learnersFromMoscow.forEach(System.out::println);
        System.out.println("----------------");

        System.out.println("Filtered and Sorted by reversed age (avg < 4.5 && class < 10)");
        learnerList.stream()
                .map(l -> (Schoolar) l)
                .filter(s -> s.getAvgGrade() < 4.5 && s.getClassNumber() < 10)
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())
                .forEach(System.out::println);
        System.out.println("----------------");

        System.out.println("AVG Age: ");
        learnerList.stream()
                .map(Learner::getAge)
                .reduce(Integer::sum)
                .ifPresent(reducedInt -> {
                    System.out.println((double) reducedInt / learnerList.size());
                });
        System.out.println("----------------");

        System.out.println("Replaced all 'SPB' -> 'Saint Petersburg': ");
        learnerList.stream()
                .forEach(learner -> {
                    if (learner.getCity() == "SPB") {
                        learner.setCity("Saint-Petersburg");
                    }
                    System.out.println(learner);
                });
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