package com.askal.scraps;

import com.askal.scraps.actor.TileActor;
import com.askal.scraps.controller.BasicGameState;
import com.askal.scraps.controller.GameState;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SetupGame extends ApplicationAdapter {

    private Stage stage;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.debug("Startup", "Logging BEGIN!");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        this.buildTicTacToeTiles();
        Gdx.app.debug("Startup", "Create end!");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void buildTicTacToeTiles() {
        // Grid taken courtesy of http://www.kidsmathgamesonline.com/sudoku/printableworksheets/template.html
        Texture texture = new Texture(Gdx.files.internal("data/board tictactoe.png"));
        Image borderImage = new Image();
        borderImage.setPosition(0, 0);
        borderImage.setSize(230, 230);
        stage.addActor(borderImage);

        Image gridImage = new Image(texture);
        gridImage.setPosition(15, 15);

        stage.addActor(gridImage);
        GameState gameState = new BasicGameState();

        Image[] gridTiles = new Image[9];
        for (int i = 0; i < 9; i++) {
            int xPosition = 16 + i % 3 * 66;
            int yPosition = 16 + i / 3 * 66;
            Gdx.app.debug("Create", "Adding tile ("+xPosition+", "+yPosition+")");
            gridTiles[i] = new TileActor(xPosition, yPosition, gameState);
            gridTiles[i].setTouchable(Touchable.enabled);
            stage.addActor(gridTiles[i]);
        }
    }

    private void buildSudokuTiles() {
        // Grid taken courtesy of http://www.kidsmathgamesonline.com/sudoku/printableworksheets/template.html
        Texture texture = new Texture(Gdx.files.internal("data/grid.png"));
        Image gridImage = new Image(texture);
        gridImage.setPosition(0, 0);
        stage.addActor(gridImage);
        GameState gameState = new BasicGameState();

        Image[][] gridTiles = new Image[9][];
        for (int i = 0; i < 9; i++) {
            gridTiles[i] = new Image[9];

            int xOffset = 1 + i % 3 * 200;
            int yOffset = 2 + i / 3 * 200;
            for (int j = 0; j < 9; j++) {
                int xPosition = xOffset + j % 3 * 66;
                int yPosition = yOffset + j / 3 * 66;
                gridTiles[i][j] = new TileActor(xPosition, yPosition, gameState);
                Gdx.app.debug("Create", "Adding tile ("+xPosition+", "+yPosition+")");
                stage.addActor(gridTiles[i][j]);
            }
        }
    }
}
