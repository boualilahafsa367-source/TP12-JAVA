# Résultats d'exécution :
La figure suivante présente l'exécution globale du programme. Elle regroupe les résultats obtenus lors des dix étapes du TP 12.

<img width="1920" height="967" alt="image" src="https://github.com/user-attachments/assets/c9707222-8e5c-466f-ac64-cd3d0ade8991" />
<img width="1920" height="946" alt="image" src="https://github.com/user-attachments/assets/29f3b9ec-c4bb-4a1a-9e83-7abd85e44b32" />

# Étape 1 : Préparation de l'environnement de travail

Cette première étape consiste à préparer l'environnement de développement Java et à organiser le projet.

Nous avons créé le package com.example.filemanagement, qui contient deux classes principales : Main.java et FileManager.java.

La classe Main représente le point d'entrée de l'application. Elle permet de lancer les différentes opérations du TP. La classe FileManager regroupe les méthodes responsables de la manipulation des fichiers.

Nous avons également créé le répertoire data, destiné à stocker les fichiers utilisés pendant les exercices, notamment employees.txt et test.jpg.

Cette organisation permet de séparer clairement le code source des fichiers de données et facilite la gestion du projet.

// Résultat d'exécution :

====================================
     TP 12 : Gestion des fichiers
====================================

// Explication du résultat :

L'affichage du titre confirme le lancement de l'application Java. Le programme démarre correctement et peut maintenant exécuter les différentes opérations de gestion des fichiers.

# Étape 2 : Lecture d'un fichier texte avec BufferedReader

Dans cette étape, nous avons réalisé la lecture d'un fichier texte en utilisant les classes FileReader et BufferedReader.

La méthode FileReader permet d'ouvrir le fichier employees.txt, tandis que BufferedReader facilite la lecture de son contenu ligne par ligne.

Nous avons utilisé la méthode readLine() pour récupérer chaque ligne du fichier. Une boucle while permet de continuer la lecture tant que le résultat obtenu n'est pas égal à null, ce qui indique la fin du fichier.

Nous avons également utilisé un bloc try-with-resources afin de garantir la fermeture automatique du fichier après la lecture. Les éventuelles erreurs sont prises en charge avec IOException.

// Résultat d'exécution :

--- Contenu du fichier ---
Salma,23,Data Analyst
Yassine,27,Java Developer
Imane,25,Software Tester
Omar,29,System Administrator

// Explication du résultat :

Les quatre lignes du fichier employees.txt sont affichées correctement dans la console. Cela confirme que le fichier a été ouvert et lu avec succès, et que la lecture ligne par ligne fonctionne correctement.

# Étape 3 : Écriture dans un fichier avec BufferedWriter

Cette étape consiste à écrire du contenu dans un fichier texte à l'aide des classes FileWriter et BufferedWriter.

Nous avons créé la méthode writeFileWithBufferedWriter(), qui reçoit le chemin du fichier de destination en paramètre.

La classe FileWriter permet d'ouvrir le fichier output.txt, tandis que BufferedWriter améliore la gestion de l'écriture grâce à un tampon.

La méthode write() permet d'insérer du texte dans le fichier, et newLine() permet de passer à la ligne suivante.

Le fichier est créé automatiquement s'il n'existe pas. S'il existe déjà, son ancien contenu est remplacé.

// Résultat d'exécution :

Le fichier a ete modifie avec succes.

// Explication du résultat :

Ce message confirme que l'opération d'écriture s'est terminée correctement. Le fichier output.txt contient le texte du rapport généré par le programme.

# Étape 4 : Génération d'un rapport avec PrintWriter

Dans cet exercice, nous avons utilisé la classe PrintWriter pour générer un rapport contenant les informations des employés.

Cette classe permet d'écrire facilement du texte formaté dans un fichier. Nous avons utilisé println() pour écrire des lignes et printf() pour organiser les informations sous forme de colonnes.

La méthode printf() permet notamment de contrôler l'affichage des noms, des âges et des professions à l'aide de spécificateurs de format.

Le rapport généré est enregistré dans le fichier report.txt.

Nous avons également utilisé checkError() pour vérifier si une erreur s'est produite pendant l'écriture.

// Résultat d'exécution :

Le rapport a ete cree avec succes.

// Explication du résultat :

Ce message indique que le rapport a été généré correctement. Le fichier report.txt contient les informations des employés présentées sous une forme organisée et lisible.

# Étape 5 : Utilisation de l'API Files de Java NIO

Cette étape permet de découvrir l'API java.nio.file.Files, qui propose des méthodes simplifiées pour manipuler les fichiers.

Nous avons utilisé la méthode readAllLines() pour lire toutes les lignes du fichier employees.txt et les récupérer dans une liste de chaînes de caractères.

Ensuite, la méthode write() permet d'écrire un nouveau contenu dans le fichier nio_output.txt.

Nous avons également utilisé StandardCharsets.UTF_8 pour préciser l'encodage du texte lors des opérations de lecture et d'écriture.

Cette approche constitue une alternative aux méthodes classiques basées sur FileReader et BufferedReader.

// Résultat d'exécution :

--- Lecture avec Files.readAllLines() ---
Salma,23,Data Analyst
Yassine,27,Java Developer
Imane,25,Software Tester
Omar,29,System Administrator

