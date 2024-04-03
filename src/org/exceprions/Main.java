package org.exceprions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanti libri vuoi creare?");
        int numerolibri = scanner.nextInt();
        scanner.nextLine();
        Libri[] array = new Libri[numerolibri];

        for (int i = 0; i < array.length; i++) {
            boolean inputValido = false;
            do {
                try {
                    System.out.println("Inserisci il nome del libro:");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci il numero di pagine:");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Devi inserire un numero per il numero di pagine. Riprova:");
                        scanner.nextLine();
                    }
                    int pagine = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci l'autore del libro:");
                    String autore = scanner.nextLine();
                    System.out.println("Inserisci l'editore del libro:");
                    String editore = scanner.nextLine();
                    array[i] = new Libri(nome, pagine, autore, editore);
                    inputValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            } while (!inputValido);
        }

        try (FileWriter writer = new FileWriter("./resources/data.txt")) {
            for (int i = 0; i < array.length; i++) {
                writer.write("nome:" + array[i].getNome() + ";pagine:" + array[i].getPages() + ";autore:" + array[i].getAutore() + ";editore:" + array[i].getEditore() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura su file");
        }

        try (Scanner fileScanner = new Scanner(new File("./resources/data.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }
    }
}

