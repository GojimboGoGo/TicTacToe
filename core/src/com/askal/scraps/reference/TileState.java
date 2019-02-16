package com.askal.scraps.reference;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public enum TileState {
    BLANK(TileTexture.BLANK_TILE_DRAWABLE),
    X(TileTexture.X_TILE_DRAWABLE),
    O(TileTexture.O_TILE_DRAWABLE);

    private Drawable tileDrawable;

    TileState(Drawable tileDrawable) {
        this.tileDrawable = tileDrawable;
    }

    public Drawable getTileDrawable() {
        return this.tileDrawable;
    }
}
