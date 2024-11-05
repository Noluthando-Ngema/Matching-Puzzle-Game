/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.puzzlegame;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class PuzzleGame extends GameGrid {

    public PuzzleGame(int size){ //constructor which sets grid size
      super(size);
  }
    public static void main(String[] args) {
        PuzzleGame puzzle=new PuzzleGame(4);
        puzzle.playGame();                                           
    }
    public void playGame(){ //method which enable the user to play the game
        System.out.println("WELCOME TO MATCH THE PUZZLE NUMBERS");
        Scanner scan=new Scanner(System.in);
        while (!isGameComplete()){ //while loop to keep game going until its complete
            printPuzzleGrid(); //displays the status of the grid
            System.out.println("Enter the first position for the row and column: "); //gets first user input
            int row1=scan.nextInt();
            int col1=scan.nextInt();
            if(isRevealed(row1,col1)){
                System.out.println("Try again, position already revealed");
                continue; //allows user to try again
            }
            reveal(row1,col1); //reveals the first cell
            printPuzzleGrid();
            System.out.println("Enter second position for the row and column: "); //gets second user input
            int row2=scan.nextInt();
            int col2=scan.nextInt();
            if(isRevealed(row2,col2)){
                System.out.println("Try again, position already revealed");
                hide(row1,col1); //hides the first cell
                continue;
            }
            reveal(row2,col2); //reveals the second cell
            printPuzzleGrid();
            if (getGridValue(row1,col1)==getGridValue(row2,col2)){
                System.out.println("It's a match!!!");
            } else{
                System.out.println("It's not a match!!!");
                hide(row1,col1); //hide the first cell
                hide(row2,col2); //hide the second cell
           }
         }
        System.out.println("WINNER!!!");
        scan.close();
    }
    private void printPuzzleGrid(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (isRevealed(i,j)){
                    System.out.print(getGridValue(i,j)+"");
                } else{
                    System.out.println("*");
                }
            }
            System.out.println();
        }
    }
}
