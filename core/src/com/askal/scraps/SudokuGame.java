package com.askal.scraps;

import com.askal.scraps.actor.TileActor;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuGame extends ApplicationAdapter {

	private final static Logger LOG = LoggerFactory.getLogger(SudokuGame.class);

	private Stage stage;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		// Grid taken courtesy of http://www.kidsmathgamesonline.com/sudoku/printableworksheets/template.html
		Texture texture = new Texture(Gdx.files.internal("data/grid.png"));
		Image gridImage = new Image(texture);
		gridImage.setPosition(0, 0);
		stage.addActor(gridImage);

		Image[][] gridTiles = new Image[9][];
		for (int i = 0; i < 9; i++) {
			gridTiles[i] = new Image[9];

			int xOffset = 1 + i%3 * 200;
			int yOffset = 2 + i/3 * 200;
			for (int j = 0; j < 9; j++) {
				int xPosition = xOffset + j%3 * 66;
				int yPosition = yOffset + j/3 * 66;
				gridTiles[i][j] = new TileActor(xPosition, yPosition);
				LOG.info("Adding tile ({}, {})", i, j);
				stage.addActor(gridTiles[i][j]);
			}
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(stage);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
