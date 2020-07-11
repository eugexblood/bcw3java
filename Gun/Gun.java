public class Gun implements Cloneable {
    private int amount;
    private int capacity;
    private boolean isReady;
    private String model;
    private int totalShots;
    
    public Gun() {
        this.amount = 0;
        this.capacity = 8;
        this.isReady = false;
        this.model = "Beretta";
        this.totalShots = 0;
    }
    
    public Gun(String model, int capacity) {
        this.amount = 0;
        if ( capacity < 1 ) {
            this.capacity = 8;
        } else {
            this.capacity = capacity;
        }
        this.isReady = false;
        this.model = model;
        this.totalShots = 0;
    }
    
    public Gun clone() throws CloneNotSupportedException {
        return (Gun) super.clone();
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    public boolean ready() {
        return this.isReady;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public int getTotalShots() {
        return this.totalShots;
    }
    
    public void prepare() {
        this.isReady = true;
        System.out.println(this.model + ": click-click! Ready to shoot.");
    }
    
    public void reload() {
        this.amount = this.capacity;
        this.isReady = false;
        System.out.println(this.model + ": zzzip! Reloaded.");
    }
    
    public String toString() {
        StringBuffer info = new StringBuffer();
        
        if ( this.ready() ) {
            info.append("is ready to shoot.");
        } else {
            info.append("is not ready to shoot.");
        }
        
        return "*************\n" + this.model + " has capacity " + this.capacity
        + ", total shots made: " + this.totalShots + ".\nRounds loaded: " + this.amount
        + ". This gun " + info + "\n*************";
    }
    
    public void shoot() throws NotReadyException, OutOfRoundsException {
        if ( !this.isReady ) {
            throw new NotReadyException();
        }
        if ( this.amount == 0 ) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println(this.model + ": Bang!!!");
        this.amount -= 1;
        this.totalShots += 1;
    }
}
