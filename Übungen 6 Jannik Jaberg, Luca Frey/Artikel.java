public class Artikel{
	private String name;
	private int quantity;
	private double price;

	public Artikel(String name, int quantity, double price){
		this.name = name;
		this.quantity = quantity;
		this.price = price;

	}

	public double getPrice(){
		return (quantity*price);
	}

	public void print(){
		 System.out.println("  " + String.format("%-15s", name)  + quantity + "x  " + String.format("%.2f",price) + "\n\t\t\t" + String.format("%.2f",getPrice()) + '\n');
	}
}