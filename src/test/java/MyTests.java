import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class MyTests {

    @Test
    public void testHit() {
        boolean[][] board = { {false, false, false, false, false},
                              {false, false, false, false, false},
                              {false, true, true, true, false},
                              {false, false, false, false, false},
                              {false, false, false, false, false}};

        assertEquals(false, MyMain.hit(board, 1, 3), "The expected output for whether there is a hit at (1, 3) of boolean[][] \nboard = { {false, false, false, false, false}, \n       {false, false, false, false, false},\n       {false, true, true, true, false},\n       {false, false, false, false, false},\n       {false, false, false, false, false} } should be: false");


        assertEquals(true, MyMain.hit(board, 2, 2), "The expected output for whether there is a hit at (2, 2) of boolean[][] \nboard = { {false, false, false, false, false}, \n       {false, false, false, false, false},\n       {false, true, true, true, false},\n       {false, false, false, false, false},\n       {false, false, false, false, false} } should be: true");    
    }

    @Test
    public void testPlaceBoard() {
        boolean[][] board = { {false, false, false, false, false},
                            {false, false, false, false, false},
                            {false, false, false, false, false},
                            {false, false, false, false, false},
                            {false, false, false, false, false}};

        board = MyMain.placeBoat(board, "right", 3, 0, 0);

        String answer1 = "[[true, true, true, false, false], [false, false, false, false, false], [false, false, false, false, false], [false, false, false, false, false], [false, false, false, false, false]]";

        assertEquals(answer1, Arrays.deepToString(board), "Direction = \"right\", boatLength = 3, row = 0, col = 0, and \nboard = { {false, false, false, false, false}, \n       {false, false, false, false, false},\n       {false, true, true, true, false},\n       {false, false, false, false, false},\n       {false, false, false, false, false} }");

        String answer2 = "[[true, true, true, false, false], [false, false, true, false, false], [false, false, true, false, false], [false, false, true, false, false], [false, false, true, false, false]]";

        board = MyMain.placeBoat(board, "down",4, 1, 2);

        assertEquals(answer2, Arrays.deepToString(board), "Direction = \"right\", boatLength = 3, row = 0, col = 0, and \nboard = { {true, true, true, false, false}, \n       {false, false, false, false, false},\n       {false, true, true, true, false},\n       {false, false, false, false, false},\n       {false, false, false, false, false} }");
    }

    @Test
    public void testInOrder() {
        String[][] m1 = { {"anchor", "boating", "catamaran"},
                          {"boat", "cruise", "fishing"} };

        String[][] m2 = { {"galleon", "helmsman"},
                          {"anchor", "boat"} };

        assertEquals(true, MyMain.inOrder(m1), "First example in readme should be true");
        assertEquals(false, MyMain.inOrder(m2), "Second example in readme should be false");
    }
}
