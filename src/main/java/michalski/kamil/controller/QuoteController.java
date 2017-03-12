package michalski.kamil.controller;

import michalski.kamil.bean.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/quote")
public class QuoteController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public String generateQuote(Model model) {
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters" +
                ".cfapps.io/api/random", Quote.class);
        model.addAttribute("quote", quote);
        return "quote";
    }
}
