package br.com.gc.oop.application;

import br.com.gc.oop.service.Normaliser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String jt = scanner.nextLine();

        Normaliser normaliser = new Normaliser();
        String a = normaliser.normalise(jt);
        System.out.println(a);
    }
}