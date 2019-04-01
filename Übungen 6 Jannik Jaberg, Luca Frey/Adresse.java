public class Adresse
{
	private String[] columns;
	int len = 30;

	public Adresse(String... columns)
	{
		this.columns = columns.clone();
	}

	public String center(String text) {
        int l = text.length();
        int dif1 = (len - l) / 2;
        int dif2 = len - dif1 - l;
        String out = String.format("%-" + dif1 + "s%s%" + dif2 + "s", "|", text, "|");
        return out;
    }

	public  void print(){
		for (String s : columns) {
			System.out.println(center(s));
		}
	}
}