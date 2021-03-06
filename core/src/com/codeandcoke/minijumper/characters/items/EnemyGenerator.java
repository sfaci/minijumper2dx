package com.codeandcoke.minijumper.characters.items;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.codeandcoke.minijumper.characters.enemies.GrayEnemy;
import com.codeandcoke.minijumper.characters.enemies.Enemy;
import com.codeandcoke.minijumper.characters.enemies.GreenEnemy;
import com.codeandcoke.minijumper.characters.enemies.YellowEnemy;
import com.codeandcoke.minijumper.managers.ResourceManager;

import static com.codeandcoke.minijumper.util.Constants.ENEMY_SPEED;

/**
 * Generador de enemigos
 * @author Santiago Faci
 * @version curso 2014-2015
 */
public class EnemyGenerator extends Item {

    public String type;
    public long rate;
    public long lastEnemy;

    public EnemyGenerator(float x, float y, String type, long rate) {
        super(x, y);

        this.type = type;
        this.rate = rate;
        currentFrame = ResourceManager.getRegion("generator");
        rect.x = x;
        rect.y = y;
        rect.width = currentFrame.getRegionWidth();
        rect.height = currentFrame.getRegionHeight();
    }

    public Enemy generate() {

        Enemy enemy = null;

        switch (type) {
            case "green":
                enemy = new GreenEnemy(position.x, position.y - 5, 1, new Vector2(-ENEMY_SPEED, 0));
                break;
            case "yellow":
                enemy = new YellowEnemy(position.x, position.y - 5, 1, new Vector2(-ENEMY_SPEED, 0));
                break;
            case "gray":
                enemy = new GrayEnemy(position.x, position.y - 5, 1, new Vector2(-ENEMY_SPEED, 0));
                break;
            default:
                break;
        }

        lastEnemy = TimeUtils.millis();
        return enemy;
    }

    @Override
    public void update(float dt) {

    }
}
