public class Paper {
    private StringBuffer content;
    private int maxSymbols;

    public Paper(int maxSymbols) {
        this.maxSymbols = maxSymbols;
        this.content = new StringBuffer();
    }

    public Paper() {
        this(4096); // call Paper(int)
    }

    public int getMaxSymbols() {
        return maxSymbols;
    }
    
    public int getSymbols() {
        return this.content.length();
    }

    public void addContent(String message) throws OutOfSpaceException {
        int total = content.length() + message.length();

        if ( content.length() == maxSymbols ) {
            throw new OutOfSpaceException();
        }
        if ( total > maxSymbols ) {
            content.append(message.substring(0, maxSymbols-content.length()));
            throw new OutOfSpaceException("You filled last space on this paper. Message isn't finished.");
        }
        content.append(message);
    }
    
    public void show() {
        if ( this.content.length() == 0 ) {
            System.out.println("This paper is empty.");
        } else {
            System.out.println("Content of this paper: " + content + "\n**********");
        }
    }
}