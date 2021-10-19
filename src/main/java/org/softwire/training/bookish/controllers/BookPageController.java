package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Copy;
import org.softwire.training.bookish.models.page.BookPageModel;
import org.softwire.training.bookish.services.BookPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.print.attribute.standard.Copies;
import java.util.List;

@Controller
@RequestMapping("/bookpage")
public class BookPageController {

    private final BookPageService bookPageService;

    @Autowired
    public BookPageController(BookPageService bookPageService) {this.bookPageService = bookPageService; }

    @RequestMapping("")
    ModelAndView bookPage(@RequestParam int bookId) {

        List<Copy> allCopies = bookPageService.getAllCopies(bookId);

        BookPageModel bookPageModel = new BookPageModel();
        bookPageModel.SetBook(bookPageService.GetBook(bookId));
        bookPageModel.setCopies(allCopies);

        return new ModelAndView("bookpage", "model", bookPageModel);

    }




}
