package com.sbp.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public FilteringBean filteringBean()
    {
        return new FilteringBean("val1", "val2", "val3");
    }


    @GetMapping("/filtering-list")
    public List<FilteringBean> filteringBeanLists()
    {
        return  Arrays.asList(
                new FilteringBean("val1", "val2", "val3"),
                new FilteringBean("val4", "val5", "val6"));
    }

}
