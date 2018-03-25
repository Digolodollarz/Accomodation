package tech.diggle.apps.accomodation.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tech.diggle.apps.accomodation.house.House;
import tech.diggle.apps.accomodation.house.HouseService;
import tech.diggle.apps.accomodation.user.User;
import tech.diggle.apps.accomodation.user.UserService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @RequestMapping("/")
    public ModelAndView Home() {
        ModelAndView index = new ModelAndView("index");
        List<House> houses = houseService.get(0, 10);
        index.addObject("houses", houses);
        return index;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")")
                .addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}