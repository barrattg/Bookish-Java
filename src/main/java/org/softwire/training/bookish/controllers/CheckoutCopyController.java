package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.page.CheckoutCopyModel;
import org.softwire.training.bookish.services.CheckoutCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/checkoutCopy")
public class CheckoutCopyController {

    private final CheckoutCopyService checkoutCopyService;


    @Autowired
    public CheckoutCopyController(CheckoutCopyService checkoutCopyService) {this.checkoutCopyService =checkoutCopyService; }

    @RequestMapping("")
    ModelAndView checkoutCopy() {


        CheckoutCopyModel checkoutCopyModel = new CheckoutCopyModel();
        checkoutCopyModel.setCopy(checkoutCopyModel.getCopy());


        return new ModelAndView("checkoutCopy", "model", checkoutCopyModel);

    }
    @RequestMapping("/createReservation")
    RedirectView createReservation(@RequestParam int copyId, int userId) {

        checkoutCopyService.createReservation(copyId,userId);

        return new RedirectView("/book");
    }





}
