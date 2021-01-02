import java.util.*;

public class checkout {
	// the cart that holds all items
	public static HashMap<String, Integer> cart = new HashMap<>();
	// the special price and quantity threshold for each item
	public static HashMap<String, itemOffer> itemSpecialPriceMap = new HashMap<>();
	// the regular price of each item
	public static HashMap<String, Integer> itemPriceMap = new HashMap<>();

	public static void setSpecialPriceRules(String item, int quantity, int specialPrice) {
		itemSpecialPriceMap.put(item, new itemOffer(quantity, specialPrice));
	}

	public static void setRegularPriceRules(String item, int price) {
		itemPriceMap.put(item, price);
	}

	public static void scan(String item, int quantity) {
		if(!cart.containsKey(item))
			cart.put(item, quantity);
		else {
			cart.put(item, quantity + cart.get(item));
		}
	}

	public static int getTotal() {
		int total = 0;

		// loop through all items in the cart
	   	for (String item : cart.keySet()) {
	   		// get the quantity of each item
	     	int quantity = cart.get(item);

			// if there is a special price for an item
		    if (itemSpecialPriceMap.containsKey(item)) {
		    	itemOffer thisOffer = itemSpecialPriceMap.get(item);

		    	// if the item in the cart reaches the threshold for special price
		    	if (thisOffer.quantity <= quantity) {
		    		// mod for the remainder multiply the regular price, division for special price
		    		total = total + (quantity % thisOffer.quantity) * itemPriceMap.get(item) + (quantity / thisOffer.quantity) * thisOffer.price;
		    	} else {
		    		// regular price
		    		total = total + quantity * itemPriceMap.get(item);
		    	}
		    } else {
		    	// regular price
		    	 total = total + quantity * itemPriceMap.get(item);
		    }
		}
		return total;
	}
}
