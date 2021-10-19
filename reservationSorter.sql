select Copies.ID, LoanedDate, ReturnedDate from copies
join books on books.ID = copies.BookID
LEFT outer JOIN loans on copies.ID = loans.CopyID
where loans.ID IN (Select max(ID) From loans group by CopyID) OR LoanedDate is Null;
