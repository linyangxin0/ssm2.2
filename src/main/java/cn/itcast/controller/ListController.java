package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.List;


@Controller
@RequestMapping("/List")
public class ListController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public @ResponseBody List<Account> finAll() {
        return accountService.findAll();
    }

    @RequestMapping("/addUser")
    public @ResponseBody void addUser(Account account){
        accountService.addUser(account);
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public void delUser(@RequestParam(value="userIds[]") List<Integer> userIds){
        for (int i=0;i<userIds.size();i++){
            accountService.delUser(userIds.get(i));
        }
    }

    @RequestMapping("/editUser")
    public @ResponseBody void editUser(Account account){
        accountService.updateUserNameById(account);
        accountService.updateSexById(account);
        accountService.updateAgeById(account);
        accountService.updateMobilePhoneById(account);
        accountService.updateAddressById(account);
    }
}
