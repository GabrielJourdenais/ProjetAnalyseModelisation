--
-- Script de remplissage
-- Application CLASSMEET
-- Auteur: Maxime Varin
-- Code permanent: VARM27108903
--

USE CLASSMEET;

-- Insertion dans la table Utilisateur
INSERT INTO Utilisateur VALUES('100', 'aaaa', 'Bastien', 'Paul', 'VAR000');
INSERT INTO Utilisateur VALUES('101', 'bbbb', 'Bastie', 'Paula', 'BER001');
INSERT INTO Utilisateur VALUES('102', 'cccc', 'Bast', 'Clau', 'CLR002');


-- Insertion dans la table Employe
INSERT INTO Employe VALUES('100', 'Administrateur');
INSERT INTO Employe VALUES('101', 'Enseignant');
INSERT INTO Employe VALUES('102', 'Enseignant');

-- Insertion dans la table Etudiant
INSERT INTO Etudiant VALUES('100', 'fe000', 'Coequipier');
INSERT INTO Etudiant VALUES('101', 'fe001', 'Chef');
INSERT INTO Etudiant VALUES('102', 'fe0002', 'Coequipier');

-- Insertion dans la table Cours
INSERT INTO Cours VALUES('INF0000', 'prog1');
INSERT INTO Cours VALUES('INF0001', 'prog2');
INSERT INTO Cours VALUES('INF0002', 'archi');

-- Insertion dans la table GroupeCours
INSERT INTO GroupeCours VALUES(400, 'H', 2016, '100', 'INF0000');
INSERT INTO GroupeCours VALUES(401, 'E', 2017, '101', 'INF0001');
INSERT INTO GroupeCours VALUES(402, 'A', 2018, '102', 'INF0002');

-- Insertion dans la table EtudiantGroupeCours
INSERT INTO EtudiantGroupeCours VALUES('100', 400, 'INF0000');
INSERT INTO EtudiantGroupeCours VALUES('101', 401, 'INF0001');
INSERT INTO EtudiantGroupeCours VALUES('102', 402, 'INF0002');

-- Insertion dans la table Message
INSERT INTO Message(codeUtilisateur, de, a, objet, texte) VALUES('100', 'aa', 'bb', 'bateau', 'je suis');
INSERT INTO Message(codeUtilisateur, de, a, objet, texte) VALUES('101', 'ab', 'bc', 'mateau', 'tu suis');
INSERT INTO Message(codeUtilisateur, de, a, objet, texte) VALUES('102', 'de', 'cc', 'chateau', 'il suis');

-- Insertion dans la table Equipe
INSERT INTO Equipe VALUES(600, 'dd', '100', 'INF0000', 400);
INSERT INTO Equipe VALUES(601, 'ee', '101', 'INF0001', 401);
INSERT INTO Equipe VALUES(602, 'ff', '102', 'INF0002', 402);

-- Insertion dans la table AccesFTP
INSERT INTO AccesFTP VALUES(800, 600, 1010);
INSERT INTO AccesFTP VALUES(801, 601, 2020);
INSERT INTO AccesFTP VALUES(802, 602, 3030);

-- Insertion dans la table EtudiantEquipe
INSERT INTO EtudiantEquipe VALUES('INF0000', 400, 600, '100');
INSERT INTO EtudiantEquipe VALUES('INF0001', 401, 601, '101');
INSERT INTO EtudiantEquipe VALUES('INF0002', 402, 602, '102');
