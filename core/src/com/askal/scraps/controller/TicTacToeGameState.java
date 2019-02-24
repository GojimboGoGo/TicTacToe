package com.askal.scraps.controller;

import com.askal.scraps.actor.TileActor;
import com.askal.scraps.reference.Player;
import com.askal.scraps.reference.TileState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGameState implements GameState {

    private TileActor[] gridTiles;
    private Player currentPlayer;
    private boolean gameEnd;

    public TicTacToeGameState(TileActor[] gridTiles) {
        this(gridTiles, Player.CROSSES);
    }

    public TicTacToeGameState(TileActor[] gridTiles, Player currentPlayer) {
        this.gameEnd = false;
        this.gridTiles = gridTiles;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void resetGame() {

        for (TileActor a : gridTiles) {
            a.setTileState(TileState.BLANK);
            a.setColor(Color.WHITE);
        }
        this.currentPlayer = Player.CROSSES;
        gameEnd = false;
    }

    @Override
    public boolean checkVictoryCondition() {

        if (!gameEnd) {
            return hasGameEnded();
        }

        return true;
    }

    private boolean hasGameEnded() {

        boolean result = false;
        List<TileState> tileStates = new ArrayList<TileState>();
        int blankCount = 0;
        for (TileActor gridTile : gridTiles) {
            if (TileState.BLANK.equals(gridTile.getTileState())) {
                blankCount++;
            }
            tileStates.add(gridTile.getTileState());
        }

        if (blankCount < 5) {
            List<List<TileState>> subLists = new ArrayList<List<TileState>>();

            for (int i = 0; i < 3; i++) {
                List<TileState> row = tileStates.subList(i * 3, i * 3 + 3);
                if (!row.contains(TileState.BLANK)) {
                    subLists.add(row);
                }
            }

            for (int i = 0; i < 3; i ++) {
                List<TileState> column = new ArrayList<TileState>();
                column.add(tileStates.get(i));
                column.add(tileStates.get(i + 3));
                column.add(tileStates.get(i + 6));
                if (!column.contains(TileState.BLANK)) {
                    subLists.add(column);
                }
            }

            List<TileState> southwNeDiag = new ArrayList<TileState>();
            southwNeDiag.add(tileStates.get(0));
            southwNeDiag.add(tileStates.get(4));
            southwNeDiag.add(tileStates.get(8));

            if (!southwNeDiag.contains(TileState.BLANK)) {
                subLists.add(southwNeDiag);
            }

            List<TileState> northwSeDiag = new ArrayList<TileState>();
            northwSeDiag.add(tileStates.get(6));
            northwSeDiag.add(tileStates.get(4));
            northwSeDiag.add(tileStates.get(2));

            if (!northwSeDiag.contains(TileState.BLANK)) {
                subLists.add(northwSeDiag);
            }

            for (List<TileState> sl : subLists) {
                if(sl.get(0).equals(sl.get(1))
                    && sl.get(0).equals(sl.get(2))) {
                    result = true;
                    break;
                }
            }
        }

        gameEnd = result;
        return result;
    }

    @Override
    public void fire(Event event) {
        Gdx.app.debug("TODO", "fire() implementation");
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void setNextPlayer() {
        if (Player.CROSSES.equals(this.currentPlayer)) {
            this.currentPlayer = Player.CIRCLES;
        } else {
            this.currentPlayer = Player.CROSSES;
        }
    }
}
