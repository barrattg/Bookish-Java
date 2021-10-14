package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.page.AuthorsPage;
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
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("")
    ModelAndView aboutUs() {

        List<Author> allAuthors = authorService.getAllAuthors();

        AuthorsPage authorPageModel = new AuthorsPage();
        authorPageModel.setAuthors(allAuthors);

        return new ModelAndView("author", "model", authorPageModel);
    }

    @RequestMapping("/add-author")
    RedirectView addAuthor(@ModelAttribute Author author) {

        authorService.addAuthor(author);

        return new RedirectView("/authors");
    }

    @RequestMapping("/delete-author")
    RedirectView deleteAuthor(@RequestParam int authorId) {
        System.out.println(authorId);
        authorService.deleteAuthor(authorId);

        return new RedirectView("/authors");
    }
}
