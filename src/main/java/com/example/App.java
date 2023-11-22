package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.model.Person;
import com.example.service.PersonService;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService service = ctx.getBean(PersonService.class);
        // System.out.println(service.create(new Person(4, "Arun", "Kumar", 30)));
        // System.out.println(service.create(new Person(5, "Ashish", "S", 33)));
        var list = service.findlAll();
        list.stream().forEach(person -> System.out.println(person));
        System.out.println();
        System.out.println();
        list.stream()
                .filter(person -> person.getAge() > 25)
                .toList()
                .stream()
                .forEach(person -> System.out.println(person));
        System.out.println();
        System.out.println();
        var sumOfAllAge = list.stream()
                .mapToInt(p -> p.getAge()).sum();
        System.out.println(sumOfAllAge);
    }
}
