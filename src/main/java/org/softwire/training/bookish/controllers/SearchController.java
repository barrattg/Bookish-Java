package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.BookToAuthor;
import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.BookSystemModel;
import org.softwire.training.bookish.models.page.SearchPageModel;
import org.softwire.training.bookish.services.AuthorService;
import org.softwire.training.bookish.services.SearchService;
import org.softwire.training.bookish.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping("")
    ModelAndView search() {
        SearchPageModel searchPageModel = new SearchPageModel();
        return new ModelAndView("search", "model", searchPageModel);
    }

    @RequestMapping("/display")
    ModelAndView display(@RequestParam(name = "searchBooks") String searchBooks, String searchAuthors) {

        System.out.println("Searching... " + searchBooks + searchAuthors);

        List<Book> bookResult = searchService.searchAll("%" + searchBooks + "%", "%" + searchAuthors + "%"); // find books

        BookSystemModel bookSystemModel = new BookSystemModel();
        bookSystemModel.setBooks(bookResult); // put list of books in model

        return new ModelAndView("display", "model", bookSystemModel); // links to book.html & provide data
    }
}