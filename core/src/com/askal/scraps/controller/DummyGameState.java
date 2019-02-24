package com.askal.scraps.controller;

import com.askal.scraps.reference.Player;
import com.badlogic.gdx.scenes.scene2d.Event;

public class DummyGameState implements GameState {

    @Override
    public void resetGame() {

    }

    @Override
    public boolean checkVictoryCondition() {
        return false;
    }

    @Override
    public void fire(Event event) {

    }

    @Override
    public Player getCurrentPlayer() {
        return null;
    }

    @Override
    public void setNextPlayer() {

    }
}
