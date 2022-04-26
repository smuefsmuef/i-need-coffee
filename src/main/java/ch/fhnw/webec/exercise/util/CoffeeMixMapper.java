package ch.fhnw.webec.exercise.util;

import ch.fhnw.webec.exercise.dto.*;
import ch.fhnw.webec.exercise.model.*;

public class CoffeeMixMapper {
    public void mapToCoffeeMix(CoffeeMix coffeeMix, CoffeeMixDto coffeeMixDto) {
        coffeeMix.setPricePerKg(coffeeMixDto.getPricePerKg());
        coffeeMix.setRoastDegree(coffeeMixDto.getRoastDegree());

        for (Bean beanDto : coffeeMixDto.getBeans()) {
                Bean bean = new Bean();
                bean.setType(beanDto.getType());
                bean.setOrigin(beanDto.getOrigin());
                bean.setAltitude(beanDto.getAltitude());
                coffeeMix.addBean(bean);
        }
    }
}

