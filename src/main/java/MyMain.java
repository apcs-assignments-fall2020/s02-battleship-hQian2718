import javax.lang.model.util.ElementScanner6;

public class MyMain {
    // This method returns true/false if there 
    // was a boat the specified coordinates. This
    // method also prints out an appropriate message
    static int[][] dir = {{1,0},{0,1}};  //down, right

    public static boolean hit(boolean[][] board, int row, int col) { 
        boolean isHit = false;
        if(row < board.length && col < board[row].length)   isHit = board[row][col];
        if(isHit)   System.out.println("There was a hit!");
        else        System.out.println("You missed a boat!");
        return isHit;
    }


    // Places a boat onto the board
    // The top-left piece of the board is located at (row, col)
    // The remaining pieces are placed in the direction given
    // by the direction input
    public static boolean[][] placeBoat(boolean[][] board, String direction, int boatLength, int row, int col) { 
        int idx = direction.length() - 4;
        int endRow = row + boatLength * MyMain.dir[idx][0];
        int endCol = col + boatLength * MyMain.dir[idx][1];

        if(row >= 0 && col >= 0 && endRow < board.length && endCol < board[endRow].length){
            for(int i = 0; i < boatLength; i ++){
                board[row + MyMain.dir[idx][0] * i][row + MyMain.dir[idx][1] * i] = true;
            }
        }
        return board;
    }

    // Returns true if the every row in the 2D array
    // is in both alphabetical order and in order of 
    // increasing length
    // You may assume that all Strings are lowercase 
    public static boolean inOrder(String[][] words) { 
        boolean result = true;
        int i = 0;
        int j = 0;
        int idx = 0, l1, l2;
        char c1, c2;

        while(result && i < words.length){
            j = 1;
            while(result && j < words[i].length){
                l1 = words[i][j-1].length();
                l2 = words[i][j].length();
                if(l2 - l1 < 0)	result = false;
                idx = 0;
                while(result){
                    c1 = words[i][j-1].charAt(idx);
                    c2 = words[i][j].charAt(idx);
                    idx++;
                    if(idx == l1 && l1 != l2)   continue;
                    else if(idx == l2)  result = false;    
                    else if(c2 - c1 > 0) break;
                    else if(c2 - c1 == 0)   idx++;
                    else    result = false;
                }
                j++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        // You can test your code here
        boolean[][] board = {   {true, true, true, false, false}, 
                                {false, false, false, false, false},
                                {false, true, true, true, false},
                                {false, false, false, false, false},
                                {false, false, false, false, false} };
        
        boolean[][] newBoard = placeBoat(board, "right", 3, 0, 0);

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        String[][] arr =    {{"anchor", "boating", "catamaran"},
                             {"boat", "cruise", "fishing"}};
        
        System.out.println(inOrder(arr));
    }
}
/*
Hi Nathan, 

The tester showed an error message for my placeBoat method. However, the case that I failed seems to not make sense.

It says that placing with direction = "right", boatLength = 3, row = 0, col = 0 on the folliowing board:

  { {T, T, T, f, f}, 
    {f, f, f, f, f},
    {f, T, T, T, f},
    {f, f, f, f, f},
    {f, f, f, f, f} }

Should output this board:

 [[T, T, T, f, f], 
  [f, f, T, f, f], 
  [f, f, T, f, f], 
  [f, f, T, f, f], 
  [f, f, T, f, f]]

  But that doesn't make sense: the original board had a boat on 0,0 already, so placing a new one there shouldn't change anything.
  That was indeed what my method did:

   T T T f f 
   f f f f f 
   f T T T f 
   f f f f f 
   f f f f f 

   Is there perhaps some mistake with the test code?

   Thanks!
   Harry
 */