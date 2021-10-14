package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.SearchPageModel;
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

    @Autowired
    public SearchController() {}

    @RequestMapping("")
    ModelAndView search(@ModelAttribute String searchCriteria) {

        System.out.println("Searching... " + searchCriteria);

        SearchPageModel searchPageModel = new SearchPageModel();

        return new ModelAndView("search", "model", searchPageModel);
    }

}