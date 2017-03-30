package by.stas.best.practise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleService {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public ModelAndView serviceProcess(ModelAndView model) {
        System.out.println("I am here at service process");
        model.setViewName("index");
        model.addObject("message", "WE MADE BABY_2!!!");
        return model;
    }

}
