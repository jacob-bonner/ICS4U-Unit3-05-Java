/*
* This program finds and prints all 3 by 3 magic number sets that add to 15.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2021-01-08
*/

public class MagicSquare {
  /**
   * This function prints a magic square should one be found.
   */
  static void printSquare(int[] printList) {
    for (int printCounter = 0; printCounter < printList.length; printCounter++) {
      System.out.print(printList[printCounter] + " ");
      // Checking if three numbers are on a line
      if ((printCounter + 1) % 3 == 0) {
        System.out.println("");
      } else {
        continue;
      }
    }
    System.out.println("*****");
  }

  /**
   * This function finds and prints all 3 by 3 magic number sets that add to 15.
   */
  static void solveSquares(int[] numberList, int[] indexList, int index) {
    // This loop itterates to fill out a square of numbers
    for (int counter = 0; counter < numberList.length; counter++) {
      // Checking if a slot in the square has been occupied
      if (indexList[counter] == 0) {
        numberList[counter] = index;
        indexList[counter] = 1;

        // Checking if the index is less than nine
        if (index < 9) {
          // Calling function again to continue creating square
          solveSquares(numberList, indexList, index + 1);
        } else {
          // Checking if every linear combination of three numbers adds to 15
          if (isSquareMagic(numberList) == true) {
            // Printing out the square that was found
            printSquare(numberList);
          }
        }

        // Reseting part of the square to 0 so it can be filled again
        indexList[counter] = 0;
      }
    }
  }

  /**
   * This function determines whether or not a square is a magic square.
   */
  static boolean isSquareMagic(int[] squareList) {
    // Performing math that determines the sum of array number combinations
    int firstRow = squareList[0] + squareList[1] + squareList[2];
    int secondRow = squareList[3] + squareList[4] + squareList[5];
    int thirdRow = squareList[6] + squareList[7] + squareList[8];
    int firstColumn = squareList[0] + squareList[3] + squareList[6];
    int secondColumn = squareList[1] + squareList[4] + squareList[7];
    int thirdColumn = squareList[2] + squareList[5] + squareList[8];
    int firstDiagonal = squareList[0] + squareList[4] + squareList[8];
    int secondDiagonal = squareList[2] + squareList[4] + squareList[6];

    // If statement that finds whether or not the numbers form a magic square
    if (firstRow == 15 && secondRow == 15 && thirdRow == 15 &&
        firstColumn == 15 && secondColumn == 15 && thirdColumn == 15 &&
        firstDiagonal == 15 && secondDiagonal == 15) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This function passes variables into a function that will find print all
   * 3 by 3 magic number sets that add to 15.
   */
  public static void main(String[] args) {
    // Initializing the list that will be used in determining the magic squares
    int[] firstList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] secondList = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Printing the inital dividing line
    System.out.println("*****");

    // Calling the function that will solve the magic squares
    solveSquares(firstList, secondList, 1);
  }
}
