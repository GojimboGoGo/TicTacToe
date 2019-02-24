package com.askal.scraps.desktop;

import com.askal.scraps.SetupGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Tic Tac Toe";
        config.height = 230;
        config.width = 230;
        new LwjglApplication(new SetupGame(), config);
    }
}
