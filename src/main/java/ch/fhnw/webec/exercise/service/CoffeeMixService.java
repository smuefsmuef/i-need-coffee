package ch.fhnw.webec.exercise.service;

import ch.fhnw.webec.exercise.dto.*;
import ch.fhnw.webec.exercise.model.*;
import ch.fhnw.webec.exercise.repositories.*;
import ch.fhnw.webec.exercise.util.*;
import org.springframework.stereotype.*;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Locale.ROOT;
import static java.util.stream.Collectors.toList;

@Service
public class CoffeeMixService {
    private final CoffeeMixRepository coffeeMixRepository;

    public CoffeeMixService(CoffeeMixRepository coffeeMixRepository) {this.coffeeMixRepository = coffeeMixRepository;}

    public long countCoffeeMixes() {return this.coffeeMixRepository.count();}

    public CoffeeMix addCoffeeMix(CoffeeMixDto coffeeMixDto) {
        var coffeeMix = new CoffeeMix();
        new CoffeeMixMapper().mapToCoffeeMix(coffeeMix, coffeeMixDto);
        return add(coffeeMix);
    }

    CoffeeMix add(CoffeeMix coffeeMix) {
        return coffeeMixRepository.save(coffeeMix);
    }

    public void update(CoffeeMix coffeeMix) {coffeeMixRepository.save(coffeeMix);}

    public void deleteCoffeeMixById(int id) {coffeeMixRepository.deleteById(id);}

    public CoffeeMixRepository getCoffeeMixRepository() {return coffeeMixRepository;}

    /*TODO: add method "getCoffeeMixList"*/

}
