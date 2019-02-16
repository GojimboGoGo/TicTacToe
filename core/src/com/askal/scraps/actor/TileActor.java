package com.askal.scraps.actor;

import com.askal.scraps.listener.AlphaSwatListener;
import com.askal.scraps.reference.TileState;
import com.askal.scraps.reference.TileTexture;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TileActor extends Image {

    private static final Logger LOG = LoggerFactory.getLogger(TileActor.class);

    private TileState tileState;

    public TileActor(float x, float y) {
        super(TileTexture.BLANK_TILE_DRAWABLE);
        this.tileState = TileState.BLANK;
        this.setPosition(x, y);
        this.setColor(1, 1, 1, 1);
        this.addListener(new AlphaSwatListener());
        this.setTouchable(Touchable.enabled);
    }

    public void assignNextState() {
        switch (this.tileState) {
            case BLANK:
                this.setTileState(TileState.X);
                break;
            case X:
                this.setTileState(TileState.O);
                break;
            case O:
            default:
                this.setTileState(TileState.BLANK);
        }
        this.setDrawable(this.tileState.getTileDrawable());
        LOG.debug("assignNextState: New state {}", this.tileState);
    }

    protected void setTileState(TileState newState) {
        this.tileState = newState;
    }
}
