import desu.answermap.AnswerMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchStackTest {
    // Create AnswerMap for use in all tests
    AnswerMap SB2AnswerMap = new AnswerMap();
    String Answer1 = SB2AnswerMap.map.get("Answer1");
    String Answer2 = SB2AnswerMap.map.get("Answer2");

    // Part 1
    @Test
    void test1() {
        System.out.println("we are here");
        BinarySearchStack myBinarySearchStack = new BinarySearchStack();
        String summaryString = myBinarySearchStack.testNoDisplay();
        Assertions.assertEquals(Answer1, summaryString);
    }

    @Test
    void test2() {
        System.out.println("we are here");
        String shoppingList = ShoppingList.test();
        Assertions.assertEquals(Answer2, shoppingList);
    }


}