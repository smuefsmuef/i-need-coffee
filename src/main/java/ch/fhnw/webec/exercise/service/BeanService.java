package ch.fhnw.webec.exercise.service;

import ch.fhnw.webec.exercise.model.*;
import ch.fhnw.webec.exercise.repositories.*;
import org.springframework.stereotype.*;

@Component
public class BeanService {
    private final BeanRepository beanRepository;

    public BeanService(BeanRepository beanRepository) {this.beanRepository = beanRepository;}

    public Bean addBeans(String type, String origin, int altitude) {
        var bean = new Bean(type, origin, altitude);
        return beanRepository.save(bean);
    }

    public void update(Bean bean) {
        beanRepository.save(bean);
    }

    public void delete(Bean bean) {beanRepository.delete(bean);}
}
