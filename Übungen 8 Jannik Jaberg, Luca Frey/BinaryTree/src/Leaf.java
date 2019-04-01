public class Leaf extends Node
{
    private String value;

    public Leaf(int keyValue, String stringValue)
    {
        super(keyValue);
        value = stringValue;
    }

    public String getValue()
    {
        return value;
    }

}
