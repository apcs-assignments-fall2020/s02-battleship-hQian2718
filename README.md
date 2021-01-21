# Battleship

For homework, you write a couple methods to practice working with 2D arrays.

The first two methods that we will write today be related to the board game Battleship. In Battleship, each player has a board that they place their ships onto. We will represent the board as a 2D array of **booleans**. The value true (T) will represent that a boat is present at that coordinate, while the value false (f) will represent that a boat is not present at that coordinate. 

For instance, the following shows a board where this is a boat of length 5, that is placed vertically, with its top located at (0, 1). Again, **T** represents true (there is a boat there), while **f** represents false (there is no boat there).

```shell script
f T f f f f f f f f
f T f f f f f f f f
f T f f f f f f f f
f T f f f f f f f f
f T f f f f f f f f
f f f f f f f f f f
f f f f f f f f f f
f f f f f f f f f f
f f f f f f f f f f
f f f f f f f f f f
```

First, write a method hit() that returns a boolean and is given as input a board (2D array of booleans), a row, and a col. The method returns true if there is a boat located at that coordinate, or false otherwise. The method should also print out "There was a hit!" or "You missed a boat!" for the appropriate case. The method should have the following signature:

```shell script
public static boolean hit(boolean[][] board, int row, int col) { }
```

<br />
<br />

Next, write a method placeBoat() that is given a board (2D array of booleans), a direction (either "down" or "right"), a boat length (specifies how many pieces long a boat is), a row, and a col. This method will add a boat of the given length to the board, with the top-left piece located at the coordinates specified by row and col, and the remaining pieces in the direction specified by the direction input. Then, the method returns the new board. 

For instance, let's say we have the following empty board: 
```shell script
f f f f f f
f f f f f f
f f f f f f
f f f f f f
f f f f f f
f f f f f f
```
Let's say that we call our method with this board, and the other inputs are as follows: direction = "right", boat length = 3, row = 1, col = 2.

Our method should return the following board. Note that the top-left piece of the boat was placed at row = 1, col = 2 and the remaining two pieces were placed to the right of that coordinate:
```shell script
f f f f f f
f f T T T f
f f f f f f
f f f f f f
f f f f f f
f f f f f f
```
Alternatively, let's say that our inputs were the above outputted board, direction = "down", boat length = 4, row = 2, col = 5. Then, we'd return the following board. Note that the top-left piece of the boat was placed at row = 2, col = 5 and the remaining three pieces were placed below that coordinate:
```shell script
f f f f f f
f f T T T f
f f f f f T 
f f f f f T 
f f f f f T 
f f f f f T 
```

You may assume that the boat will fit on the board. It is also okay if a boat overlaps with a previous boat. This method should have the following signature:
```shell script
public static boolean[][] placeBoat(boolean[][] board, String direction, int boatLength int row, int col) { }
```

<br />
<br />

The final method is unrelated to Battleship. Write a method that is given a 2D array of Strings, and returns true if each row is in both order of increasing length words and in alphabetical order, and false otherwise.

For instance, the following 2D array meets these criterea:
```shell script
anchor boating catamaran
boat cruise fishing
```

But this 2D array does not meet the criterea ("boat" is shorter than "anchor")
```shell script
galleon helmsman
anchor boat 
```

This method should have the following signature:
```shell script
public static boolean inOrder(String[][] words) { }
```

<br />

## Run your code with:
```shell script
make run
```

## Run your tests with:
```shell script
make test
```