Projet P12 Application de Crédit digital aux professionnels
-------------------

Description : 
-------------------
**Credit Web** : application ayant pour objectif de proposer une solution de crédit digitalisée pour les professionnels.
Il s'agit d'un processus de crédit complet pour lequel la comptabilité cliente est numérisée puis analyser automatiquement afin 
d'accelerer le processus d'octroi du credit demandé.


Technologies
-------------------

Java EE
Spring Boot
Spring Security
JWT 
Tomcat 
Maven
Postgresql
MongoDB
Spring JPA
Angular Cli
Bootstrap
Material UI
Prime NG
Pdfbox : https://pdfbox.apache.org/


logiciel d'aide a la conception 
-------------------
Visual paradigm (uml , wireframe, diagramme d'architecture)
MongoDB compass ( client mongo db)
Pgadmin
IntelliJ IDEA
Integration : Postman
prezi viewer ( diaporama)
GitHub




Composition : 
-------------------
Organisation du repertoire :

L'application est crée en 3 Micro-Services

Partie Back-End
- sec-Service : Module de gestion des habilitations et des utilisateurs 
- gestion-Crédit : Module de gestion du crédit 
- gestion-Document : Module de gestion des Document lié a l'octroi de crédit ( éléments comptables)

Partie Front-End
-creditdigital : 

-Document : documentation de l'application, note d'intention.


Environnement de développement :
-------------------


Il comporte :

une base de donnée PostgreSQL contenant un jeu de donnée dossier de credit (postgresql://127.0.0.1:9032/db_b_gestion_credit)
une base de donnée MongoDB contenant un jeu de document ( liasse fiscale) (MongoDB://127.0.0.1::8087/catal)
une base de donnée PostgresSQL contenant un jeu de donnée user (postgresql://127.0.0.1:9032/db_b_user)


Lancement
-------------------

Vous trouverez un fichier structure de la base de données dans le répertoire script du repertoire racine  ainsi qu'un jeu de donnée:

Le serveur PostgreSQL est configuré avec les paramètres par défaut : Host name/address : localhost Port : 5432 Username : Postgresql 

Déploiement
-------------------

Créer 3 databases dans les conditions suivantes  :

| nom de la base de donnée       |     fichier a importer      |        type de donnée | jeu de donnée |
| :------------ | :-------------: | -------------: |-------------: |
| db_b_gestion_credit       |     db_credit.sql     |        postgres |db_data_credit.sql|
| db_b_user     |   db_user.sql    |      postgres | db_data_user.sql
| catal        |           |         mongodb | jeu de donnée chargé lors de la premiere mise en route |


concernant mongodb : passer par npm avec la commande ci jointe : npm install mongodb --save 
puis dans un second temps dans votre terminal : mongodb 
enfin : saisir : use catal

Nommer la database : db_b_gestion_credit et  db_b_user ( en respectant majuscule minuscule)

Utiliser le compte par default postgres. Importer les fichiers SQL joints


Les identifiants de connexion
-------------------

**Admin:** 
username : admin
password : 123456

**User:**
username : barroom
password : 123456

Deploiement de l'application 

-Télécharger ou cloner le projet via Github
-installer les bases de données ( selon tableau ci dessus)
-telecharger : client postgres par exemple pgadmin 


