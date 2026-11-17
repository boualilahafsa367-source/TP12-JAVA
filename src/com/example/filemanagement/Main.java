package com.example.filemanagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("     TP 12 : Gestion des fichiers");
        System.out.println("====================================");

        // Partie 2 : lecture avec BufferedReader
        FileManager.readFileWithBufferedReader("data/employees.txt");

        // Partie 3 : ecriture avec BufferedWriter
        FileManager.writeFileWithBufferedWriter("data/output.txt");

        // Partie 4 : rapport avec PrintWriter
        FileManager.writeReportWithPrintWriter("data/report.txt");

        // Partie 5 : lecture et ecriture avec Files
        FileManager.readFileWithFiles("data/employees.txt");
        FileManager.writeFileWithFiles("data/nio_output.txt");

        // Partie 6 : copie et deplacement
        FileManager.copyFile(
            "data/employees.txt",
            "data/employees_backup.txt"
        );

        FileManager.moveFile(
            "data/nio_output.txt",
            "data/moved_output.txt"
        );

        // Partie 7 : suppression
        FileManager.deleteFile("data/moved_output.txt");
        FileManager.deleteFile("data/unknown.txt");

        // Partie 8 : lecture binaire
        FileManager.readBinaryFile("data/test.jpg");

        // Partie 9 : ecriture binaire
        try {
            byte[] imageData = Files.readAllBytes(
                Paths.get("data/test.jpg")
            );

            FileManager.writeBinaryFile(
                "data/copy_binary.bin",
                imageData
            );

        } catch (IOException e) {
            System.out.println("Impossible de recuperer les octets de l'image : "
                    + e.getMessage());
        }

        // Partie 10 : afficher les metadonnees
        FileManager.displayFileMetadata("data/employees.txt");
    }
}