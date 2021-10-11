Use bookish;
DROP TABLE IF EXISTS Books, Authors, Users, Loans, BooksToAuthors, Copies;
Create table Books(
ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Name varchar (255) NOT NULL,
ISBN varchar (13) NOT NULL,
PublishDate date NOT NULL
);
Create table Authors(
ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Name varchar (255) NOT NULL

);
Create table Users(
ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Name varchar (255),
Address varchar (255)
);

Create table Loans(
ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
UserID INT NOT NULL,
Foreign Key (UserID) References Users (ID),
BookID INT,
Foreign Key (BookID) References Books (ID),
CheckoutDate date ,
ExpectedReturnDate date

);

Create table BooksToAuthors(
BookID INT NOT NULL,
AuthorID INT NOT NULL,
Foreign Key (BookID) References Books (ID),
Foreign Key (AuthorID) References Authors (ID)


);

Create table Copies(
CopyID int AUTO_INCREMENT PRIMARY KEY,
BookID int,
Foreign Key (BookID) References Books (ID)

);