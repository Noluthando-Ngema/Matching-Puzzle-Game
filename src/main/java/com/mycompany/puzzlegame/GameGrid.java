/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.puzzlegame;

/**
 *
 * @author RC_Student_lab
 */
public class GameGrid {
    private int [][] grid; //an array for the grid to match the numbers
    private boolean [][] revealed; // array that keeps track of the cells revealed
    private int size; //varaible for size of the grid
    public GameGrid(int size){ //constructor to initialize the grid and revealed status
        this.size=size;
        this.grid=new int[size][size];
        this.revealed=new boolean[size][size];
        initializeGrid();
    }
    private void initializeGrid(){ //method that initializes the grid with pairs of numbers
        int pairCount=(size*size)/2; //counts the pairs
        int[] numbers=new int[pairCount*2];
        for(int i=0; i<pairCount; i++){
            numbers[2*i]=i+1;
            numbers[2*i+1]=i+1;
        } //ends for loop
        java.util.Collections.shuffle(java.util.Arrays.asList(numbers)); //shuffles numbers
        int index=0; 
        for (int i=0; i<size; i++){ //fills the puzzle grid with shuffled numbers
            for (int j=0; j<size; j++){
                grid[i][j]=numbers[index++];
                revealed[i][j]=false; //means no cell revealed
            } //ends j for loop
        } //ends i for loop
    }
    public int getGridValue(int row,int col){ //method which captures the value at a position in the puzzle grid
        return grid[row][col];
    }
    public boolean isRevealed(int row,int col){ //method which checks for revealed cells
        return revealed[row][col];
    }
    public void reveal(int row,int col){ //method which reveals the cells
        revealed[row][col]=true;
    }
    public void hide(int row, int col){ //method which hides the cells
        revealed[row][col]=false;
    }
    public boolean isGameComplete(){
        for(int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                if(!revealed[i][j]){
                    return false;
                } //end if
            } //ends j for loop
        } //ends i for 
        return true;
    }
}
