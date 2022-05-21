package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.CoffeeMix;
import ch.fhnw.webec.exercise.model.Rating;
import ch.fhnw.webec.exercise.repository.CoffeeMixRepository;
import ch.fhnw.webec.exercise.repository.RatingRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/coffeemixes")
public class CoffeeMixController {

    private final CoffeeMixRepository coffeeMixRepository;
    private final RatingRepository ratingRepository;

    public CoffeeMixController(CoffeeMixRepository coffeeMixRepository, RatingRepository ratingRepository) {
        this.coffeeMixRepository = coffeeMixRepository;
        this.ratingRepository = ratingRepository;
    }

    // Get all Coffee Mixes
    @GetMapping()
    public ResponseEntity<List<CoffeeMix>> getWorkspaceList() {
        return ResponseEntity.ok().body(this.coffeeMixRepository.findAll());
    }

    // Get one Coffee Mix by id
    @GetMapping("{id}")
    public ResponseEntity<CoffeeMix> findById(@PathVariable int id) {
        var coffeeMix = this.coffeeMixRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(coffeeMix);
    }



    // Add a new Coffee Mix
    @PostMapping()
    public ResponseEntity<CoffeeMix> addCoffeeMix(@Valid @RequestBody CoffeeMix workspace, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.coffeeMixRepository.save(workspace));
    }


    // Update a Coffee Mix by Id
    @PutMapping("{id}")
    public ResponseEntity<CoffeeMix> updateCoffeeMix(@PathVariable int id, @Valid @RequestBody CoffeeMix coffeeMix, BindingResult bindingResult) {
        if(this.coffeeMixRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(this.coffeeMixRepository.save(coffeeMix));
    }



    // Delete a Coffee Mix by Id
    @DeleteMapping("{id}")
    public ResponseEntity<CoffeeMix> deleteCoffeeMix(@PathVariable int id) {
        if(this.coffeeMixRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.coffeeMixRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    // Get Ratings of a Coffee Mix by id
    @GetMapping("{coffeeMixId}/ratings")
    public ResponseEntity<List<Rating>> findRatingsByCoffeeMix(@PathVariable("coffeeMixId") int coffeeMixId) {
        return ResponseEntity.ok().body(this.ratingRepository.findByCoffeeMixId(coffeeMixId));
    }



    // Create new Rating
    @PostMapping("{coffeeMixId}/ratings")
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
