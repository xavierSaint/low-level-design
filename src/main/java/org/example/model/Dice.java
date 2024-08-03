package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dice {
    private int noOfDice;

    public int roll() {
        return (int) (Math.random()*(6 * noOfDice - 1 * noOfDice) + 1);
    }
}
