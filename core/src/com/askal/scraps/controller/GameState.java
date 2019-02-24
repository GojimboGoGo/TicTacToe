package com.askal.scraps.controller;

import com.askal.scraps.reference.Player;
import com.badlogic.gdx.scenes.scene2d.Event;

public interface GameState {

    boolean checkVictoryCondition();

    void fire(Event event);

    Player getCurrentPlayer();

    void setNextPlayer();
}
