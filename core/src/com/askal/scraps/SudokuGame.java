package com.askal.scraps;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SudokuGame extends ApplicationAdapter {

	private Stage stage;
	Image img;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		// Grid taken courtesy of http://www.kidsmathgamesonline.com/sudoku/printableworksheets/template.html
		Texture texture = new Texture(Gdx.files.internal("data/grid.png"));
		img = new Image(texture);
		img.setPosition(0, 0);
		stage.addActor(img);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
