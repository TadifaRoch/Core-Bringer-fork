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
        //initializing atlas sprite
        boss_atlas = new TextureAtlas(Gdx.files.internal("boss_atlas/boss_atlas.atlas"));
        batch = new SpriteBatch();
        //calling a sprite
        textureSprite = new Sprite(boss_atlas.findRegion("Praeton_Wyrm"));
        textureSprite.setSize(5, 5);
        textureSprite.setBounds(10, 10, 200, 200);
        
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //calls the atlas
        textureSprite.draw(batch);
        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        Character.dispose();
        boss_atlas.dispose();
    }

    @Override
    public void resize(int width, int height){
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }
}
