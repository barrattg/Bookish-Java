package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.AuthorPageModel;
import org.softwire.training.bookish.models.page.AuthorsPage;
import org.softwire.training.bookish.services.AuthorPageService;
import org.softwire.training.bookish.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/authorpage")
public class AuthorPageController {

    private final AuthorPageService authorPageService;

    @Autowired
    public AuthorPageController(AuthorPageService authorPageService) {
        this.authorPageService = authorPageService;
    }

    @RequestMapping("")
    ModelAndView deleteAuthor(@RequestParam int authorId) {
        List<Book> books = authorPageService.getAllAuthorBooks(authorId);

        AuthorPageModel authorPageModel = new AuthorPageModel();
        authorPageModel.setAuthor(authorPageService.GetAuthor(authorId));
        authorPageModel.setBooks(authorPageService.getAllAuthorBooks(authorId));

        return new ModelAndView("authorpage", "model", authorPageModel);
    }
}
