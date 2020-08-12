package edu.wctc.streetfood;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MenuController {
    private MenuItem[] menuItemList;

    @PostConstruct
    private void initMenuData() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            menuItemList = mapper.readValue(Paths.get("menuItems.json").toFile(), MenuItem[].class);
        } catch (IOException e) {
            e.printStackTrace();
            menuItemList = new MenuItem[0];
        }
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/credits")
    public String showCredits() {
        return "credits";
    }

    @RequestMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("menuItems", menuItemList);
        return "menu";
    }
}
