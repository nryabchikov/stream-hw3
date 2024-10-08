package ru.clevertec;

import ru.clevertec.model.Animal;
import ru.clevertec.model.Car;
import ru.clevertec.model.Examination;
import ru.clevertec.model.Flower;
import ru.clevertec.model.House;
import ru.clevertec.model.Person;
import ru.clevertec.model.Student;
import ru.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1().forEach(System.out::println);
        task2().forEach(System.out::println);
        task3().forEach(System.out::println);
        System.out.println(task4());
       System.out.println(task5());
        System.out.println(task6());
        System.out.println(task7());
        System.out.println(task8());
        System.out.println(task9());
        System.out.println(task10());
        System.out.println(task11());
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19("P-1");
        task20();
        task21();
        task22();
    }

    public static List<Animal> task1() {
        final int MIN_AGE = 10;
        final int MAX_AGE = 20;
        final int GROUP_SIZE = 7;
        final int NUM_OF_ZOO = 2;
        List<Animal> animals = Util.getAnimals();
        AtomicInteger size = new AtomicInteger(0);

        return animals.stream()
                .filter(animal -> animal.getAge() >= MIN_AGE)
                .filter(animal -> animal.getAge() <= MAX_AGE)
                .sorted(Comparator.comparingDouble(Animal::getAge))
                .collect(Collectors.groupingBy(
                        animal -> size.getAndIncrement() / GROUP_SIZE))
                .get(NUM_OF_ZOO);
    }

    public static List<Animal> task2() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> {
                    if (animal.getGender().equals("Female")) {
                        animal.setBread(animal.getBread().toUpperCase());
                    }
                }).toList();
    }

    public static List<String> task3() {
        final int ANIMAL_AGE = 30;
        final char START_LETTER = 'A';
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .filter(animal -> animal.getAge() > ANIMAL_AGE)
                .map(Animal::getOrigin)
                .filter(s -> s.charAt(0) == START_LETTER)
                .distinct()
                .toList();
    }

    public static long task4() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
    }

    public static boolean task5() {
        final int MIN_AGE = 20;
        final int MAX_AGE = 30;
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .filter(animal -> animal.getAge() >= MIN_AGE)
                .filter(animal -> animal.getAge() <= MAX_AGE)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
    }

    public static boolean task6() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .allMatch(animal -> animal.getGender().equals("Female") || animal.getGender().equals("Male"));
    }

    public static boolean task7() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
    }

    public static int task8() {
        final int MAX_AMOUNT = 100;
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(MAX_AMOUNT)
                .map(Animal::getAge)
                .max(Integer::compareTo).orElse(0);
    }

    public static int task9() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .map(chars -> chars.length)
                .min(Integer::compareTo).orElse(0);
    }

    public static int task10() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
    }

    public static double task11() {
        List<Animal> animals = Util.getAnimals();

        return animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average().orElse(0.0);
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
        final int MIN_AGE = 18;
        final int MAX_AGE = 63;
        final int MAX_AMOUNT_OF_PEOPLE = 500;
        List<House> houses = Util.getHouses();

        Stream<Person> hospitalPeople = houses.stream()
                .filter(house -> house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream());

        Stream<Person> youngAndOldPeople = houses.stream()
                .filter(house -> !house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream())
                .filter(person -> Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() <= MIN_AGE
                        || Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() >= MAX_AGE);

        Stream<Person> otherPeople = houses.stream()
                .filter(house -> !house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream())
                .filter(person -> Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() > MIN_AGE
                        || Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() < MAX_AGE);

        Stream<Person> hospitalAndYoungAndOldPeople = Stream.concat(hospitalPeople, youngAndOldPeople);
        Stream.concat(hospitalAndYoungAndOldPeople, otherPeople)
                .limit(MAX_AMOUNT_OF_PEOPLE)
                .forEach(System.out::println);

    }

    public static void task14() {
        List<Car> cars = Util.getCars();

        List<Car> turkmenistanCars = cars.stream()
                .filter(car -> car.getCarMake().equals("Jaguar") ||
                        car.getColor().equals("White"))
                .toList();

        cars.removeAll(turkmenistanCars);

        final int MAX_CAR_WEIGHT = 1500;
        List<Car> uzbekCars = cars.stream()
                .filter(car -> car.getMass() < MAX_CAR_WEIGHT)
                .filter(car -> car.getCarModel().equals("BMW") ||
                        car.getCarModel().equals("Lexus") ||
                        car.getCarModel().equals("Chrysler") ||
                        car.getCarModel().equals("Toyota"))
                .toList();

        cars.removeAll(uzbekCars);

        final int MIN_CAR_WEIGHT = 4000;
        List<Car> kazakhCars = cars.stream()
                .filter(car -> car.getMass() > MIN_CAR_WEIGHT && car.getColor().equals("BLACK")
                        || car.getCarMake().equals("GMC")
                        || car.getCarMake().equals("Dodge")
                ).toList();

        cars.removeAll(kazakhCars);

        final int MAX_RELEASE_YEAR = 1982;
        List<Car> kyrgyzCars = cars.stream()
                .filter(car -> car.getReleaseYear() < MAX_RELEASE_YEAR
                        || car.getCarMake().equals("Cherokee")
                        || car.getCarMake().equals("Civic")
                ).toList();

        cars.removeAll(kyrgyzCars);

        final int MIN_PRICE = 40000;
        List<Car> russianCars = cars.stream()
                .filter(car -> car.getPrice() > MIN_PRICE
                        || !(car.getColor().equals("Yellow")
                        || car.getCarMake().equals("Blue")
                        || car.getCarMake().equals("Green")
                        || car.getCarMake().equals("Red"))
                ).toList();

        cars.removeAll(russianCars);

        List<Car> mongolCars = cars.stream()
                .filter(car -> car.getVin().contains("59")
                ).toList();

        double price = 7.14;

        List<List<Car>> filteredCars =
                Stream.of(turkmenistanCars, uzbekCars, kazakhCars, kyrgyzCars, russianCars, mongolCars).toList();

        final int kilogramToTon = 1000;
        List<Double> costs = new ArrayList<>();
        for (List<Car> echelons: filteredCars) {
            double resultPrice = echelons.stream().mapToDouble(Car::getMass).sum() / kilogramToTon * price;
            costs.add(resultPrice);
        }

        costs.forEach(System.out::println);
        System.out.println(costs.stream().mapToDouble(cost -> cost).sum());
    }

    public static void task15() {
        final double WATER_PRICE = 1.39;
        final int YEARS = 5;
        final int DAY_IN_YEAR = 365;
        List<Flower> flowers = Util.getFlowers();

        System.out.println(flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().compareTo("S") <= 0)
                .filter(flower -> flower.getCommonName().compareTo("C") >= 0)
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().stream()
                        .anyMatch(material -> material.equals("Glass")
                                || material.equals("Aluminium")
                                || material.equals("Steel")))
                .mapToDouble(flower ->
                        flower.getPrice() + flower.getWaterConsumptionPerDay() * DAY_IN_YEAR * YEARS * WATER_PRICE)
                .sum());
    }

    public static void task16() {
        final int MAX_STUDENT_AGE = 18;
        List<Student> students = Util.getStudents();

        students.stream()
                .filter(student -> student.getAge() <= MAX_STUDENT_AGE)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println(student.getSurname() + ": " + student.getAge()));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();

        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();

        Map<String, Double> groupedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)));

        groupedStudents.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void task19(String group) {
        final int MIN_MARK = 4;
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        students.stream()
                .filter(student -> student.getGroup().equals(group))
                .filter(student -> examinations.stream()
                        .anyMatch(examination -> examination.getStudentId() == student.getId() &&
                                examination.getExam3() > MIN_MARK))
                .forEach(System.out::println);
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        Map<String, Double> groupedStudentsWithAverageFacultyMark = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingDouble(
                        student -> examinations.stream()
                                .filter(examination -> examination.getStudentId() == student.getId())
                                .mapToInt(Examination::getExam1)
                                .average().orElse(0.0))));

        groupedStudentsWithAverageFacultyMark.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(faculty -> System.out.println(faculty.getKey()));
    }

    public static void task21() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.minBy(Comparator.comparing(Student::getAge))))
                .forEach((key, value) ->
                        value.ifPresent(student -> System.out.println(key + ": " + student.getAge())));
    }
}
