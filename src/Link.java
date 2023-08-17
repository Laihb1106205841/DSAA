
public class Link {
    int data;
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

