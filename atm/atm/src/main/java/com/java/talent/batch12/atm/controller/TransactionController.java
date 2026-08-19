package com.java.talent.batch12.atm.controller;

import com.java.talent.batch12.atm.model.Account;
import com.java.talent.batch12.atm.model.Transaction;
import com.java.talent.batch12.atm.request.ServiceInfo;
import com.java.talent.batch12.atm.service.AccountServices;
import com.java.talent.batch12.atm.service.TransactionServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class TransactionController {

    private final TransactionServices transactionServices;
    private final AccountServices accountServices;

    public TransactionController(TransactionServices transactionServices, AccountServices accountServices) {
        this.transactionServices = transactionServices;
        this.accountServices = accountServices;
    }

    @PostMapping("/dashboardDeposit")
    public String deposit(Model model, @ModelAttribute ServiceInfo serviceInfo, HttpSession session,  RedirectAttributes redirectAttributes)
    {
        String username = (String) session.getAttribute("user");
        if(username == null)
        {
            return "redirect:/login";
        }
        try
        {
            if(serviceInfo.getAmount() <= 0) {
                redirectAttributes.addFlashAttribute("message", "Amount must be greater than 0");
                return "redirect:/dashboard";
            }
            transactionServices.deposit(username,serviceInfo.getAmount());
            redirectAttributes.addFlashAttribute("message", "Deposit successful!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Deposit unsuccessful!");
        }
        return "redirect:/dashboard";
    }

    @PostMapping("/dashboardWithdraw")
    public String withdraw(Model model, @ModelAttribute ServiceInfo serviceInfo, HttpSession session,  RedirectAttributes redirectAttributes)
    {
        String username = (String) session.getAttribute("user");
        Account account = accountServices.getAccountByUserName(username);
        if(username == null)
        {
            return "redirect:/login";
        }
        try
        {
            if(serviceInfo.getAmount() <= 0) {
                redirectAttributes.addFlashAttribute("message", "Amount must be greater than 0!");
                return "redirect:/dashboard";
            }
            if(serviceInfo.getAmount() > account.getBalance()) {
                redirectAttributes.addFlashAttribute("message", "Insufficient Amount!");
                return "redirect:/dashboard";
            }
            transactionServices.withdraw(username,serviceInfo.getAmount());
            redirectAttributes.addFlashAttribute("message", "Withdraw successful!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Withdraw unsuccessful!");
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/history")
    public String showAllTransactions(Model model, HttpSession session) {
        String username = (String) session.getAttribute("user");

        if (username == null) {
            return "redirect:/login";
        }
        Account account = accountServices.getAccountByUserName(username);
        List<Transaction> transactions = transactionServices.getTransactionsByAccountId(account.getAccountId());
        model.addAttribute("transactions", transactions);
        return "history";
    }



}
