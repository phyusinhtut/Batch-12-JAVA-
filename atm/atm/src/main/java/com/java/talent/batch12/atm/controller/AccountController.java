package com.java.talent.batch12.atm.controller;


import com.java.talent.batch12.atm.model.Account;
import com.java.talent.batch12.atm.request.LoginInfo;
import com.java.talent.batch12.atm.request.RegisterInfo;
import com.java.talent.batch12.atm.request.ServiceInfo;
import com.java.talent.batch12.atm.service.AccountServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AccountController {

    private final AccountServices accountService;

    public AccountController(AccountServices accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("message", "ATM Program");
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterInfo registerInfo = new RegisterInfo();
        model.addAttribute("registerInfo", registerInfo);
        return "register";
    }

    @PostMapping("/registerAccount")
    public String registerAccount(Model model, @ModelAttribute RegisterInfo registerInfo) {
        accountService.createAccount(registerInfo.getName(), registerInfo.getPassword(), registerInfo.getEmail(),registerInfo.getAddress());
        model.addAttribute("message", "Account created successfully!");
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginInfo loginInfo = new LoginInfo();
        model.addAttribute("loginInfo", loginInfo);
        return "login";
    }

    @PostMapping("/loginAccount")
    public String loginAccount(Model model, @ModelAttribute LoginInfo loginInfo, HttpSession session) {

           boolean isSuccess = accountService.loginAccount(loginInfo.getName(),loginInfo.getPassword());
           if(isSuccess)
           {
               session.setAttribute("user", loginInfo.getName());
               return "redirect:/dashboard";
           }
           else
           {
               model.addAttribute("loginError", "UserName or Password incorrect!");
               return "login";
           }
    }

    @GetMapping("/dashboard")
    public String showInfo(Model model, HttpSession session) {
        String username = (String) session.getAttribute("user");
        if (username == null) {
            return "redirect:/login";
        }
        Account account = accountService.getAccountByUserName(username);
        model.addAttribute("info", account);
        model.addAttribute("serviceInfo", new ServiceInfo());

        return "dashboard";
    }


}

