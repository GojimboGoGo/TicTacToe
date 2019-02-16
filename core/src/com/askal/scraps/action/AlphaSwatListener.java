package com.askal.scraps.action;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlphaSwatListener extends ClickListener {

    private final static Logger LOG = LoggerFactory.getLogger(AlphaSwatListener.class);

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        Actor thisActor = event.getListenerActor();
        float currentAlpha = thisActor.getColor().a;
        LOG.debug("enter: Received alpha of square: #{}", currentAlpha);
        thisActor.getColor().a = Color.WHITE.a;
        super.enter(event, x, y, pointer, fromActor);
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        Actor thisActor = event.getListenerActor();
        float currentAlpha = thisActor.getColor().a;
        LOG.debug("exit: Received alpha of square: #{}", currentAlpha);
        thisActor.getColor().a = Color.CLEAR.a;
        super.exit(event, x, y, pointer, toActor);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
    }
}
