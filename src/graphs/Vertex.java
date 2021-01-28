package graphs;

public class Vertex {

    private final String label;
    private boolean visited;

    Vertex(String label){
        visited = false;
        this.label = label;
    }

    @Override
    public String toString(){
        return "Vertex: " + label;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Vertex){
            return ((Vertex) obj).label.equals(this.label);
        }
        return false;
    }

    public boolean isVisited(){
        return this.visited;
    }

    public void setVisited(boolean isVisited){
        this.visited = isVisited;
    }

    public String getLabel(){
        return this.label;
    }


}
