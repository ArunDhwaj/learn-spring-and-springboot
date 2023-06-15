package com.sbp.learnspringframework2.examples.c1;

import org.springframework.stereotype.Component;

@Component
public interface DataService {
    int[] retrieveData();
}
