package com.askal.scraps.listener;

import com.askal.scraps.actor.TileActor;
import com.askal.scraps.controller.GameState;
import com.askal.scraps.reference.TileState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class AlphaSwatListener extends ClickListener {

    private GameState gameState;

    public AlphaSwatListener(GameState gameState) {
        super();

        this.gameState = gameState;

        Gdx.app.debug("Startup", "Created listener");
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        Gdx.app.debug("mouse", "enter");
        TileActor tile = this.getListenerActor(event);
        if (!gameState.checkVictoryCondition()
                && TileState.BLANK.equals(tile.getTileState())) {
            tile.setColor(Color.RED);
        }
        super.enter(event, x, y, pointer, fromActor);
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        Gdx.app.debug("mouse", "exit");
        Actor thisActor = event.getListenerActor();
        thisActor.setColor(Color.WHITE);
        super.exit(event, x, y, pointer, toActor);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {

        Gdx.app.debug("mouse", "click");
        if (!gameState.checkVictoryCondition()) {
            TileActor tile = this.getListenerActor(event);
            tile.assignNextState();
        }
        super.clicked(event, x, y);
    }

    private TileActor getListenerActor(InputEvent event) {

        if (!(event.getListenerActor() instanceof TileActor)) {
            Exception e = new IllegalStateException();
            Gdx.app.error("Tile", "AlphaSwatListener: Not attached to tile!", e);
        }

        return (TileActor) event.getListenerActor();
    }
}
