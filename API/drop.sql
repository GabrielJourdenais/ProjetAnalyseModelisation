--
-- Script de nettoyage
-- Auteur: Maxime Varin
-- Code permanent: VARM27108903
--
USE CLASSMEET;

DROP INDEX indNomUtilisateur ON Utilisateur;

-- Suppression des tables
DROP TABLE Evenement;
DROP TABLE EtudiantEquipe;
DROP TABLE AccesFTP;
DROP TABLE Equipe;
DROP TABLE MessageEnvoye;
DROP TABLE MessageRecus;
DROP TABLE Message;
DROP TABLE UtilisateurGroupeCours;
DROP TABLE GroupeCours;
DROP TABLE Cours;
DROP TABLE Utilisateur;


-- Suppression de la base de donnees
DROP DATABASE ClassMeet;