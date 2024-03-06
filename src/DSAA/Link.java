package DSAA;

public class Link {
    int data;

    public int getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public Link getPrevious() {
        return previous;
    }

    Link next;
    Link previous;
    public Link(){}
    public Link(int data){
        this.data = data;
    }

    public Link(int data, Link next){
        this.data = data;
        this.next = next;
    }
}

