-- @block

CREATE TABLE Vendeg
(
  Keresztnev INT NOT NULL,
  Vezeteknev INT NOT NULL,
  Ev INT NOT NULL,
  Honap INT NOT NULL,
  Nap INT NOT NULL,
  Iranyitoszam INT NOT NULL,
  Varos INT NOT NULL,
  Utca INT NOT NULL,
  Hazszam INT NOT NULL,
  id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Konyv
(
  id INT NOT NULL,
  Cim VARCHAR(50) NOT NULL,
  KiadasEve INT NOT NULL,
  Kiado VARCHAR(50) NOT NULL,
  Szerzo VARCHAR(40) NOT NULL,
  vendeg_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (vendeg_id) REFERENCES Vendeg(id)
);

-- @block
INSERT INTO vendeg (Keresztnev, Vezeteknev, Ev, Honap, Nap, Iranyitoszam, Varos, Utca, Hazszam, id) 
VALUES ('Kovács', 'Dániel', 1990, 1, 1, 1111, 'Budapest', 'Kossuth Lajos utca', 1, 1);