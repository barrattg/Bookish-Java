USE bookish;
SELECT Books.Name, Books.ISBN, Books.PublishDate, Authors.Name FROM Books
JOIN BooksToAuthors ON Books.ID = BooksToAuthors.BookID
JOIN Authors ON Authors.ID = BooksToAuthors.AuthorID;

SELECT * FROM Copies;
SELECT * FROM Loans;

