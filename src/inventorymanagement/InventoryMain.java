package inventorymanagement;

import java.util.Scanner;

public class InventoryMain
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		InventoryManagementImpl inventorymanagement = new InventoryManagementImpl();
		
		System.out.println("Welcome to Inventory Management Program");
		
		boolean isExit = false;
		while(!isExit)
		{	
			System.out.println("Enter a number  :\n1 - Enter items in inventory."
					+ "\n2 - Print details of particular item.\n3 - Print total value of inventory.\n4 - Display whole items.\n5 - Exit.");
			int user = scanner.nextInt();
			switch(user)
			{
				case 1 :
				{
					System.out.print("Enter a number to store number of items in inventory : ");
					int numberOfItmes = scanner.nextInt();
					
					//User input to store the items inside inventory.
					for(int itemCount = 1; itemCount <= numberOfItmes; itemCount++)
					{	
						Items itemsObject = new Items();
						System.out.print("Enter Item Name : ");
						itemsObject.setItemName(scanner.next());
						System.out.print("Enter Total Weight : ");
						itemsObject.setItemTotalWeight(scanner.nextDouble());
						System.out.print("Enter Price Per Kg : ");
						itemsObject.setItemPricePerKg(scanner.nextDouble());
						inventorymanagement.addInventoryItems(itemsObject);
					}
					System.out.println("\n" + "All the items inserted sucessfully !" + "\n");
					break;
				}
				case 2 :
				{
					//Printing Only items names for selection.
					inventorymanagement.printItemNames();
					
					System.out.print( "\n" + "Enter any one of the above item name to display its details : ");
					String userItemName = scanner.next();
					inventorymanagement.printSelectedItemDetails(userItemName);
					break;
				}
				case 3 :
				{
					//Calculating value of inventory.
					inventorymanagement.calculateValueOfInventory();
					break;
				}
				case 4 :
				{
					//Displaying all items present in inventory.
					inventorymanagement.printAllItemsDetails();
					break;
				}
				case 5 :
				{
					isExit = true;
				}
			}
		}
		scanner.close();
	}
}


