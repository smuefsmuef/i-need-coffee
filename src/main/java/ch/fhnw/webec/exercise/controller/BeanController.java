package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Bean;
import ch.fhnw.webec.exercise.repository.BeanRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/beans")
public class BeanController {

    private final BeanRepository beanRepository;

    public BeanController(BeanRepository beanRepository) {
        this.beanRepository = beanRepository;
    }

    // Add a new Bean
    @PostMapping()
    public ResponseEntity<Bean> addBean(@Valid @RequestBody Bean bean, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.beanRepository.save(bean));
    }

    // Delete a Bean by Id
    @DeleteMapping("{id}")
    public ResponseEntity<Bean> deleteBean(@PathVariable int id) {
        if(this.beanRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.beanRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Get all beans
    @GetMapping()
    public ResponseEntity<List<Bean>> getBeanList() {
        return ResponseEntity.ok().body(this.beanRepository.findAll());
    }
}
