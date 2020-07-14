public class Pen {
    private int inkAmount;
    private int inkCapacity;

    public Pen(int inkCapacity) {
        this.inkAmount = inkCapacity;
        this.inkCapacity = inkCapacity;
    }

    public Pen() {
        this(1024); // call Pen(int)
    }

    public int getInkAmount() {
        return this.inkAmount;
    }
    public int getInkCapacity() {
        return this.inkCapacity;
    }

    public void write(Paper paper, String message) throws OutOfInkException, OutOfSpaceException {
        int space, messageSize;
        
        if ( inkAmount == 0 ) {
            throw new OutOfInkException();
        }
        
        space = paper.getMaxSymbols() - paper.getSymbols();
        messageSize = message.length();
        
        if ( this.inkAmount > space && messageSize > space ) {
            this.inkAmount -= space;
            paper.addContent(message);
            return;
        }
        if ( this.inkAmount < space && messageSize > this.inkAmount ) {
            paper.addContent(message.substring(0, this.inkAmount));
            this.inkAmount = 0;
            
            throw new OutOfInkException("You spent last ink of this pen. Message isn't finished.");
        }
        if ( this.inkAmount == space && messageSize > this.inkAmount ) {
            try {
                paper.addContent(message);
            } catch (OutOfSpaceException e) {
                System.out.println(e);
            }
            this.inkAmount = 0;
            throw new OutOfInkException("You spent last ink of this pen. Message isn't finished.");
        }
        
        paper.addContent(message);
        this.inkAmount -= messageSize;
    }
    public void refill() {
        this.inkAmount = this.inkCapacity;
        System.out.println("Pen refilled");
    }
}

