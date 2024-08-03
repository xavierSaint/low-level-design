package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ladder extends Jumper{
    public Ladder(int start, int end) {
        if (start < end) {
            this.start = start;
            this.end = end;
        } else {
            throw new IllegalArgumentException("Ladder has to have a start < end");
        }
    }
}
