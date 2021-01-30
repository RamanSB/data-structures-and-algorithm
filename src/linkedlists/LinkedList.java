package linkedlists;

public class LinkedList {

    Link first;

    LinkedList(){
        first = null;
    }

    //O(1)
    void insertFirst(int id, double data){
        Link newLink = new Link(id, data); //Creates a new link (this will be inserted to the front of the linked list)
        newLink.next = first;  //sets the next element to be the first item (prior to insertion)
        first = newLink; //setting the new link as the first reference.
    }

    //O(1)
    Link deleteFirst(){
        Link temp = first; //Reference to the first element, we are deleting
        first = first.next; //Sets the first reference to the Link next to the one we are deleting
        return temp;
    }


    //O(n)
    public Link find(int id){
        Link currentLink = first;
        while(currentLink.id != id){
            currentLink = currentLink.next;
            if(currentLink == null){
                return null; //Link with id does not exist in the linked list.
            }
        }
        return currentLink;
    }

    //O(n)
    //Method must keep reference to the link which exists prior to the link we are deleting.
    public Link deleteLink(int id){
        Link previous = first;
        Link currentLink = first;

        while(currentLink.id != id){
            previous = currentLink;
            if(currentLink.next!=null){
                currentLink = currentLink.next;
            }else{
                return null; //Item to delete does not exist.
            }
        }
        System.out.println("Previous link: " + previous);
        System.out.println("Link to be deleted: " + currentLink);
        if(currentLink == first){
            System.out.println("Deleting the first link");
            first = first.next;
        }else {
            System.out.println("Not deleting the first link");
            previous.next = currentLink.next;
        }
        return currentLink;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(1, 3.5);
        linkedList.insertFirst(2, 4);
        linkedList.insertFirst(3, 2);
        linkedList.insertFirst(4, 7);
        linkedList.insertFirst(5, 8);
        System.out.println(linkedList);
        linkedList.deleteFirst();
        System.out.println(linkedList);
        Link foundLink = linkedList.find(4);
        System.out.println(foundLink);

        System.out.println("Deleted link: " + linkedList.deleteLink(4));

        System.out.println(linkedList);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Link currentLink = first;

        while(currentLink != null){
            sb.append(currentLink+"\n");
            currentLink = currentLink.next;
        }
        return sb.toString();
    }



    class Link {
        int id;
        double data;
        Link next;

        Link(int id, double data){
            this.id = id;
            this.data = data;
        }

        @Override
        public String toString(){
            return String.format("Link: id:%d data:%f", this.id, this.data);
        }
    }
}
