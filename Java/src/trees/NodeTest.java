package trees;

public class NodeTest {

    NodeTest left;
    NodeTest right;
    int data;

    public NodeTest(int data){
        this.data = data;
    }

    @Override
    public String toString(){
        return String.format("Node: " + data);
    }


}
