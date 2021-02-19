import java.util.*;
class ShoppingCart
{
	private static String[] presentItemName={"shampoo","apple","mango","wheat"};
	private static int[] presentItemQuantity={12,12,12,12,12};
	private static float[] presentItemPrice={200,120,70,40,23};
	private Map<String,Float> cartItemPrice=new HashMap<>();
	private Map<String,Integer> cartItemQuantity=new HashMap<>();
	
	public void addItem(String itemName,int itemQuantity)
	{
		int flag=0;
		for(int i=0;i<presentItemName.length;i++)
		{
			if(presentItemName[i].equals(itemName) && itemQuantity<=presentItemQuantity[i])
			{
				cartItemQuantity.put(itemName,itemQuantity);
				cartItemPrice.put(itemName,presentItemPrice[i]);
				presentItemQuantity[i]-=itemQuantity;
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println("Item Inserted in cart.....");
		}
		else
		{
			System.out.println("We can not add item due to unavailability or shortagee of item");
		}
			
	}
	
	
	public void deleteItem(String itemName)
	{
		if(cartItemQuantity.containsKey(itemName))
		{
			for(int i=0;i<presentItemName.length;i++)
			{
				if (presentItemName[i].equals(itemName))
				{
					presentItemQuantity[i]+=cartItemQuantity.get(itemName);
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
	
	
	public void itemPresent()
	{
		System.out.println("ITEM present in shop.....");
		System.out.println("Item     price        quantity");
		for(int i=0;i<presentItemName.length;i++)
		{
			System.out.println(presentItemName[i]+"      "+presentItemPrice[i]+"         "+presentItemQuantity[i]);
		}
	}
	
	public void generateBill()
	{
		float total=0f;
		System.out.println("Item     price        quantity");
		for(String item:cartItemPrice.keySet())
		{
			float price=cartItemPrice.get(item);
			int quantity=cartItemQuantity.get(item);
			float itemprice=price*quantity;
			total+=itemprice;
			System.out.println(item+"      "+itemprice+"         "+quantity);
		}
		System.out.println("Total payment: "+total);
	}
	
	public void itemInCart()
	{
		System.out.println("Item            quantity");
		for(String item:cartItemQuantity.keySet())
		{
			System.out.println(item+"           "+cartItemQuantity.get(item));
		}
	}
	
	public void updateItem(String itemName,int newQuantity)
	{
		if(cartItemQuantity.containsKey(itemName))
		{
			int flag=0;
			for(int i=0;i<presentItemName.length;i++)
			{
				if(presentItemName[i].equals(itemName))
				{
					int addQuantity=cartItemQuantity.get(itemName);
					if(addQuantity+presentItemQuantity[i]>=newQuantity)
					{
						presentItemQuantity[i]+=addQuantity;
						presentItemQuantity[i]-=newQuantity;
						cartItemQuantity.replace(itemName, newQuantity);
						flag=1;
					}
					break;
				}
			}
			if(flag==0)
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
	}
}