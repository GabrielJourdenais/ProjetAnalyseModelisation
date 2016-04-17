--
-- Script de creation des tables
-- Application CLASSMEET
-- Auteur: Maxime Varin
-- Code permanent: VARM27108903
--

CREATE DATABASE CLASSMEET;

USE CLASSMEET;

CREATE TABLE Utilisateur (
codeUtilisateur VARCHAR(12),
motDePasse VARCHAR(8) NOT NULL,
prenom VARCHAR(30) NOT NULL,
nom VARCHAR(30) NOT NULL,
courriel VARCHAR(50),
typeUtilisateur VARCHAR(20),
CONSTRAINT pk_Utilisateur PRIMARY KEY(codeUtilisateur)
);

CREATE INDEX indNomUtilisateur ON Utilisateur(prenom, nom);

CREATE TABLE Cours (
sigle VARCHAR(7),
titre VARCHAR(50),
CONSTRAINT pk_Cours PRIMARY KEY(sigle)
);

CREATE TABLE GroupeCours (
noGroupeCours INTEGER,
session ENUM('H', 'E', 'A') NOT NULL,
annee INTEGER NOT NULL,
enseignant VARCHAR(12),
sigle VARCHAR(7),
CONSTRAINT pk_Groupe_Cours PRIMARY KEY(noGroupeCours,sigle),
CONSTRAINT fk_Groupe_Cours_Enseignant FOREIGN KEY(enseignant) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Groupe_Cours_Cours FOREIGN KEY(sigle) REFERENCES Cours(sigle)
ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE UtilisateurGroupeCours (
codePermanent VARCHAR(12),
noGroupeCours INTEGER,
sigle VARCHAR(7),
CONSTRAINT fk_Etudiant_Groupe_Cours_1 FOREIGN KEY(codePermanent) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_Etudiant_Groupe_Cours_2 FOREIGN KEY(noGroupeCours) REFERENCES GroupeCours(noGroupeCours)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Etudiant_Groupe_Cours_3 FOREIGN KEY(sigle) REFERENCES Cours(sigle)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT pk_Etudiant_Groupe_Cours PRIMARY KEY(codePermanent, sigle)
);

CREATE TABLE Message (
idMessage INTEGER NOT NULL AUTO_INCREMENT,
de VARCHAR(12) NOT NULL,
a VARCHAR(12) NOT NULL,
objet VARCHAR(30),
texte VARCHAR(100),
dateMessage VARCHAR(30),
CONSTRAINT pk_Message PRIMARY KEY(idMessage),
CONSTRAINT fk_Message_De FOREIGN KEY(de) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_Message_A FOREIGN KEY(a) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MessageRecus (
idMessage INTEGER,
codeUtilisateur VARCHAR(12) NOT NULL,
CONSTRAINT pk_MessageRecus PRIMARY KEY(idMessage),
CONSTRAINT fk_MessageRecus_ID FOREIGN KEY(idMessage) REFERENCES Message(idMessage)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_MessageRecus_Code FOREIGN KEY(codeUtilisateur) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MessageEnvoye (
idMessage INTEGER,
codeUtilisateur VARCHAR(12) NOT NULL,
CONSTRAINT pk_MessageEnvoye PRIMARY KEY(idMessage),
CONSTRAINT fk_MessageEnvoye_ID FOREIGN KEY(idMessage) REFERENCES Message(idMessage)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_MessageEnvoye_Code FOREIGN KEY(codeUtilisateur) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Equipe (
noEquipe INTEGER,
nomEquipe VARCHAR(10),
chefEquipe VARCHAR(12) NOT NULL,
sigle VARCHAR(7),
noGroupeCours INTEGER,
CONSTRAINT pk_Equipe PRIMARY KEY(noEquipe, sigle, noGroupeCours),
CONSTRAINT fk_Equipe_Etudiant FOREIGN KEY(chefEquipe) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Equipe_Cours FOREIGN KEY(sigle) REFERENCES Cours(sigle)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Equipe_Groupe_Cours FOREIGN KEY(noGroupeCours) REFERENCES GroupeCours(noGroupeCours)
ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE AccesFTP (
idDepot INTEGER,
noEquipe INTEGER,
motDePasse INTEGER NOT NULL,
CONSTRAINT pk_Depot PRIMARY KEY(idDepot),
CONSTRAINT fk_Depot_Equipe FOREIGN KEY(noEquipe) REFERENCES Equipe(noEquipe)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE EtudiantEquipe (
sigle VARCHAR(7),
noGroupeCours INTEGER,
noEquipe INTEGER,
codePermanent VARCHAR(12),
CONSTRAINT pk_Fichier PRIMARY KEY(sigle, codePermanent),
CONSTRAINT fk_Etudiant_Equipe_Cours FOREIGN KEY(sigle) REFERENCES Cours(sigle)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Etudiant_Equipe_Groupe_Cours FOREIGN KEY(noGroupeCours) REFERENCES GroupeCours(noGroupeCours)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Etudiant_Equipe_Equipe FOREIGN KEY(noEquipe) REFERENCES Equipe(noEquipe)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_Etudiant_Equipe_Etudiant FOREIGN KEY(codePermanent) REFERENCES Utilisateur(codeUtilisateur)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Evenement (
sigle VARCHAR(7),
noGroupeCours INTEGER,
noEquipe INTEGER,
nom VARCHAR(10),
description VARCHAR(30),
dateHeure DATETIME,
duree INTEGER,
lieu VARCHAR(30),
CONSTRAINT pk_Evenements PRIMARY KEY(sigle, noGroupeCours, noEquipe, dateHeure),
CONSTRAINT fk_Cours_Evenements FOREIGN KEY(sigle) REFERENCES Cours(sigle)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_GroupeCours_Evenements FOREIGN KEY(noGroupeCours) REFERENCES GroupeCours(noGroupeCours)
ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT fk_Equipe_Evenements FOREIGN KEY(noEquipe) REFERENCES Equipe(noEquipe)
ON DELETE CASCADE ON UPDATE CASCADE
);
