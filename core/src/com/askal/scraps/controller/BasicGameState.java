package com.askal.scraps.controller;

import com.askal.scraps.reference.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;

public class BasicGameState implements GameState {

    private Player currentPlayer;

    public BasicGameState() {
        this(Player.CROSSES);
    }

    public BasicGameState(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public boolean checkVictoryCondition() {
        return false;
    }

    @Override
    public void fire(Event event) {
        Gdx.app.debug("TODO", "fire() implementation");
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void setNextPlayer() {
        if (Player.CROSSES.equals(this.currentPlayer)) {
            this.currentPlayer = Player.CIRCLES;
        } else {
            this.currentPlayer = Player.CROSSES;
        }
    }
}
