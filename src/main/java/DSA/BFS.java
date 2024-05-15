package DSA;

import java.util.*;

public class BFS {

    BFS() {

    }

    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode next;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelList);
        }
        return result;
    }

    public List<Double> averageOfLevel(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(sum / queue.size());
        }


        return result;
    }

    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }


    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        boolean revere = false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {

                if (!revere) {
                    TreeNode currentNode = deque.pollFirst();
                    currentLevelList.add(currentNode.val);

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.right);
                    }

                    if (currentNode.right != null) {
                        deque.addLast(currentNode.left);
                    }
                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentLevelList.add(currentNode.val);

                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    currentLevelList.add(currentNode.val);

                }
            }
            result.add(currentLevelList);
            revere = !revere;
        }
        return result;
    }


    public boolean isSymmetric(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public List<Integer> rightSideView(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
            TreeNode currentNode = queue.poll();

            if (i == levelSize - 1) {
                result.add(currentNode.val);
            }

            if (currentNode.left != null) {
                queue.offer(node.left);
            }

            if (currentNode.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = root;

        while (leftNode.left != null) {
            TreeNode current = leftNode;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }

//    public boolean isCousins(TreeNode root,TreeNode x, TreeNode y){
//        TreeNode xx =
//    }

}
