package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
        task12();
//        task13();
//        task14();
//        task15();
//        task16();
//        task17();
//        task18();
//        task19();
//        task20();
//        task21();
//        task22();
    }

    public static void task1() {
        final int MIN_AGE = 10;
        final int MAX_AGE = 20;
        final int GROUP_SIZE = 7;
        final int NUM_OF_ZOO = 2;
        List<Animal> animals = Util.getAnimals();
        AtomicInteger size = new AtomicInteger(0);

        Map<Integer, List<Animal>> groupedAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= MIN_AGE)
                .filter(animal -> animal.getAge() <= MAX_AGE)
                .sorted(Comparator.comparingDouble(Animal::getAge))
                .collect(Collectors.groupingBy(
                        animal -> size.getAndIncrement() / GROUP_SIZE));

        groupedAnimals.get(NUM_OF_ZOO).forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> {
                    if (animal.getGender().equals("Female")) {
                        return animal.getBread().toUpperCase();
                    }
                    return animal.getBread();
                })
                .forEach(System.out::println);
    }

    public static void task3() {
        final int ANIMAL_AGE = 30;
        final char START_LETTER = 'A';
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() > ANIMAL_AGE)
                .map(Animal::getOrigin)
                .filter(s -> s.charAt(0) == START_LETTER)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();

        System.out.println(animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count());
    }

    public static void task5() {
        final int MIN_AGE = 20;
        final int MAX_AGE = 30;
        List<Animal> animals = Util.getAnimals();

        System.out.println(animals.stream()
                .filter(animal -> animal.getAge() >= MIN_AGE)
                .filter(animal -> animal.getAge() <= MAX_AGE)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian")));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();

        System.out.println(animals.stream()
                .allMatch(animal -> animal.getGender().equals("Female") || animal.getGender().equals("Male")));
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();

        System.out.println(animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania")));
    }

    public static void task8() {
        final int MAX_AMOUNT = 100;
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(MAX_AMOUNT)
                .map(Animal::getAge)
                .max(Integer::compareTo)
                .ifPresent(System.out::println);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .map(chars -> chars.length)
                .min(Integer::compareTo)
                .ifPresent(System.out::println);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();

        System.out.println(animals.stream()
                .mapToInt(Animal::getAge)
                .sum());
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .ifPresent(System.out::println);
    }

    public static void task12() {
        final int MIN_AGE = 18;
        final int MAX_AGE = 27;
        final int MAX_AMOUNT = 200;
        List<Person> people = Util.getPersons();

        people.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() >= MIN_AGE)
                .filter(person -> Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() <= MAX_AGE)
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(MAX_AMOUNT)
                .forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
