import java.util.*;

class ShoppingCart
{	
	private ItemInShop itemInShop=new ItemInShop();
	private Map<String,Float> cartItemPrice=new HashMap<>();
	private Map<String,Integer> cartItemQuantity=new HashMap<>();
	
	/*  Add item in cart if item present in shop else showing item not present in shop with required quantity*/
	public void addItem(String itemName,int itemQuantity)
	{
		boolean taskComplete=false;
		for(int i=0;i<itemInShop.item.length;i++)
		{
			String shopItemName=itemInShop.item[i].getName();
			int  shopItemQuantity=itemInShop.item[i].getQuantity();
			if(shopItemName.equals(itemName) && itemQuantity<=shopItemQuantity)
			{
				cartItemQuantity.put(itemName,itemQuantity);
				cartItemPrice.put(itemName,itemInShop.item[i].getPrice());
				itemInShop.item[i].setQuantity(shopItemQuantity-itemQuantity);
				taskComplete=true;
				break;
			}
		}
		if(taskComplete == true)
		{
			System.out.println("Item Inserted in cart.....");
		}
		else
		{
			System.out.println("We can not add item due to unavailability or shortagee of item");
		}
			
	}
	
	/* delete item in cart if item added in cart */
	public void deleteItem(String itemName)
	{
		if(cartItemQuantity.containsKey(itemName))
		{
			for(int i=0;i<itemInShop.item.length;i++)
			{
				if (itemInShop.item[i].getName().equals(itemName))
				{
					int shopQuantity=itemInShop.item[i].getQuantity();
					itemInShop.item[i].setQuantity(cartItemQuantity.get(itemName)+shopQuantity);
					break;
				}
			}
			cartItemQuantity.remove(itemName);
			cartItemPrice.remove(itemName);
			System.out.println("Item Deleted.....");
		}
		else{
			System.out.println("Item not added in Cart...");
		}
	}
	
	/* Display item quantity and price present in shop*/
	public void itemPresent()
	{
		System.out.println("ITEM present in shop.....");
		String item=String.format("%10s","ITEM");
		String price=String.format("%10s","PRICE");
		String quantity=String.format("%10s","QUANTITY");
		System.out.println(item+price+quantity);
		for(int i=0;i<itemInShop.item.length;i++)
		{
			item=String.format("%10s",itemInShop.item[i].getName());
			price=String.format("%10s",itemInShop.item[i].getPrice());
			quantity=String.format("%10s",itemInShop.item[i].getQuantity());
			System.out.println(item+price+quantity);
		}
	}
	
	/* Generate bill those item who present in Cart*/
	public void generateBill()
	{
		float total=0f;
		String item=String.format("%10s","ITEM");
		String price=String.format("%10s","PRICE");
		String quantity=String.format("%10s","QUANTITY");
		System.out.println(item+price+quantity);
		for(String itemincart:cartItemPrice.keySet())
		{
			float priceitem=cartItemPrice.get(itemincart);
			int quantityitem=cartItemQuantity.get(itemincart);
			float purchasetotalPrice=priceitem*quantityitem;
			total+=purchasetotalPrice;
			item=String.format("%10s",itemincart);
			price=String.format("%10s",purchasetotalPrice);
			quantity=String.format("%10s",quantityitem);
			System.out.println(item+price+quantity);
		}
		System.out.println("Total payment: "+total);
	}
	
	/* Display item and quantity present in cart*/
	public void itemInCart()
	{
		String item=String.format("%10s","ITEM");
		String quantity=String.format("%10s","QUANTITY");
		for(String iteminCart:cartItemQuantity.keySet())
		{
			item=String.format("%10s",iteminCart);
			quantity=String.format("%10s",cartItemQuantity.get(iteminCart));
			System.out.println(item+quantity);
		}
	}
	
	/*update cart item and quantity if require quantity present in shop*/
	public void updateItem(String itemName,int newQuantity)
	{
		if(cartItemQuantity.containsKey(itemName))
		{
			boolean updatedtask=false;
			for(int i=0;i<itemInShop.item.length;i++)
			{
				if(itemInShop.item[i].getName().equals(itemName))
				{
					int addQuantity=cartItemQuantity.get(itemName);
					int shopQuantity=itemInShop.item[i].getQuantity();
					if(addQuantity+shopQuantity>=newQuantity)
					{
						itemInShop.item[i].setQuantity(addQuantity+shopQuantity-newQuantity);
						cartItemQuantity.replace(itemName, newQuantity);
						
						updatedtask=true;
					}
					break;
				}
			}
			if(updatedtask == false)
			{
				System.out.println("Item Does not update due to shortage of quantity....");
			}
			else
			{
				System.out.println("Item updated.....");
			}
		}
		else
		{
			System.out.println("Item not added in cart.....");
		}
	}
}
public class Assignment1
{
	public static void main(String...k)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to shop...");
		ShoppingCart shoppingcart=new ShoppingCart();
		int n;
		do
		{
			System.out.println("Enter 1 to add Item in cart....");
			System.out.println("Enter 2 to delete Item in cart....");
			System.out.println("Enter 3 to generate bill.....");
			System.out.println("Enter 4 to show item present in shop....");
			System.out.println("Enter 5 to show Item in cart.....");
			System.out.println("Enter 6 to update item quantity in Cart.....");
			System.out.println("Enter 7 to End shopping.....");
			n=sc.nextInt();
			switch(n)
			{
			case 1:System.out.println("Enter Item Name and Required Quantities....");
					String itemName=sc.next();
					int itemQuantity=sc.nextInt();
					shoppingcart.addItem(itemName, itemQuantity);
					System.out.println("#####################################");
					break;

			case 2:System.out.println("Enter Item Name to delete item in cart....");
					itemName=sc.next();
					shoppingcart.deleteItem(itemName);
					System.out.println("#####################################");
					break;
					

			case 3:
					shoppingcart.generateBill();
					System.out.println("#####################################");
					break;
			
			case 4:shoppingcart.itemPresent();
					System.out.println("#####################################");
					break;
					
			case 5:shoppingcart.itemInCart();
					System.out.println("#####################################");
						break;
			
			case 6:System.out.println("Enter Item Name and Update Quantities....");
					itemName=sc.next();
					itemQuantity=sc.nextInt();
					shoppingcart.updateItem(itemName, itemQuantity);
					System.out.println("#####################################");
					break;
				
			case 7:System.out.println("Thank You......");
					break;
				
			default:System.out.println("Enter Correct Number");
					
			}
		}while(n!=7);
		sc.close();
	}
}