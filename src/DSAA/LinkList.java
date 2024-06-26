package DSAA;

public class LinkList {
    int length;
    Link first;
    Link last;

    public LinkList(){}
    public LinkList(int length){
        this.length = length;
        first = null;
        last = null;
    }

    public void add(Link i){
        if(first == null){
            first = i;
            first.previous = null;
            first.next = null;
            last = i;
        }
        else {
            last.next = i;
            i.previous = last;
            last = i;
        }
        length +=1;
    }

    public String toString(){
        System.out.println("Node first"+": "+first.data);
        System.out.println("Node last"+": "+last.data);
        System.out.println("Length: "+length);

        return "Node first: "+first.data+"\nNode last: "+last.data+"\nLength: "+length;
    }

    public static void main(String[] args) {
        Link a = new Link(10);
        Link b = new Link(11);
        Link c = new Link(12);
        Link d = new Link(13);
        LinkList M = new LinkList();
        M.add(a);
        M.add(b);
        M.add(c);
        M.add(d);
        M.toString();
    }
}
