package com.example.filemanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.NoSuchFileException;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class FileManager {

    // Partie 2 : Lire un fichier texte
    public static void readFileWithBufferedReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("\n--- Contenu du fichier ---");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + e.getMessage());
        }
    }

    // Partie 3 : Ecrire avec BufferedWriter
    public static void writeFileWithBufferedWriter(String filePath) {
        String content = "Service Informatique - Rapport des employes";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.newLine();
            writer.write("Ligne ajoutee avec succes.");

            System.out.println("\nLe fichier a ete modifie avec succes.");

        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture : " + e.getMessage());
        }
    }

    // Partie 4 : Creer un rapport avec PrintWriter
    public static void writeReportWithPrintWriter(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filePath))) {
            writer.println("===== RAPPORT DU PERSONNEL =====");
            writer.println("Nom       Age       Poste");
            writer.println("----------------------------------------");

            writer.printf("%-10s %-10d %s%n", "Salma", 23, "Data Analyst");
            writer.printf("%-10s %-10d %s%n", "Yassine", 27, "Java Developer");
            writer.printf("%-10s %-10d %s%n", "Imane", 25, "Software Tester");

            writer.println("----------------------------------------");
            writer.println("Nombre total d'employes : 3");

            if (writer.checkError()) {
                System.out.println("Une erreur est survenue pendant l'ecriture.");
            } else {
                System.out.println("\nLe rapport a ete cree avec succes.");
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la creation du rapport : " + e.getMessage());
        }
    }

    // Partie 5 : Lire avec Files
    public static void readFileWithFiles(String filePath) {
        try {
            List<String> lines = Files.readAllLines(
                Paths.get(filePath),
                StandardCharsets.UTF_8
            );

            System.out.println("\n--- Lecture avec Files.readAllLines() ---");

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture avec Files : " + e.getMessage());
        }
    }

    // Partie 5 : Ecrire avec Files
    public static void writeFileWithFiles(String filePath) {
        String content = "Rapport genere avec l'API Files de Java.";

        try {
            Files.write(
                Paths.get(filePath),
                content.getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("\nFichier cree avec l'API Files avec succes.");

        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture avec Files : " + e.getMessage());
        }
    }

    // Partie 6 : Copier un fichier
    public static void copyFile(String sourcePath, String destinationPath) {
        try {
            Files.copy(
                Paths.get(sourcePath),
                Paths.get(destinationPath),
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("\nFichier copie avec succes.");

        } catch (IOException e) {
            System.out.println("Erreur lors de la copie : " + e.getMessage());
        }
    }

    // Partie 6 : Deplacer un fichier
    public static void moveFile(String sourcePath, String destinationPath) {
        try {
            Files.move(
                Paths.get(sourcePath),
                Paths.get(destinationPath),
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("\nFichier deplace avec succes.");

        } catch (IOException e) {
            System.out.println("Erreur lors du deplacement : " + e.getMessage());
        }
    }

    // Partie 7 : Supprimer un fichier
    public static void deleteFile(String filePath) {
        try {
            if (Files.exists(Paths.get(filePath))) {
                Files.delete(Paths.get(filePath));
                System.out.println("\nFichier supprime avec succes : " + filePath);
            } else {
                System.out.println("\nLe fichier n'existe pas : " + filePath);
            }

        } catch (NoSuchFileException e) {
            System.out.println("Fichier introuvable : " + filePath);

        } catch (IOException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    // Partie 8 : Lire un fichier binaire
    public static void readBinaryFile(String filePath) {
        byte[] buffer = new byte[1024];
        int totalBytes = 0;

        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(filePath))) {

            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }

            System.out.println("\nLecture du fichier binaire terminee.");
            System.out.println("Nombre total d'octets : " + totalBytes);

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture binaire : " + e.getMessage());
        }
    }

    // Partie 9 : Ecrire un fichier binaire
    public static void writeBinaryFile(String filePath, byte[] data) {
        try (BufferedOutputStream output = new BufferedOutputStream(
                new FileOutputStream(filePath))) {

            output.write(data);

            System.out.println("\nCopie binaire creee avec succes.");

        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture binaire : " + e.getMessage());
        }
    }

    // Partie 10 : Afficher les metadonnees d'un fichier
    public static void displayFileMetadata(String filePath) {

        Path path = Paths.get(filePath);

        try {
            // Recuperer les attributs du fichier
            BasicFileAttributes attributes = Files.readAttributes(
                path,
                BasicFileAttributes.class
            );

            System.out.println("\n--- Metadonnees du fichier ---");
            System.out.println("Chemin : " + path);
            System.out.println("Taille : " + attributes.size() + " octets");
            System.out.println("Derniere modification : " + attributes.lastModifiedTime());
            System.out.println("Est un repertoire : " + attributes.isDirectory());
            System.out.println("Est un fichier normal : " + attributes.isRegularFile());

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture des metadonnees : "
                    + e.getMessage());
        }
    }
}