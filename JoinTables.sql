USE bookish;
SELECT Books.Name, Books.ISBN, Books.PublishDate, Authors.Name FROM Books
JOIN BooksToAuthors ON Books.ID = BooksToAuthors.BookID
JOIN Authors ON Authors.ID = BooksToAuthors.AuthorID
JOIN copies ON Books.ID = copies.BookID
ORDER BY Books.Name asc;

SELECT * FROM Copies;
SELECT * FROM Loans;

