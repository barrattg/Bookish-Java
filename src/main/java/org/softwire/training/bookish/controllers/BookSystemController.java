package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.BookSystemModel;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookSystemController {


    private final BookService bookService;

    @Autowired
    public BookSystemController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("")
    ModelAndView bookSystem(@RequestParam(value = "redirectbook", defaultValue = "0") int redirectbook) {

        List<Book> allBooks = bookService.getAllBooks();
        
        //System.out.println(bookService.getBookFromId(bookService.getBookFromCopy(redirectbook)));

        BookSystemModel bookSystemModel = new BookSystemModel();
        bookSystemModel.setRedirectBook(redirectbook==0
                ? null
                : bookService.getBookFromId(bookService.getBookFromCopy(redirectbook)));
        bookSystemModel.setBooks(allBooks);

        return new ModelAndView("book", "model", bookSystemModel);
    }


    @RequestMapping("/add-book")
    RedirectView addBook(@ModelAttribute Book book) {

        bookService.addBook(book);

        return new RedirectView("/book");
    }

    @RequestMapping("/remove-book")
    RedirectView removeBook(@RequestParam int bookId) {

        bookService.removeBook(bookId);

        return new RedirectView("/book");
    }




}
