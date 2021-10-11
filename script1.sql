SELECT * FROM copies
JOIN books on copies.BookID = books.ID
LEFT JOIN  loans ON loans.CopyID = copies.ID WHERE books.Name = "Globe" and loans.CheckoutDate is null or loans.ReturnedDate is not null
