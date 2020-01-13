package jp.ac.uryukyu.ie.e195762;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @org.junit.jupiter.api.Test
    void attack() {

        int heroHP = 10;
        Hero hero = new Hero("テスト勇者", heroHP, 5);
        Enemy enemy = new Enemy("テストスライム", 6, 3);
        enemy.setIsDead(true);
        for (int i = 0; i < 10; i++) {
            enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる。
        }
        assertEquals(heroHP, hero.getHitPoint());
    }
}