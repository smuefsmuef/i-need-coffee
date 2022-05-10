package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.*;
import ch.fhnw.webec.exercise.repository.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;
import javax.validation.*;
import java.util.*;

@RequestMapping(path = "/api/coffeemixes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@Tag(name = "Coffeemixes API", description = "Provides crud support for coffeemix entities")
public class RESTCoffeeMixController {

    private final CoffeeMixRepository coffeeMixRepository;
    private final RatingRepository ratingRepository;

    public RESTCoffeeMixController(CoffeeMixRepository coffeeMixRepository, RatingRepository ratingRepository) {
        this.coffeeMixRepository = coffeeMixRepository;
        this.ratingRepository = ratingRepository;
    }

    // Get all Coffee Mixes
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CoffeeMix>> findAll() {
        return ResponseEntity.ok().body(this.coffeeMixRepository.findAll());
    }

    // Get one Coffee Mix by id
    @ApiResponse(responseCode = "404", content = @Content)
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CoffeeMix.class)))
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<CoffeeMix> findById(@PathVariable int id) {
        var coffeeMix = this.coffeeMixRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(coffeeMix);
    }

    // Add a new Coffee Mix
    @ApiResponse(responseCode = "400", content = @Content, description = "The coffeemix in the request body contains validation errors.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CoffeeMix.class)))
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoffeeMix> addCoffeeMix(@Valid @RequestBody CoffeeMix coffeeMix, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.coffeeMixRepository.save(coffeeMix));
    }

    // Update a Coffee Mix by Id
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

    // Delete a Coffee Mix by Id
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



    // Get Ratings of a Coffee Mix by id
    @RequestMapping(path = "{id}/ratings", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> findRatingsByCoffeeMix(@PathVariable int id) {
        return ResponseEntity.ok().body(this.ratingRepository.findByCoffeeMixId(id));
    }

    // Create new Rating
    @ApiResponse(responseCode = "404", content = @Content)
    @ApiResponse(responseCode = "403", content = @Content)
    @ApiResponse(responseCode = "400", content = @Content, description = "The rating in the request body contains validation errors.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Rating.class)))
    @RequestMapping(path = "{id}/ratings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> addCoffeeMixRating(@PathVariable int id, @Valid @RequestBody Rating rating, BindingResult bindingResult) {
        var coffeeMix = this.coffeeMixRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        if (authentication == null || !authentication.isAuthenticated()) {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
//        }
// todo add if we go with authentication

//        can still be implemented if necessary
//        if (this.badWordService.containsBadWords(rating.getReview())) {
//            bindingResult.addError(new FieldError("rating", "comment", "Your comment contains bad words, please watch your language!"));
//        }

        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            System.out.println("binding result is ok / ln 127 RESTCoffeeMixController");
//            rating.setUser((User) this.userService.loadUserByUsername(authentication.getName()));
//            rating.setCoffeeMix(coffeeMix);

            return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingRepository.save(rating));
        }
    }

}
