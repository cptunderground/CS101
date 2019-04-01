public class InnerNode extends Node
{
    private Node leftChild;
    private Node rightChild;

    public InnerNode(int keyValue)
    {
        super(keyValue);
    }

    public Node getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(Node leftChild)
    {
        this.leftChild = leftChild;
    }

    public Node getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(Node rightChild)
    {
        this.rightChild = rightChild;
    }

    
}
