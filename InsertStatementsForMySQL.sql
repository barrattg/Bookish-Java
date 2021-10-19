use bookish;

Insert INTO books(ID, Name, ISBN, PublishDate)
VALUES 
('1', "Invisible City", '9781407104027', '2008-02-04'),
('2', "Point Blanc", '9781406360202', '2001-09-03'),
('3', "Harry Potter and the Philosopher's Stone", '9780747532743', '1997-06-26'),
('4', "Percy Jackson and the Lightning Thief", '978014134680', '2005-05-21'),
('5', "The Midnight Library", '9781786892737', '2021-02-18'),
('6', "Funnybones", '9780140565812', '1999-07-17'),
('7', "Good Omens", '9780552176729', '1990-05-10'),
('8', "Harry Potter and the Chamber of Secrets", '9781408855669', '1998-07-02'),
('9', "Harry Potter and the Prisoner of Azkaban", '9781408855676', '1999-07-08'),
('10', "Harry Potter and the Goblet of Fire", '9781408855683', '2000-07-08');

Insert INTO authors (ID, Name)
VALUES
('1', "MG Harris"),
('2', "Anthony Horowitz"),
('3', "J. K. Rowling"),
('4', "Rick Riordan"),
('5', "Matt Haig"),
('6', "Allan Ahlberg"),
('7', "Neil Gaiman"),
('8', "Terry Pratchett");

Insert INTO users (ID, Name, Address)
VALUES
('1',  "Patrick Lozano", "98 Pattinson Drive, Plymouth"),
('2', "Scott Huffman", "Old Hycemoor School, Bootle Station"),
('3', "Xander Cox", "1 Bempton Place, Bradford"),
('4', "Elias Wilcox", "28 The Park, Harwell"),
('5', "Marc Cook", "6 Cowper Close, Warwick"),
('6', "Aleena Bullock", "Stonelea, High Street, Purton"),
('7', "Cara Vargas", "12 Leighton Road, Birkenhead"),
('8', "Jodie Palmer", "164 Castle Road West, Oldbury"),
('9', "Linda Edwards", "7 Caldwell Close, Astley"),
('10', "Amie Gillespie", "Rose Lawn, Tir Y Cwm Lane, Risca");

Insert INTO BooksToAuthors ( BookID, AuthorID)
VALUES
('1','1'),
('2', '2'),
('3', '3'),
('4', '4'),
('5', '5'),
('6', '6'),
('7', '7'),
('7', '8'),
('8', '3'),
('9', '3'),
('10', '3');

Insert INTO Copies (ID, BookID)
VALUES
('1', '1'),
('2', '1'),
('3', '1'),
('4', '1'),
('5', '2'),
('6', '2'),
('7', '3'),
('8', '4'),
('9', '4'),
('10', '5'),
('11', '6'),
('12', '6'),
('13', '7'),
('14', '8'),
('15', '8'),
('16', '8'),
('17', '9'),
('18', '9'),
('19', '10');

Insert INTO loans (ID, UserID, CopyID, ReturnedDate)
VALUES
('1', '1', '1', null), 
('2','3', '2', '2021-10-11');


