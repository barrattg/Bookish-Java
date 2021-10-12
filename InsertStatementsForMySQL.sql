Insert INTO books(ID, Name, ISBN, PublishDate)
VALUES 
('1', "The Golden Compass", '9781234567897', '2001-05-05'),
('2', "Who Shot Roger Rabbit?", '9781234567896', '2000-06-02'),
('3', "A New Hope", '9781234567895', '1987-05-04'),
('4', "A Clockwork Orange", '9781234567894', '1994-02-08'),
('5', "One Flew over the Cuckoo's Nest", '9781234567893', '1994-05-06'),
('6', "Medieval History", '9781234567892', '2001-06-30'),
('7', "Flute Bard", '9781234567891', '1976-01-01'),
('8', "Shinobi", '9781234567890', '2010-06-20'),
('9', "Yet Another Book Title", '9781234567889', '2021-10-12'),
('10', "Running out of Ideas", '9781234567888', '2020-05-05');

Insert INTO authors (ID, Name)
VALUES
('1', "Ida Merritt"),
('2', "Bertha Chambers"),
('3', "Alice Frost"),
('4', "Emma Ball"),
('5', "Minnie Hall"),
('6', "George Beard"),
('7', "William Sherman"),
('8', "John Mendoza"),
('9', "Frank West"),
('10', "Henry Hurst");

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
('2', '10'),
('3', '2'),
('4', '9'),
('5', '3'),
('6', '7'),
('7', '4'),
('8', '5'),
('9', '6'),
('10', '8');

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


