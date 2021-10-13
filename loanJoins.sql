use bookish;
INSERT INTO loans (UserID, CopyID)
SELECT  1, copies.ID 
FROM copies   
JOIN books ON books.ID = copies.BookID
LEFT OUTER JOIN loans ON copies.ID = loans.CopyID
WHERE Books.Name = 'A New Hope' AND (loans.UserID IS null or loans.ReturnedDate is not null)
limit 1
;
