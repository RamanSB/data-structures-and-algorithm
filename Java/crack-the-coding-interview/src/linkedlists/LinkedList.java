package linkedlists;

public class LinkedList {

    Link first;

    public void insertFirst(int newItemData){
        Link newLink = new Link(newItemData);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Link current = first;
        while(current!=null){
            sb.append(current + " ");
            current = current.next;
        }
        return sb.toString();
    }


    class Link {

        int data;
        Link next;

        Link(int data){
            this.data = data;
            next = null;
        }

        @Override
        public String toString(){
            return String.format("Link[%d]", this.data);
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Link){
                return ((Link) obj).data == this.data;
            }
            return false;
        }

        @Override
        public int hashCode(){
            return this.data * 7;
        }
    }

}
