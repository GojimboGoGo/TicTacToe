package com.askal.scraps.reference;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TileTexture {

    private TileTexture() {
    }

    public static final Drawable BLANK_TILE_DRAWABLE =
            new TextureRegionDrawable(
                    new Texture(
                            Gdx.files.internal("data/blank_tile.png")));
    public static final Drawable X_TILE_DRAWABLE =
            new TextureRegionDrawable(
                    new Texture(Gdx.files.internal("data/X_tile.png")));
    public static final Drawable O_TILE_DRAWABLE =
            new TextureRegionDrawable(
                    new Texture(Gdx.files.internal("data/O_tile.png")));
}
