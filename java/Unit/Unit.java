public class Unit implements Cloneable {
    private int damage;
    private int hitPoints;
    private int hitPointsLimit;
    private String name;
    
    public Unit(String name, int hp, int dmg) {
        this.name = name;
        if ( hp < 1 ) {
            this.hitPointsLimit = 10; // user will not be able to create "dead" unit and hp will has default value == 10.
        } else {
            this.hitPointsLimit = hp;
        }
        this.hitPoints = this.hitPointsLimit;
        if ( dmg < 0 ) {
            this.damage = 3; // this will set damage to default
        } else {
            this.damage = dmg; // in case dmg==0 unit can't damage enemy;
        }
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public int getHitPoints() {
        return this.hitPoints;
    }
    
    public int getHitPointsLimit() {
        return this.hitPointsLimit;
    }
    
    public String getName() {
        return this.name;
    }
    
    private void ensureIsAlive() throws UnitIsDeadException {
        if ( this.hitPoints == 0 ) {
            throw new UnitIsDeadException(this.name);
        }
    }
    
    public void addHitPoints(int hp) throws UnitIsDeadException {
        this.ensureIsAlive();
        this.hitPoints += hp;
        if ( this.hitPoints >= this.hitPointsLimit ) {
            this.hitPoints = this.hitPointsLimit;
            System.out.println(this.name + " is fully healed.");
        } else {
            System.out.println(hp + " point(s) added to HP of " + this.name + ".");
        }
    }
    
    public String toString() {
        return this.name + " has " + this.hitPoints + "/" + this.hitPointsLimit +
        " HP and " + this.damage + " damage value.";
    }
    
    public void takeDamage(int dmg) throws UnitIsDeadException {
        this.ensureIsAlive();
        this.hitPoints -= dmg; 
        if ( this.hitPoints <= 0 ) {
            this.hitPoints = 0;
            System.out.println(this.name + " is killed.");
        } else {
            System.out.println(this.name + " is taking " + dmg + " point(s) of damage.");
        }
    }
    
    public void attack(Unit enemy) throws UnitIsDeadException {
        this.ensureIsAlive();
        System.out.println(this.name + " attacks " + enemy.name + ".");
        enemy.takeDamage(this.damage);
        if ( enemy.hitPoints > 0 ) {
            this.counterAttack(enemy);
        }
    }
    
    public void counterAttack(Unit enemy) throws UnitIsDeadException {
        enemy.ensureIsAlive();
        System.out.println(enemy.name + " counter attacks " + this.name + ".");
        this.takeDamage(enemy.damage/2);
    }
    
    public Unit clone() throws CloneNotSupportedException {
        return (Unit) super.clone();
    }
}
