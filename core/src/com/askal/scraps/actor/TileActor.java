package com.askal.scraps.actor;

import com.askal.scraps.controller.GameState;
import com.askal.scraps.listener.AlphaSwatListener;
import com.askal.scraps.reference.Player;
import com.askal.scraps.reference.TileState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;

public class TileActor extends Image {

    private TileState tileState;
    private GameState gameState;

    public TileActor(float x, float y, GameState gameState) {
        this(x, y, TileState.BLANK, gameState);
    }

    public TileActor(float x, float y, TileState tileState, GameState gameState) {
        super(tileState.getTileDrawable(), Scaling.none);
        this.setTileState(tileState);
        this.gameState = gameState;
        this.setPosition(x, y);
        this.setColor(1, 1, 1, 1);
        this.addListener(new AlphaSwatListener(gameState));

        Gdx.app.debug("Create", "Finished construction");
    }

    @Override
    public void act(float delta) {

        if (gameState.checkVictoryCondition()) {
            this.setColor(Color.GRAY);
        }

        super.act(delta);
    }

    // TODO: actually do a proper undo
    public void assignNextState() {
        switch (this.tileState) {
            case BLANK:
                if (Player.CROSSES.equals(this.gameState.getCurrentPlayer())) {
                    this.setTileState(TileState.X);
                } else {
                    this.setTileState(TileState.O);
                }
                this.gameState.setNextPlayer();
                break;
            case X:
            case O:
                this.setTileState(TileState.BLANK);
                this.gameState.setNextPlayer();
                break;
            default:
                throw new IllegalStateException("Unexpected tile state: " + this.tileState.name());
        }

        Gdx.app.debug("Tile", "assignNextState: New state " + this.tileState);
    }

    protected void setTileState(TileState newState) {
        this.tileState = newState;
        this.setDrawable(this.tileState.getTileDrawable());
        Gdx.app.debug("Tile", "Assigned new drawable");
    }

    public TileState getTileState() {
        return this.tileState;
    }
}
