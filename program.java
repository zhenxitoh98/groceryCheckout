public class program {
    public static void main(String[] args) {
    	checkout ck = new checkout();

        ck.setRegularPriceRules("A", 50);
        ck.setRegularPriceRules("B", 30);
        ck.setRegularPriceRules("C", 20);
        ck.setRegularPriceRules("D", 15);

        ck.setSpecialPriceRules("A", 3, 130);
        ck.setSpecialPriceRules("B", 2, 45);

        ck.scan("A", 3);
        ck.scan("B", 2);
        ck.scan("C", 0);
        ck.scan("D", 1);

        Integer totalPrice = ck.getTotal();
        System.out.println("Total Price: " + totalPrice);
    }
}
