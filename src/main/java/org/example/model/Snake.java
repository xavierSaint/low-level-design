package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake extends Jumper{
    public Snake(int start, int end) {
        if (start > end) {
            this.start = start;
            this.end = end;
        } else {
            throw new IllegalArgumentException("Snake has to have a start > end");
        }
    }
}
