Lab 1 : Suivi des Scripts des Développeurs

Etape 1 :
J’ai commencé par installer et vérifier les outils nécessaires : Java (JDK), NetBeans et MySQL via XAMPP. J’ai ensuite préparé le driver JDBC MySQL (mysql-connector-j-8.4.0.jar) pour l'ajouter au projet NetBeans afin que Java puisse se connecter à la base de données.

Etape 2 :
J'ai créé la base atelier, après j'ai créé le projet intitulé Lab1_SuiviScripts dans NetBeans et ajouter le driver dans libraries.

Etape 3 :
J'ai créé la classe ExoJDBC connexion avec MySQL.java et taper le code puis run file 

<img width="1178" height="508" alt="image" src="https://github.com/user-attachments/assets/361b07a0-3eb2-4569-b6f1-61092cfe6740" />

Le programme s’exécute correctement et affiche les résultats dans la console, ce qui montre que la connexion et les requêtes fonctionnent bien.

Le but était de comprendre comment Java peut communiquer avec une base de données et exécuter des requêtes SQL.

Lab 2 : Gestion des Machines et des Employés

Etape 1 :
j'ai commencé à préparer la base de données et créer les deux tables machine et employe .Donc on aura trois tables en final, devdata pour lab 1 , machine et employe pour lab 2

<img width="271" height="266" alt="image" src="https://github.com/user-attachments/assets/1b4c7fa4-ab0d-4a26-9baa-8c0a7955487f" />

Etape 2 :
J'ai créé le 2ème projet intitulé Lab2_GestionMachines dans NetBeans et ajouter le meme driver dans libraries

Etape 3 :
J'ai créé cinq packages : util, entities, dao, service, app .De surcoit j’ai créé une classe Connexion dans le package util,les classes Employe et Machine dans le package entities
J’ai créé une interface IDao qui définit les opérations CRUD (ajout, lecture, modification, suppression).J’ai implémenté les deux classes EmployeDao et MachineDao dans le package Dao
J’ai créé les classes EmployeService et MachineService dans le package service , finalement j'ai créé les TestEmploye et TestMachine dans le package app , et dans chacune de ces classes j'ai tapé le code et executer

TestMachine

<img width="1202" height="574" alt="image" src="https://github.com/user-attachments/assets/58bf3a85-b103-413e-8c6d-9eed49821356" />

TestEmploye

<img width="1219" height="550" alt="image" src="https://github.com/user-attachments/assets/8b1611ab-12b4-42d9-986e-2088611f7279" />

Des classes de test avec une méthode main ont été utilisées pour vérifier le bon fonctionnement du programme. Les tests montrent que les employés et les machines sont bien ajoutés, modifiés et supprimés, et que la relation entre eux fonctionne correctement.

Les résultats affichés dans la console confirment que toutes les opérations fonctionnent correctement











