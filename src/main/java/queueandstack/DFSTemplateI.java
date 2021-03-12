package queueandstack;

import java.util.HashSet;
import java.util.Set;

public class DFSTemplateI {

    static class Node {
        private Node[] edges;
        private int val;

        public Node(int val){
            this.val = val;
        }
    }

    static boolean DFS(Node cur, Node target, Set<Node> visited) {
        if(cur == target){
            return true;
        }
        Node[] nodes = cur.edges;
        for(Node node: nodes) {
            if (!visited.contains(node)) {
                visited.add(node);
                return DFS(node, target, visited);
            }

        }
        return false;
    }


    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        one.edges = new Node[]{two, eight};
        two.edges = new Node[]{five, four};
        three.edges = new Node[]{four, five, seven, six};
        four.edges = new Node[]{five, three, one};
        five.edges = new Node[]{two};
        six.edges = new Node[]{seven, eight};
        seven.edges = new Node[]{eight, one};

        Set<Node> nodes = new HashSet<>();
        boolean found = DFS(one, six, nodes);

        System.out.println(String.format("", found));
    }
}
