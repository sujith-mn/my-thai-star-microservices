-- This is the SQL script for setting up the DDL for the h2 database
-- In a typical project you would only distinguish between main and test for flyway SQLs
-- However, in this sample application we provde support for multiple databases in parallel
-- You can simply choose the DB of your choice by providing -Pmysql, -Ppostgresql, ... in your maven build

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;

-- *** Table ***
CREATE TABLE "Table" (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  seatsNumber INTEGER NOT NULL,
  CONSTRAINT PK_Table PRIMARY KEY(id)
);

-- *** Booking ***
CREATE TABLE Booking (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  idUser BIGINT,
  name VARCHAR (255) NOT NULL,
  bookingToken VARCHAR (255),
  comment VARCHAR (4000),
  email VARCHAR(255) NOT NULL,
  bookingDate TIMESTAMP NOT NULL,
  expirationDate TIMESTAMP,
  creationDate TIMESTAMP,
  canceled BOOLEAN NOT NULL DEFAULT ((0)) ,
  bookingType INTEGER,
  idTable BIGINT,
  idOrder BIGINT,
  assistants INTEGER,
  CONSTRAINT PK_Booking PRIMARY KEY(id),
  --CONSTRAINT FK_Booking_idUser FOREIGN KEY(idUser) REFERENCES User(id) NOCHECK,
  CONSTRAINT FK_Booking_idTable FOREIGN KEY(idTable) REFERENCES "Table"(id) NOCHECK
);

-- *** InvitedGuest ***
CREATE TABLE InvitedGuest (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  idBooking BIGINT NOT NULL,
  guestToken VARCHAR (255),
  email VARCHAR (60),
  accepted BOOLEAN,
  modificationDate TIMESTAMP,
  idOrder BIGINT,
  CONSTRAINT PK_InvitedGuest PRIMARY KEY(id),
  CONSTRAINT FK_InvitedGuest_idBooking FOREIGN KEY(idBooking) REFERENCES Booking(id) NOCHECK
);

-- *** BinaryObject (BLOBs) ***
CREATE TABLE BinaryObject (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  content BLOB(2147483647),
  filesize BIGINT NOT NULL,
  mimeType VARCHAR(255),
  PRIMARY KEY (ID)
);

-- *** RevInfo (Commit log for envers audit trail) ***
CREATE TABLE RevInfo(
  id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  "timestamp" BIGINT NOT NULL,
  userLogin VARCHAR(255)
);


