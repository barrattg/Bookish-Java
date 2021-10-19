Use bookish;
INSERT INTO Books SET Name='Invisible City', ISBN='9781407104027', PublishDate='2008-01-01';
INSERT INTO Books SET Name='Point Blanc', ISBN='9781406360202', PublishDate='2001-09-03';
INSERT INTO Books SET Name='Harry Potter and the Philosopher''s Stone', ISBN='9780747532743', PublishDate='1997-06-26';
INSERT INTO Books SET Name='Percy Jackson and the Lightning Thief', ISBN='978014134680', PublishDate='2005-05-21';
INSERT INTO Books SET Name='The Midnight Library', ISBN='9781786892737', PublishDate='2021-02-18';
INSERT INTO Books SET Name='Funnybones', ISBN='9780140565812', PublishDate='1999-07-17';
INSERT INTO Books SET Name='Good Omens', ISBN='9780552176729', PublishDate='1990-05-10';


INSERT INTO Authors SET Name='MG Harris';
INSERT INTO Authors SET Name='Anthony Horowitz';
INSERT INTO Authors SET Name='J. K. Rowling';
INSERT INTO Authors SET Name='Rick Riordan';
INSERT INTO Authors SET Name='Matt Haig';
INSERT INTO Authors SET Name='Allan Ahlberg';
INSERT INTO Authors SET Name='Neil Gaiman';
INSERT INTO Authors SET Name='Terry Pratchett';


INSERT INTO BooksToAuthors SET BookID=1, AuthorID=1;
INSERT INTO BooksToAuthors SET BookID=2, AuthorID=2;
INSERT INTO BooksToAuthors SET BookID=3, AuthorID=3;
INSERT INTO BooksToAuthors SET BookID=4, AuthorID=4;
INSERT INTO BooksToAuthors SET BookID=5, AuthorID=5;
INSERT INTO BooksToAuthors SET BookID=6, AuthorID=6;
INSERT INTO BooksToAuthors SET BookID=7, AuthorID=7;
INSERT INTO BooksToAuthors SET BookID=7, AuthorID=8;

INSERT INTO Copies SET BookID=1;
INSERT INTO Copies SET BookID=1;
INSERT INTO Copies SET BookID=1;
INSERT INTO Copies SET BookID=2;
INSERT INTO Copies SET BookID=2;
INSERT INTO Copies SET BookID=2; 
INSERT INTO Copies SET BookID=2; 
INSERT INTO Copies SET BookID=2; 
INSERT INTO Copies SET BookID=2; 
INSERT INTO Copies SET BookID=2; 
INSERT INTO Copies SET BookID=3; 
INSERT INTO Copies SET BookID=3; 
INSERT INTO Copies SET BookID=3; 
INSERT INTO Copies SET BookID=3; 
INSERT INTO Copies SET BookID=3; 
INSERT INTO Copies SET BookID=4; 
INSERT INTO Copies SET BookID=4; 
INSERT INTO Copies SET BookID=5;
INSERT INTO Copies SET BookID=5;
INSERT INTO Copies SET BookID=5;
INSERT INTO Copies SET BookID=5;
INSERT INTO Copies SET BookID=6;
INSERT INTO Copies SET BookID=6;
INSERT INTO Copies SET BookID=6;
INSERT INTO Copies SET BookID=6;
INSERT INTO Copies SET BookID=6;
INSERT INTO Copies SET BookID=6;
INSERT INTO Copies SET BookID=7;
INSERT INTO Copies SET BookID=7;
INSERT INTO Copies SET BookID=7;


INSERT INTO Users SET Name='Junior Thorne', Address='3 Sunnybank Close, Leigh-On-Sea,SS9 5SP'; 
INSERT INTO Users SET Name='Madison Dyer', Address='8 Kingsway Court, Ossett, WF5 8EG';
INSERT INTO Users SET Name='John Paul Johns', Address='11 Marechal Niel Avenue, Sidcup, DA15 7PB';
INSERT INTO Users SET Name='Christmas Hailey', Address='52 Janes Lane, Burgess Hill, RH15 0QR';
INSERT INTO Users SET Name='Elliot Granger', Address='Flat 2, 26 Church Street, Sheringham, NR26 8QS';

INSERT INTO Loans SET UserID='5', CopyID='10', CheckoutDate='2021-10-10', ExpectedReturnDate='2021-11-10', ReturnedDate=NULL;
INSERT INTO Loans SET UserID='1', CopyID='12', CheckoutDate='2021-03-05', ExpectedReturnDate='2021-04-05', ReturnedDate='2021-04-02';
INSERT INTO Loans SET UserID='3', CopyID='3', CheckoutDate='2021-06-10', ExpectedReturnDate='2021-07-10', ReturnedDate='2021-06-12';
INSERT INTO Loans SET UserID='2', CopyID='11', CheckoutDate='2021-01-04', ExpectedReturnDate='2021-02-04', ReturnedDate='2021-01-29';
