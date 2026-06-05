package com.mygdx.game.components;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ExplosionView {
    float x, y;
    float width, height;
    TextureRegion[] frames;
    int frameCounter;
    int frameMultiplier = 10;
    boolean finished;

    public ExplosionView(float x, float y, TextureRegion[] frames) {
        this.x = x;
        this.y = y;
        this.frames = frames;
        this.frameCounter = 0;
        this.finished = false;
        this.width = frames[0].getRegionWidth();
        this.height = frames[0].getRegionHeight();
    }

    public void update() {
        if (!finished) {
            frameCounter++;
            if (frameCounter >= frames.length * frameMultiplier) {
                finished = true;
            }
        }
    }

    public void draw(Batch batch) {
        if (finished) return;
        int frameIndex = frameCounter / frameMultiplier;
        TextureRegion frame = frames[frameIndex];
        batch.draw(frame, x - width/2, y - height/2, width, height);
    }

    public boolean isFinished() {
        return finished;
    }

    public void dispose() {
    }
}