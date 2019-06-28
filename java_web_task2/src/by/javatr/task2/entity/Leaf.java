package by.javatr.task2.entity;
/**
 * Class Leaf.
 */
public class Leaf implements Component {
    //private static Logger LOGGER = Logger.getLogger(Leaf.class);

    private String leaf;

    public Leaf() {
    }

    public Leaf(String leaf) {
        //LOGGER.debug("Start Leaf constructor");
        this.leaf = leaf;
    }

    @Override
    public String toText() {
       // LOGGER.debug("Start Leaf toText");
        return this.toString();
    }

    @Override
    public String toString() {
        //LOGGER.debug("Start Leaf toString");
        return leaf;
    }
}
