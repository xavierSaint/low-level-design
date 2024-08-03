package org.example.service;

import com.google.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Ladder;
import org.example.model.Snake;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Singleton
public class JumpManager {
    Map<Integer, Integer> snakeMap;
    Map<Integer, Integer> ladderMap;

    public JumpManager(){
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
    }

    public void addSnake(Snake snake){
        if (snakeMap.containsKey(snake.getStart())) {
            throw new IllegalArgumentException("Can't have two snakes at the same start point");
        } else if(ladderMap.containsKey(snake.getStart())) {
            throw new IllegalArgumentException("Ladder exists at this position. Can't add snake the same start point");
        } else {
            snakeMap.put(snake.getStart(), snake.getEnd());
        }
    }

    public void addLadder(Ladder ladder){
        if (ladderMap.containsKey(ladder.getStart())) {
            throw new IllegalArgumentException("Can't have two ladders at the same start point");
        } else if(snakeMap.containsKey(ladder.getStart())) {
            throw new IllegalArgumentException("Snake exists at this position. Can't add ladder the same start point");
        } else {
            ladderMap.put(ladder.getStart(), ladder.getEnd());
        }
    }

    public boolean checkIfSnake(int position) {
        return snakeMap.containsKey(position);
    }

    public boolean checkIfLadder(int position) {
        return ladderMap.containsKey(position);
    }

    public int getSnakeTail(int position) {
        return snakeMap.get(position);
    }

    public int getLadderHead(int position) {
        return ladderMap.get(position);
    }
}
