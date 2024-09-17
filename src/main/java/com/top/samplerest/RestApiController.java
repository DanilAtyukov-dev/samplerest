package com.top.samplerest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiController(){
        coffees.addAll(List.of(
            new Coffee("Колумб"),
                new Coffee("Мексиканск")
        ));
    }

    //@GetMapping("/coffees")
    @RequestMapping(value = "/coffees", method = RequestMethod.GET)
    Iterable<Coffee> getCoffees(){
        return coffees;
    }

    @PostMapping("/postCoffee")
    String postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);

        return "Успех";
    }

    @PutMapping("/coffees/{id}")
    String putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        coffees.add(coffee);

        return "успех";
    }

    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id){
        System.out.println("coffees size "+coffees.size()+ " id = " + id);

        coffees.clear();
        System.out.println("coffees size "+coffees.size());
    }

}


