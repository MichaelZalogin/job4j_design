package ru.job4j.io;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(".\\src\\main\\java\\ru\\job4j\\io\\input.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}