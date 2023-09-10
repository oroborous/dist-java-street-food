package edu.wctc.streetfood;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class MenuController {
    @Value("classpath:menuItems.json")
    private Resource menuItems;

    private MenuItem[] menuItemArray;

    @PostConstruct
    private void initMenuData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            menuItemArray = mapper.readValue(
                    menuItems.getFile(),
                    MenuItem[].class);
        } catch (IOException e) {
            e.printStackTrace();
            menuItemArray = new MenuItem[0];
        }
    }

    @RequestMapping("/credits")
    public String showCredits() {
        return "credits";
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("menuItems", menuItemArray);
        return "menu";
    }
}
