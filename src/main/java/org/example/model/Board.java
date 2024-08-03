package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.service.JumpManager;
import org.example.service.PlayerPositionManager;

import java.util.Queue;

@Getter
@Setter
@Builder
public class Board {

    private Dice dice;
    private Queue<Player> playerQueue;
    private JumpManager jumpManager;
    private Integer boardSize;
    private PlayerPositionManager playerPositionManager;

    private void initialisePlayerPostions() {
        playerQueue.forEach(player -> playerPositionManager.getPlayerCurrentPosition().put(player, 1));
    }

    private boolean isGameFinished() {
        return playerQueue.size() == 1;
    }

    public void startGame() {
        System.out.println("Starting Game...................................................................................");
        initialisePlayerPostions();
        while (!isGameFinished()) {
            Player currentPlayer = playerQueue.poll();
            int currentPosition = playerPositionManager.getPlayerCurrentPosition().get(currentPlayer);
            System.out.println(currentPlayer.getName() + " is on postion " + currentPosition + ". This is his turn");
            int currentDiceRoll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolls dice and gets " + currentDiceRoll);
            int nextPosition = currentPosition + currentDiceRoll;

            if (nextPosition == boardSize && currentPlayer != null) {
                System.out.println(currentPlayer.getName() + " has finished the game");
            } else if (nextPosition > boardSize && currentPlayer != null) {
                System.out.println(currentPlayer.getName() + " has exceeded boardSize, piece won't be moved.");
                playerQueue.offer(currentPlayer);
            } else {
                //check for snakes
                if(jumpManager.checkIfSnake(nextPosition)) {
                    int prevPosition = nextPosition;
                    nextPosition = jumpManager.getSnakeTail(prevPosition);
                    System.out.println(currentPlayer.getName() + " has been bitten by a snake at " + prevPosition + " and landed on " + nextPosition);
                }
                //check for ladders
                else if(jumpManager.checkIfLadder(nextPosition)) {
                    int prevPosition = nextPosition;
                    nextPosition = jumpManager.getLadderHead(prevPosition);
                    System.out.println(currentPlayer.getName() + " has taken a ladder at " + prevPosition + " and landed on " + nextPosition);
                }
                else {
                    System.out.println(currentPlayer.getName() + " moves to " + nextPosition);
                }
                // update position and add player at the end of the list
                playerPositionManager.getPlayerCurrentPosition().put(currentPlayer, nextPosition);
                playerQueue.offer(currentPlayer);
            }
        }
        System.out.println("Game Finished...................................................................................");
    }
}
