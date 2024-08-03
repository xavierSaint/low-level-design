package org.example;

import org.example.model.*;
import org.example.service.JumpManager;
import org.example.service.PlayerPositionManager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        PlayerPositionManager playerPositionManager = new PlayerPositionManager();
        Dice dice = new Dice(1);
        int boardSize = 100;

        //Players init
        Player player1 = new Player("Shubham Patel", 1);
        Player player2 = new Player("Kishan Kumar Gupta", 2);
        Player player3 = new Player("Hardik Khanna", 3);

        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.offer(player1);
        playerQueue.offer(player2);
        playerQueue.offer(player3);

        //Snakes init
        Snake snake1 = new Snake(99, 2);
        Snake snake2 = new Snake(47, 7);
        Snake snake3 = new Snake(60, 15);
        Snake snake4 = new Snake(78, 26);
        //Ladders init
        Ladder ladder1 = new Ladder(9, 25);
        Ladder ladder2 = new Ladder(17, 65);
        Ladder ladder3 = new Ladder(56, 82);
        Ladder ladder4 = new Ladder(32, 90);

        JumpManager jumpManager = new JumpManager();
        jumpManager.addSnake(snake1);
        jumpManager.addSnake(snake2);
        jumpManager.addSnake(snake3);
        jumpManager.addSnake(snake4);

        jumpManager.addLadder(ladder1);
        jumpManager.addLadder(ladder2);
        jumpManager.addLadder(ladder3);
        jumpManager.addLadder(ladder4);

        Board board = Board.builder()
                .boardSize(boardSize)
                .dice(dice)
                .jumpManager(jumpManager)
                .playerPositionManager(playerPositionManager)
                .playerQueue(playerQueue)
                .build();

        board.startGame();
    }
}