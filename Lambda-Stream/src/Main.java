import Entity.Learner;
import Entity.Schoolar;
import Entity.Section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static List<Learner> learnerList = learnerListGenerator();

    public static void main(String[] args) {
        System.out.println("Original List: ");
        learnerList.forEach(System.out::println);
        System.out.println("----------------");

        test1();
        test2();
        test3();
        test4();
        test5();
        distinctTest();
        flatMapTest();
    }

    private static void flatMapTest() {
        Section football = new Section("Football");
        Section volleyball = new Section("Volleyball");
        football.addMember(learnerList.get(0));
        football.addMember(learnerList.get(1));
        football.addMember(learnerList.get(2));
        volleyball.addMember(learnerList.get(3));
        volleyball.addMember(learnerList.get(4));
        volleyball.addMember(learnerList.get(5));

        List<Section> sectionsList = List.of(football, volleyball);
        sectionsList.stream()
                .flatMap(section -> section.getMembers().stream())
                .forEach(System.out::println);
    }

    private static void distinctTest() {
        int[] ints = {1, 2, 5, 4, 3, 5, 5, 3, 2, 1};
        Stream<Integer> integerStream = Arrays.stream(ints).boxed();
        System.out.println("Distinct test\nOriginal Stream: " + Arrays.toString(ints));
        System.out.println("After distinct: " + integerStream.distinct().toList());
        integerStream.close();
    }

    private static void test5() {
        System.out.println("Replaced all 'SPB' -> 'Saint Petersburg': ");
        learnerList.stream()
                .forEach(learner -> {
                    if (learner.getCity() == "SPB") {
                        learner.setCity("Saint-Petersburg");
                    }
                    System.out.println(learner);
                });
    }

    private static void test4() {
        System.out.println("AVG Age: ");
        learnerList.stream()
                .map(Learner::getAge)
                .reduce(Integer::sum)
                .ifPresent(reducedInt -> {
                    System.out.println((double) reducedInt / learnerList.size());
                });
        System.out.println("----------------");
    }

    private static void test3() {
        System.out.println("Filtered and Sorted by reversed age (avg < 4.5 && class < 10)");
        learnerList.stream()
                .map(l -> (Schoolar) l)
                .filter(s -> s.getAvgGrade() < 4.5 && s.getClassNumber() < 10)
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())
                .forEach(System.out::println);
        System.out.println("----------------");
    }

    private static void test2() {
        System.out.println("Filtered List (Learners from Moscow in another list): ");
        List<Learner> learnersFromMoscow = learnerList.stream()
                .filter(l -> l.getCity() == "Moscow")
                .toList();
        learnersFromMoscow.forEach(System.out::println);
        System.out.println("----------------");
    }

    private static void test1() {
        System.out.println("Filtered List (avg >= 4.3): ");
        learnerList.stream()
                .map(learner -> (Schoolar) learner)
                .filter(schoolar -> schoolar.getAvgGrade() >= 4.3)
                .forEach(System.out::println);
        System.out.println("----------------");
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