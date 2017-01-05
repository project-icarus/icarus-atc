package com.icarus.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MainUi {
    private BitmapFont font;
    private ShapeRenderer shapes;
    private String status;
    private GlyphLayout layout;
    private SpriteBatch batch;
    private ImageButton headingButton;
    public Stage stage;

    public MainUi(AssetManager assets, BitmapFont font) {
        this.font = font;
        shapes = new ShapeRenderer();
        batch = new SpriteBatch();
        Drawable headingDrawable = new TextureRegionDrawable(
                new TextureRegion((Texture) assets.get("buttons/heading_button.png")));
        ImageButton headingButton = new ImageButton(headingDrawable);
        status = "Hello, World!";
        layout = new GlyphLayout();
        headingButton = new ImageButton(headingDrawable);
        stage = new Stage();
        stage.addActor(headingButton);
    }

    public void draw() {
        stage.draw();
        //draw a rectangle for the status bar
        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(0, 0, 0, 1);
        shapes.rect(0, 0, Gdx.graphics.getWidth(),  50);
        shapes.end();

        batch.begin();
        layout.setText(font, status);
        shapes.setColor(1, 1, 1, 1);
        font.draw(batch, status, Gdx.graphics.getWidth() / 2 - layout.width / 2, 40);
        batch.end();
    }

    public void setStatus(String status) {
        this.status = status;
    }
}