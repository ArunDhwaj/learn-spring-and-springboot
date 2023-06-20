package com.sbp.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //Static filtering
    @GetMapping("/filtering")
    public FilteringBeanStatic filteringBean()
    {
        return new FilteringBeanStatic("val1", "val2", "val3");
    }

    @GetMapping("/filtering-list")
    public List<FilteringBeanStatic> filteringBeanLists()
    {
        return  Arrays.asList(
                new FilteringBeanStatic("val1", "val2", "val3"),
                new FilteringBeanStatic("val4", "val5", "val6"));
    }


    //Static filtering
    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filteringBeanDynamic()
    {
        FilteringBeanDynamic filteringBeanDynamic = new FilteringBeanDynamic("val1", "val2", "val3");
        MappingJacksonValue jacksonValue = new MappingJacksonValue(filteringBeanDynamic);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("FilteringBeanDynamic", filter);

        jacksonValue.setFilters(filters);

        return jacksonValue;
    }

    @GetMapping("/filtering-dynamic-list")
    public MappingJacksonValue filteringBeanDynamicsLists()
    {
        List<FilteringBeanDynamic> list= Arrays.asList(
                new FilteringBeanDynamic("val1", "val2", "val3"),
                new FilteringBeanDynamic("val4", "val5", "val6"));

        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("FilteringBeanDynamic", filter);

        jacksonValue.setFilters(filters);

        return jacksonValue;

    }

}
