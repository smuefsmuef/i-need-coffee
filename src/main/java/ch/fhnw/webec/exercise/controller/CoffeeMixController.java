package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@Validated
public class CoffeeMixController {

    private static class InvalidSearch extends RuntimeException {}
    private static class CoffeeMixNotFound extends RuntimeException {}
    private final CoffeeMixService coffeeMixService;
    private BeanService beanService;

    @Value("2")
    private int minSearchLength;

    public CoffeeMixController(CoffeeMixService coffeeMixService, BeanService beanService) {
        this.coffeeMixService = coffeeMixService;
        this.beanService = beanService;
    }

    @GetMapping("/coffeemixes")
    public String getCoffeeMixList(String search, Model model) {
        checkSearch(search);
//        model.addAttribute("coffeeMixList", coffeeMixService.getCoffeeMixList(search));
        return "coffeemixes";
    }

    private void checkSearch(String search) {
        if (search != null && search.length() < minSearchLength) {
            throw new InvalidSearch();
        }
    }

    @ExceptionHandler(InvalidSearch.class)
    @ResponseStatus(BAD_REQUEST)
    public String invalidSearch(Model model) {
//        model.addAttribute("coffeeMixList", coffeeMixService.getCoffeeMixList(null));
        model.addAttribute("errorMessage",
            "Search text must have at least %s characters".formatted(minSearchLength));
        return "coffeemixes";
    }

    @ExceptionHandler(CoffeeMixNotFound.class)
    @ResponseStatus(NOT_FOUND)
    public String notFound(Model model) {
//        model.addAttribute("coffeMixList", coffeeMixService.getCoffeeMixList(null));
        model.addAttribute("errorMessage", "Coffemix not found");
        return "coffeemixes";
    }
}
