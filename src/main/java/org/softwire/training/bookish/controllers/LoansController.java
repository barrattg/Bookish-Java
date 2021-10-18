package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.page.LoansModel;
import org.softwire.training.bookish.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoansController {

    private final LoansService loansService;

    @Autowired
    public LoansController(LoansService loansService) {this.loansService = loansService; }

    @RequestMapping("")
    ModelAndView loans() {

        List<Loan> allLoans = loansService.getAllLoans();

        LoansModel loansModel = new LoansModel();
        loansModel.setLoans(allLoans);

        return new ModelAndView("loans", "model", loansModel);

    }

}
