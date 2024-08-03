package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Player;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Singleton
public class PlayerPositionManager {
    Map<Player, Integer> playerCurrentPosition;

    public PlayerPositionManager() {
        playerCurrentPosition = new HashMap<>();
    }
}
