package ru.clevertec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import ru.clevertec.model.Animal;
import ru.clevertec.util.Util;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

class MainTest {

    private List<Animal> mockAnimals;

    @BeforeEach
    void setUp() {
        mockAnimals = Arrays.asList(
                new Animal(1, "Antelope, roan", 10, "Spanish", "Male"),
                new Animal(2, "Tern, arctic", 20, "Oriya", "Male"),
                new Animal(3, "White-throated toucan", 18, "Tsvana", "Female"),
                new Animal(4, "Huron", 17, "Japanese", "Female"),
                new Animal(5, "Bobcat", 21, "Japanese", "Male"),
                new Animal(6, "Dog", 13, "Aliaska", "Female"),
                new Animal(7, "Arctic tern", 15, "Icelandic", "Female"),
                new Animal(8, "Hamster", 15, "Russia", "Female"),
                new Animal(9, "Cat", 11, "Belarus", "Male"),
                new Animal(10, "Arctic cat", 15, "Icelandic", "Female"),
                new Animal(11, "Monkey", 17, "Spanish", "Female"),
                new Animal(12, "Bear", 15, "Belarus", "Female"),
                new Animal(13, "Fox", 15, "Indonesia", "Male"),
                new Animal(14, "Wolf", 17, "Russia", "Female"),
                new Animal(15, "Lion, mountain", 13, "Indonesian", "Male"),
                new Animal(16, "Horse", 19, "Bosnian", "Male"),
                new Animal(17, "Frog", 17, "Belarus", "Male"),
                new Animal(17, "Koala", 36, "Aliaska", "Male"),
                new Animal(17, "Abra", 31, "Australia", "Male")
        );
    }

    @Test
    void task1() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            List<Animal> result = Main.task1();
            List<Animal> expectedAnimals = Arrays.asList(
                    new Animal(16, "Horse", 19, "Bosnian", "Male"),
                    new Animal(2, "Tern, arctic", 20, "Oriya", "Male")
            );
            assertEquals(expectedAnimals, result);
        }
    }

    @Test
    void task2() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            List<Animal> result = Main.task2();
            List<Animal> expectedAnimals = Arrays.asList(
                    new Animal(4, "HURON", 17, "Japanese", "Female"),
                    new Animal(5, "Bobcat", 21, "Japanese", "Male")
            );
            assertEquals(expectedAnimals, result);
        }
    }

    @Test
    void task3() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            List<String> result = Main.task3();
            List<String> expectedAnimals = Arrays.asList(
                    "Aliaska", "Australia"
            );
            assertEquals(expectedAnimals, result);
        }
    }

    @Test
    void task4() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            long result = Main.task4();
            long expectedAmountOfAnimals = 9;
            assertEquals(expectedAmountOfAnimals, result);
        }
    }

    @Test
    void task5() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            boolean result = Main.task5();
            boolean expectedResult = false;
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void task6() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            boolean result = Main.task6();
            boolean expectedResult = true;
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void task7() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            boolean result = Main.task7();
            boolean expectedResult = true;
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void task8() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            int result = Main.task8();
            int expectedResult = 36;
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void task9() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            int result = Main.task9();
            int expectedResult = 3;
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void task10() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            int result = Main.task10();
            int expectedResult = 335;
            assertEquals(expectedResult, result);
        }
    }

    @Test
    void task11() {
        try (MockedStatic<Util> mockedUtil = mockStatic(Util.class)) {
            mockedUtil.when(Util::getAnimals).thenReturn(mockAnimals);
            double result = Main.task11();
            double expectedResult = 13.0;
            assertEquals(expectedResult, result);
        }
    }
}