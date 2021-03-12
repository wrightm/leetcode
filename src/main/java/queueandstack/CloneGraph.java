package queueandstack;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * Example 4:
 *
 *
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 *
 *
 * Constraints:
 *
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * Number of Nodes will not exceed 100.
 * There is no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */
public class CloneGraph {

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    // 1 -> 2
    // 2 -> 3
    // 3 -> 4
    // 4 -> 1

    /*
     1 ----- 2
     |       |
     |       |
     4 ----- 3
     */


    // 1 visited


    public static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Node clone = null;

        Set<Node> visited = new HashSet<>();
        Map<Node, Node> created = new HashMap<>();
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(node);

        while (!nodes.isEmpty()){
            Node nodeToClone = nodes.poll();
            if(!visited.contains(nodeToClone)) {
                visited.add(nodeToClone);
                Node newNode;
                if(!created.containsKey(nodeToClone)){
                    newNode = new Node(nodeToClone.val);
                    created.put(nodeToClone, newNode);
                    if(clone == null){
                        clone = newNode;
                    }
                } else {
                    newNode = created.get(nodeToClone);
                }
                for (Node neighbor : nodeToClone.neighbors) {
                    if(!created.containsKey(neighbor)){
                        Node newEdge = new Node(neighbor.val);
                        created.put(neighbor, newEdge);
                        newNode.neighbors.add(newEdge);
                    } else {
                        Node newEdge = created.get(neighbor);
                        newNode.neighbors.add(newEdge);
                    }
                    nodes.offer(neighbor);
                }
            }
        }
        return clone;
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
        Node nine = new Node(9);
        Node ten = new Node(10);

        one.neighbors.add(two);
        one.neighbors.add(five);
        two.neighbors.add(three);
        two.neighbors.add(six);
        three.neighbors.add(four);
        three.neighbors.add(seven);
        four.neighbors.add(one);
        four.neighbors.add(eight);
        five.neighbors.add(nine);
        six.neighbors.add(ten);

        Node clone = cloneGraph(one);
        System.out.println("DONE");
    }
    //                     1
    //                   2   5
    //           3    6        9
    //     4   7        10
    //  1 8
}
