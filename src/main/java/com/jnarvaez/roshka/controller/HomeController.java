package  com.jnarvaez.roshka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import  com.jnarvaez.roshka.interfaces.HomeControllerInterface;

@Controller
public class HomeController implements HomeControllerInterface {
    
    @Override
    @GetMapping("/")
    public String home() {
        return "html/index.html";
    }
}
