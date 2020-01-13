package queueandstack;

import java.util.*;

public class BFS {

    private static class Node {
        private int val;
        private List<Node> edges;
        Node(int val){
            this.edges = new ArrayList<>();
            this.val = val;
        }
    }

    public static int templateI(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
        Set<Node> visited = new HashSet<>();
        int step = 0;       // number of steps needed from root to current node
        // initialize
        queue.add(root);
        visited.add(root);
        // BFS
        while (!queue.isEmpty()) {
            step++;
            // iterate the nodes which are already in the queue
            Node cur = queue.poll();
            if(cur == target){
                return step;
            }
            List<Node> edges = cur.edges;
            for (Node next: edges) {
                if(!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return -1; // there is no path from root to target
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        Node ninth = new Node(9);
        Node tenth = new Node(10);

        Node eleventh = new Node(10);

        first.edges.add(second);
        first.edges.add(third);
        first.edges.add(fourth);

        second.edges.add(fifth);
        second.edges.add(third);
        second.edges.add(eleventh);

        third.edges.add(fourth);
        third.edges.add(sixth);
        third.edges.add(eighth);

        fourth.edges.add(seventh);
        fourth.edges.add(ninth);
        fourth.edges.add(tenth);

        fifth.edges.add(eleventh);

        eleventh.edges.add(seventh);

        int steps = templateI(first, seventh);

        System.out.println(String.format("It to %s steps to find %s from %s", steps, seventh.val, first.val));
    }
}