Fichier cree avec l'API Files avec succes.

// Explication du résultat :

Le contenu du fichier employees.txt est affiché une nouvelle fois grâce à Files.readAllLines(). Ensuite, le message de confirmation indique que le fichier nio_output.txt a été créé avec succès à l'aide de l'API Files.

# Étape 6 : Copie et déplacement de fichiers

Dans cette étape, nous avons utilisé les méthodes Files.copy() et Files.move() pour effectuer des opérations sur les fichiers.

La méthode Files.copy() permet de créer une copie du fichier original employees.txt sous le nom employees_backup.txt.

La méthode Files.move() permet ensuite de déplacer le fichier nio_output.txt vers un nouvel emplacement portant le nom moved_output.txt.

Nous avons utilisé StandardCopyOption.REPLACE_EXISTING afin d'autoriser le remplacement du fichier de destination lorsqu'il existe déjà.

Ces opérations permettent de comprendre la différence entre la copie d'un fichier et son déplacement.

// Résultat d'exécution :

Fichier copie avec succes.

Fichier deplace avec succes.

// Explication du résultat :

Le premier message confirme la création de la copie employees_backup.txt, tandis que le deuxième confirme le déplacement de nio_output.txt vers moved_output.txt. Le fichier original employees.txt reste présent dans le répertoire data.

# Étape 7 : Suppression de fichiers et gestion des erreurs

Cette étape consiste à supprimer des fichiers et à vérifier leur existence avant d'effectuer cette opération.

Nous avons utilisé Files.exists() pour déterminer si un fichier est présent dans le répertoire. Si le fichier existe, la méthode Files.delete() permet de le supprimer.

Nous avons également utilisé NoSuchFileException pour gérer le cas où le fichier demandé est introuvable.

Pour tester les deux situations, nous avons demandé au programme de supprimer moved_output.txt, puis de vérifier l'existence de unknown.txt.

// Résultat d'exécution :

Fichier supprime avec succes : data/moved_output.txt

Le fichier n'existe pas : data/unknown.txt

// Explication du résultat :

Le premier message confirme que le fichier moved_output.txt a été supprimé correctement. Le deuxième indique que unknown.txt n'existe pas. Le programme gère donc correctement les deux situations sans interrompre son exécution.

# Étape 8 : Lecture d'un fichier binaire

Dans cet exercice, nous avons réalisé la lecture d'un fichier binaire à l'aide de FileInputStream et BufferedInputStream.

Le fichier utilisé est une image nommée test.jpg, placée dans le répertoire data.

Contrairement à la lecture d'un fichier texte, la lecture binaire s'effectue sous forme d'octets. Nous avons donc utilisé un tableau de bytes pour stocker temporairement les données lues.

Une boucle while permet de lire progressivement les octets jusqu'à la fin du fichier. Une variable totalBytes permet de calculer le nombre total d'octets lus.

// Résultat d'exécution :

Lecture du fichier binaire terminee.
Nombre total d'octets : 325455

// Explication du résultat :

La lecture du fichier test.jpg s'est terminée correctement. Le programme a comptabilisé 325455 octets, ce qui correspond à la taille des données lues depuis l'image utilisée pour le test.

# Étape 9 : Écriture d'un fichier binaire

Cette étape consiste à créer une copie binaire du fichier image original.

Nous avons utilisé FileOutputStream et BufferedOutputStream pour écrire les données sous forme d'octets dans un nouveau fichier.

La méthode Files.readAllBytes() permet d'abord de récupérer toutes les données de l'image test.jpg dans un tableau de bytes.

Ensuite, la méthode writeBinaryFile() utilise le flux de sortie pour écrire ces données dans le fichier copy_binary.bin.

Cette opération permet de reproduire le contenu binaire du fichier original dans un nouveau fichier.

// Résultat d'exécution :

Copie binaire creee avec succes.

// Explication du résultat :

Le message confirme que le fichier copy_binary.bin a été créé avec succès. Il contient les mêmes données binaires que l'image originale test.jpg. La différence entre les deux fichiers concerne uniquement leur nom et leur extension.

# Étape 10 : Consultation des métadonnées d'un fichier

Dans cette dernière étape, nous avons utilisé Files.readAttributes() et la classe BasicFileAttributes pour récupérer les métadonnées d'un fichier.

Le programme consulte les propriétés du fichier employees.txt, notamment son chemin, sa taille en octets et sa date de dernière modification.

Nous avons également utilisé les méthodes isDirectory() et isRegularFile() pour déterminer si le chemin correspond à un répertoire ou à un fichier normal.

Ces informations permettent de mieux connaître les caractéristiques d'un fichier sans avoir besoin de lire son contenu.

// Résultat d'exécution :

--- Metadonnees du fichier ---
Chemin : data\employees.txt
Taille : 106 octets
Derniere modification : 2026-11-17T01:07:31.5612445Z
Est un repertoire : false
Est un fichier normal : true

// Explication du résultat :

Le programme affiche les métadonnées de employees.txt. Sa taille est de 106 octets. La valeur false indique qu'il ne s'agit pas d'un répertoire, tandis que true confirme qu'il s'agit d'un fichier normal. La date affichée correspond à sa dernière modification enregistrée.
