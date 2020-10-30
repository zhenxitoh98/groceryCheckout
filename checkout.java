import java.util.*;

public class checkout {
	public static HashMap<String, Integer> itemsListMap = new HashMap<>();
	public static HashMap<String, itemOffer> itemOfferMap = new HashMap<>();
	public static HashMap<String, Integer> itemPriceMap = new HashMap<>();

	public static void setSpecialPriceRules(String item, Integer quantity, Integer specialPrice) {
		itemOfferMap.put(item, new itemOffer(item, quantity, specialPrice));
	}

	public static void setRegularPriceRules(String item, Integer price) {
		itemPriceMap.put(item, price);
	}

	public static void scan(String item, Integer quantity) {
		if(!itemsListMap.containsKey(item))
			itemsListMap.put(item, quantity);
		else {
			itemsListMap.put(item, quantity + itemsListMap.get(item));
		}
	}

	public static Integer getTotal() {
		Integer total = 0;

	   	for (String item : itemsListMap.keySet()) {
	     	Integer quantity = itemsListMap.get(item);

		    if (itemOfferMap.containsKey(item)) {
		    	itemOffer thisOffer = itemOfferMap.get(item);

		    	if (thisOffer.quantity <= quantity) {
		    		total = total + (quantity % thisOffer.quantity) * itemPriceMap.get(item) + (quantity / thisOffer.quantity) * thisOffer.price;
		    	} else {
		    		total = total + quantity * itemPriceMap.get(item);
		    	}
		    } else {
		    	 total = total + quantity * itemPriceMap.get(item);
		    }
		}
		return total;
	}
}
