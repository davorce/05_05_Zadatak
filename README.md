upit u SQLu

CREATE PROCEDURE ObrisiDrzave @minId INT
AS
BEGIN
    DELETE FROM Drzava WHERE IDDrzava >= @minId
END
