package com.sbp.learnspringframework2.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public interface DataService {
    int[] retrieveData();
}
