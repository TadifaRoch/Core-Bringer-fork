package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.jshell.execution.Util;

import javax.swing.text.Utilities;

/** {@link ApplicationListener} implementation shared by all platforms. */
public class CoreBringer extends ApplicationAdapter {
    //private
    private SpriteBatch batch;
    private TextureAtlas boss_atlas;

    //public
    public Texture Character;
    public Sprite textureSprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Character = new Texture(Utils.getInternalPath("hero.png"));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //calls the hero sprite
        batch.draw(Character, 0, 0, 160, 240);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        Character.dispose();

    }

    @Override
    public void resize(int width, int height){
        //Retains the sprite size even when maximizing and minimizing the game window
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }
}
