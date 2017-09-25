package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import services.ContactServiceImpl;

import java.util.ArrayList;

@RestController
public class PhoneBookController {

    @RequestMapping("/")
    public String sayHello() {
        return "phoneBook";
    }

}
