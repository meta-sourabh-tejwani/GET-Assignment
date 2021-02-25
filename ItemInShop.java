class Item
{
	private String name;
	private int quantity;
	private float price;
	Item(String name,int quantity,float price)
	{
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

public class ItemInShop {
	public Item item[];
	public ItemInShop()
	{
		addItem();
	}
	public void addItem()
	{
		item=new Item[4];
		item[0]=new Item("Shampoo",12,200);
		item[1]=new Item("mango",12,60);
		item[2]=new Item("apple",12,80);
		item[3]=new Item("wheat",12,200);
	}

}
