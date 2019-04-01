/**
 * A binary search tree is a tree that, like, searches binaries... in a tree. Yeah...   www.reddit.com/r/trees/
 */
public class SearchTree
{
    private Node root;

    public SearchTree(Node root)
    {
        this.root = root;
    }

    public void insert(int key, String value)
    {
        Leaf leaf = new Leaf(key, value);

        Node currentNode = root;
        Node previousNode = null;

        while (currentNode instanceof InnerNode)
        {
            previousNode = currentNode;
            InnerNode temp = (InnerNode) currentNode;
            if (leaf.getKey() <= currentNode.getKey())
            {
                currentNode = temp.getLeftChild();
            }
            else
            {
                currentNode = temp.getRightChild();
            }
        }

        if (previousNode == null)
        {
            if (leaf.getKey() <= currentNode.getKey())
            {
                InnerNode n = new InnerNode(leaf.getKey());
                n.setLeftChild(leaf);
                n.setRightChild(currentNode);
                root = n;
            }
            else
            {
                InnerNode n = new InnerNode(currentNode.getKey());
                n.setLeftChild(currentNode);
                n.setRightChild(leaf);
            }
        }
        else
        {
            if (currentNode instanceof Leaf)
            {
                if (leaf.getKey() <= currentNode.getKey())
                {
                    InnerNode n = new InnerNode(leaf.getKey());
                    n.setLeftChild(leaf);
                    n.setRightChild(currentNode);
                    InnerNode temp = (InnerNode) previousNode;
                    if (currentNode == temp.getLeftChild())
                    {
                        temp.setLeftChild(n);
                    }
                    else
                    {
                        temp.setRightChild(n);
                    }
                }
                else
                {
                    InnerNode n = new InnerNode(currentNode.getKey());
                    n.setLeftChild(currentNode);
                    n.setRightChild(leaf);
                    InnerNode temp = (InnerNode) previousNode;
                    if (currentNode == temp.getLeftChild())
                    {
                        temp.setLeftChild(n);
                    }
                    else
                    {
                        temp.setRightChild(n);
                    }
                }
            }
            else
            {
                System.out.println("ERROR");
            }
        }
    }

    public String search(int searchKey)
    {
        Node here = root;

        while (here instanceof InnerNode)
        {
            InnerNode temp = (InnerNode) here;
            if (searchKey <= here.getKey())
            {
                here = temp.getLeftChild();
            }
            else
            {
                here = temp.getRightChild();
            }
        }

        if (here instanceof Leaf && searchKey == here.getKey())
        {
            return ((Leaf) here).getValue();
        }
        else
        {
            return null;
        }
    }

    
}
