package com.askal.scraps.reference;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public enum TileState {
    BLANK("data/blank_tile.png"),
    X("data/X_tile.png"),
    O("data/O_tile.png");

    private Drawable tileDrawable;
    private String drawablePath;

    TileState(String drawablePath) {
        this.drawablePath = drawablePath;
        this.tileDrawable =
                new TextureRegionDrawable(
                        new Texture(
                                Gdx.files.internal(drawablePath)));
    }

    public String getDrawablePath() {
        return this.drawablePath;
    }

    public Drawable getTileDrawable() {
        return this.tileDrawable;
    }
}
