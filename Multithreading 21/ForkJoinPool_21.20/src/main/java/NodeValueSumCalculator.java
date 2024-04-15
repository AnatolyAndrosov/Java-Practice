import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NodeValueSumCalculator extends RecursiveTask<Long> {

    private Node node;

    public NodeValueSumCalculator (Node node){
        this.node = node;
    }


    @Override
    protected Long compute() {

        long sum = node.getValue();
        List<NodeValueSumCalculator> taskList = new ArrayList<>();
        for(Node child : node.getChildren)
        return null;
    }
}
