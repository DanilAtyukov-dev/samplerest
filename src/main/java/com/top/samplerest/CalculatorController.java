package com.top.samplerest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @PostMapping("/sumOf/")
    Integer sumOf(@RequestBody TwoNumbers twoNumbers){
        System.out.println(twoNumbers);

        return Integer.parseInt(twoNumbers.numA) +
                Integer.parseInt(twoNumbers.numB);
    }
}

class TwoNumbers{
    String numA;
    String numB;

    TwoNumbers(String numA, String numB){
        this.numA = numA;
        this.numB = numB;
    }

    @Override
    public String toString() {
        return "numA = " + numA +", numB = "+ numB;
    }
}
