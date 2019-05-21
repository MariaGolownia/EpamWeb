package by.javatr.entity;

public class Leaf implements Component {
    private String leaf = "";

    public Leaf(String leaf) {
        this.leaf = leaf;
    }

    @Override
    public String toText() {
        return this.toString();
    }

    @Override
    public String toString() {
        return leaf;
    }
}
