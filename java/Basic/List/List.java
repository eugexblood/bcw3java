import java.util.ArrayList; 
import java.util.Collections;

public class List implements Cloneable {
    private int capacity;
    private ArrayList<Integer> array;
    
    public List() {
        this.array = new ArrayList<Integer>(100);
    }
    
    public List(int capacity) throws IllegalArgumentException {
        this.array = new ArrayList<Integer>(capacity);
    }
    
    public int size() {
        return this.array.size();
    }
    
    public void erase(int index) {
        System.out.format("Number %d removed.\n", this.array.remove(index));
    }
    
    public void pushBack(int value) {
        this.array.add(value);
        System.out.format("Number %d added to the end.\n", value);
    }
    
    public int popBack() throws ZeroLenException {
        if ( this.array.isEmpty() ) {
            throw new ZeroLenException();
        }
        return this.array.remove(this.size()-1);
    }
    
    // method will insert value if this index is used or append value is there's no such index in a list.
    public void insert(int index, int value) {
        if ( index >= 0 && index < array.size() ) {
            this.array.add(index, value);
            System.out.format("Number %d inserted to position &d.\n", value, index);
        } else {
            this.array.add(value);
            System.out.format("No index %d in this list. Value added to the end.\n", index);
        }
    }
    
    public int find(int value) {
        return this.array.indexOf(value);
    }
    
    // instead reloading of operaror[]
    public int element(int index) {
        return this.array.get(index);
    }
    
    public boolean equals(List other) {
        if ( this.size() != other.size() ) {
            return false;
        }
        for ( int i = 0; i < this.size(); i++ ) {
            if ( this.element(i) != other.element(i) ) {
                return false;
            }
        }
        return true;
    }
    
    public void show() throws ZeroLenException {
        int last = this.size() - 1;
        
        if ( this.size() == 0 ) {
            throw new ZeroLenException();
        }
        
        for ( int i = 0; i < last; i++ ) {
            System.out.print(this.element(i) + " ");
        }
        System.out.println(this.element(last));
    }
    
    public void listSort() {
        Collections.sort(this.array);
    }
    
    public List clone() throws CloneNotSupportedException {
        return (List) super.clone();
    }
}
