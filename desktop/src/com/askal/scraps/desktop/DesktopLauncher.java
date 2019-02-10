package com.askal.scraps.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.askal.scraps.SudokuGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Sudoku";
		config.height = 600;
		config.width = 600;
		new LwjglApplication(new SudokuGame(), config);
	}
}
