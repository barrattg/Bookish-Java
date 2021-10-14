package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
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
    ModelAndView search(@RequestParam(name = "searchCriteria") String searchCriteria) {

        System.out.println("Searching... " + searchCriteria);

        List<Book> bookResult = searchService.searchAll(searchCriteria, null);

        BookSystemModel bookSystemModel = new BookSystemModel();
        bookSystemModel.setBooks(bookResult);

        return new ModelAndView("book", "model", bookSystemModel);

        //SearchPageModel searchPageModel = new SearchPageModel();

        //return new ModelAndView("search", "model", searchPageModel);
    }

}