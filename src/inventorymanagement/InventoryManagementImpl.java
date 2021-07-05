package inventorymanagement;

import java.util.LinkedList;

public class InventoryManagementImpl implements InventoryManagement 
{

	//Using Linkedlist to store details of each item.
		LinkedList<Items> inventory = new LinkedList<>();
		
		public void addInventoryItems(Items items)
		{
			//checks if items is already present or not.
			if(inventory.contains(items))
			{
				System.err.println("Item already exists , Add new non existing item.");
			}
			else
			{
				inventory.add(items);
			}
		}
		
		//Display item names  before selection.
		@Override
		public void printItemNames()
		{	
			System.out.println("Following are the items present in inventory.");
			for(Items iterator : inventory)
			{
				System.out.print(iterator.getItemName() + " ");
			}
		}
		//display selected item details
		@Override
		public void printSelectedItemDetails(String userItemName)
		{
			for(Items iterator : inventory)
			{
				if(iterator.getItemName().equals(userItemName))
				{
					double itemValue = iterator.getItemTotalWeight()*iterator.getItemPricePerKg();
					System.out.println("Details of selected item : " + iterator.getItemName() + iterator + " and its total value is : " + itemValue + "\n");
				}
			}
		}
		
		//Calculating total value of all items present in inventory.
		@Override
		public void calculateValueOfInventory()
		{
			double inventoryValue = 0.0;
			for(Items iterator : inventory)
			{
				double itemValue = iterator.getItemTotalWeight()*iterator.getItemPricePerKg();
				inventoryValue += itemValue;
				System.out.println("Total value of item " + iterator.getItemName() + " is : " + itemValue);
			}
			System.out.println("Total value of inventory is : " + inventoryValue );
		}
		
		//Display all details of all items.
		@Override
		public void printAllItemsDetails()
		{
			System.out.println("\n" + "Following are the items present in inventory.");
			for(Items iterator : inventory)
			{
				System.out.println(iterator);
			}
			System.out.println(" ");
		}
}


