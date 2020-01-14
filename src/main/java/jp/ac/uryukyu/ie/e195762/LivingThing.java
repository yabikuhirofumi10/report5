package jp.ac.uryukyu.ie.e195762;
/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 敵の名前
     * @param maximumHP 敵のHP
     * @param attack 敵の攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * setterメソッドと同等。
     * @param setDead
     * @return boolean
     */
    public boolean setIsDead(boolean setDead){
        dead = setDead;
        return dead;
    }

    public String getName(){
        return name;
    }

    public int getHitPoint(){return hitPoint;}

    /**
     * 敵へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if( dead ==false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージLT
     *
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    /**
     * hitPointのsetterメソッド同等。隠蔽化されたメンバ変数にアクセスしてdamageを反映させる。
     * @param damage 受けたダメージ
     * @return int
     */
    public int setDamaged(int damage){
        hitPoint -= damage;
        return hitPoint;
    }
}