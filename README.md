#Projet P12 Application de Crédit digital aux professionnels

Composition : 

Organisation du repertoire :

L'application est crée en 3 Micro-Services

Partie Back-End
- sec-Service : Module de gestion des habilitations et des utilisateurs 
- gestion-Crédit : Module de gestion du crédit 
- gestion-Document : Module de gestion des Document lié a l'octroie de crédit ( éléments comptables)

Environnement de développement :

Les composants nécessaires lors du développement sont disponibles via des conteneurs docker. L'environnement de développement est assemblé grâce à docker-compose (cf docker/dev/docker-compose.yml).

Il comporte :

une base de donnée PostgreSQL contenant un jeu de donnée dossier de credit (postgresql://127.0.0.1:9032/db_b_gestion_credit)
une base de donnée MongoDB contenant un jeu de document ( liasse fiscale) (MongoDB://127.0.0.1::8087/catal)
une base de donnée PostgresSQL contenant un jeu de donnée user (postgresql://127.0.0.1:9032/db_b_user)


Lancement

Vous trouverez un fichier structure de la base de données dans le répertoire script du repertoire racine  ainsi qu'un jeu de donnée:

Le serveur PostgreSQL est configuré avec les paramètres par défaut : Host name/address : localhost Port : 5432 Username : Postgresql 

Déploiement

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


