package com.askal.scraps.listener;

import com.askal.scraps.actor.TileActor;
import com.askal.scraps.controller.GameState;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ResetListener extends ClickListener {

    private GameState gameState;

    public ResetListener(GameState gameState) {
        super(Input.Buttons.RIGHT);
        this.gameState = gameState;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {

        this.gameState.resetGame();

        super.clicked(event, x, y);
    }
}
