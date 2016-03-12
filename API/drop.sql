--
-- Script de nettoyage
-- Auteur: Maxime Varin
-- Code permanent: VARM27108903
--

USE CLASSMEET;

DROP INDEX indNomUtilisateur ON Utilisateur;

-- Suppression des tables
DROP TABLE EtudiantEquipe;
DROP TABLE AccesFTP;
DROP TABLE Equipe;
DROP TABLE Message;
DROP TABLE EtudiantGroupeCours;
DROP TABLE GroupeCours;
DROP TABLE Cours;
DROP TABLE Etudiant;
DROP TABLE Employe;
DROP TABLE Utilisateur;

-- Suppression de la base de donnees
DROP DATABASE ClassMeet;
