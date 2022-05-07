package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.*;
import ch.fhnw.webec.exercise.repositories.*;
import ch.fhnw.webec.exercise.service.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.apache.tomcat.util.net.openssl.ciphers.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import javax.validation.*;
import java.util.*;


@RequestMapping(path = "/api/coffeemix", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@Tag(name = "coffeemix API", description = "provides crud support for coffeemix entities")
public class RESTCoffeeMixController {

    private final CoffeeMixService coffeeMixService;
    private BeanService beanService;
    private final CoffeeMixRepository coffeeMixRepository;
    private final BeanRepository beanRepository;
    private final RatingRepository ratingRepository;

    public RESTCoffeeMixController(CoffeeMixService coffeeMixService, BeanService beanService, CoffeeMixRepository coffeeMixRepository, BeanRepository beanRepository, RatingRepository ratingRepository) {
        this.coffeeMixService = coffeeMixService;
        this.beanService = beanService;
        this.coffeeMixRepository = coffeeMixRepository;
        this.beanRepository = beanRepository;
        this.ratingRepository = ratingRepository;
    }


    // GET All Coffee Mix
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CoffeeMix>> findAll() {
        return ResponseEntity.ok().body(this.coffeeMixRepository.findAll());
    }

    // GET a Coffee Mix
    @ApiResponse(responseCode = "404", content = @Content)
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CoffeeMix.class)))
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<CoffeeMix> findById(@PathVariable int id) {
        var coffeeMix = this.coffeeMixRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(coffeeMix);
    }


    // POST a Coffee Mix
    @ApiResponse(responseCode = "400", content = @Content, description = "The coffeemix in the request body contains validation errors.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CoffeeMix.class)))
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoffeeMix> addCoffeeMix(@Valid @RequestBody CoffeeMix coffeeMix, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.coffeeMixRepository.save(coffeeMix));
    }

    // PUT a Coffee Mix
    @ApiResponse(responseCode = "404", content = @Content)
    @ApiResponse(responseCode = "400", content = @Content, description = "The coffeeMix in the request body contains validation errors.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CoffeeMix.class)))
    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoffeeMix> updateCoffeeMix(@PathVariable int id, @Valid @RequestBody CoffeeMix coffeeMix, BindingResult bindingResult) {
        if (!this.coffeeMixRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        coffeeMix.setId(id);

        return ResponseEntity.ok(this.coffeeMixRepository.save(coffeeMix));
    }

    // DELETE a Coffee Mix
    @ApiResponse(responseCode = "404", content = @Content)
    @ApiResponse(responseCode = "204", content = @Content)
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCoffeeMix(@PathVariable int id) {
        if (!this.coffeeMixRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.coffeeMixRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(path = "{id}/ratings", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> findRatingsByCoffeeMix(@PathVariable int id) {
        return ResponseEntity.ok().body(this.ratingRepository.findByCoffeeMixId(id));
    }

    @ApiResponse(responseCode = "404", content = @Content)
    @ApiResponse(responseCode = "403", content = @Content)
    @ApiResponse(responseCode = "400", content = @Content, description = "The rating in the request body contains validation errors.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Rating.class)))
    @RequestMapping(path = "{id}/ratings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> addCoffeeMixRating(@PathVariable int id, @Valid @RequestBody Rating rating, BindingResult bindingResult, Authentication authentication) {
        var coffeeMix = this.coffeeMixRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

//        can still be implemented if necessary
//        if (this.badWordService.containsBadWords(rating.getReview())) {
//            bindingResult.addError(new FieldError("rating", "comment", "Your comment contains bad words, please watch your language!"));
//        }

        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            Document.p
//            rating.setUser((User) this.userService.loadUserByUsername(authentication.getName()));
//            rating.setCoffeeMix(coffeeMix);

            return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingRepository.save(rating));
        }
    }

}
