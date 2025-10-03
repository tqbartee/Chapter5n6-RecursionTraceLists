import java.util.ArrayList;

public class ShoppingList {
    String shoppingListName;
    ArrayList<String> myList = new ArrayList<>();

    public ShoppingList() {
        shoppingListName = "Groceries for Friday";

        // TODO: add book example 7.1.1 here to populate myList
        // Instead of the book character examples (A. B. C, D, E, F)
        // Use (Apple, Burrito, Carrot, Doughnut, Enchilada, Falafel)
        // put in myList
        // Java reference: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
        // Note: the list will propagate back to the caller
        // because it is part of the object
        // see object declaration above

        myList.add("Replace this line with your code...");

    }

    public static String test() {
        ShoppingList myShoppingList = new ShoppingList();
        StringBuilder sb = new StringBuilder();
        sb.append(myShoppingList.shoppingListName + "\n");
        sb.append(myShoppingList.myList.toString());
        String returnString = sb.toString();
        return returnString;
    }

    public static void main (String[] args) {
        String myShoppingList = test();
        System.out.println(myShoppingList);
    }

}
