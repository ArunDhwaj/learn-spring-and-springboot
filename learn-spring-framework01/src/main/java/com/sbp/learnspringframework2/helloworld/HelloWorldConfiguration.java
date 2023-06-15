package com.sbp.learnspringframework2.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address){};
record Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name()
    {
        return "SBP";
    }

    @Bean
    public String name2()
    {
        return "Mango";
    }

    @Bean
    public int age()
    {
        return 15;
    }

    @Bean
    public Person person()
    {
        return new Person("Aarush", 15, new Address("Aarul", "Bangalore"));
    }

    @Bean(name="address2")
    @Primary
    public Address address()
    {
        return new Address("Aarush", "Bangalore");
    }

    @Bean(name="address3")
    @Qualifier("address3qualifier")
    public Address address3()
    {
        return new Address("Aarul", "Bangalore new");
    }

    @Bean
    public Person person2MethodCall()
    {
        return new Person( name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3)
    {
        return new Person( name, age, address3);
    }


    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address)
    {
        return new Person( name, age, address);
    }

    @Bean
    @Primary
    public Person person5Parameters(String name, int age, @Qualifier("address3qualifier") Address address)
    {
        return new Person( name, age, address);
    }

}
