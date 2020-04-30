//Name: Ricky Long            Date Assigned: 4/21/20
//
//Course: CSCI 2003 63794     Date Due: 4/28/20
//
//Instructor: Ms. Greer
//
//File Name: Yahtzee.java
//
//Program Description: Plays the game Yahtzee. Allows for two players / 11 Turns.

import java.util.Scanner;

public class Yahtzee
{
   public static void main(String[] args)
   {

      ScoreCard scorecard = new ScoreCard();
      GamePlay gameplay = new GamePlay();
      
      //Welcome Message
      System.out.println("Let's Play Yahtzee!");
      System.out.println("===================");
      
      //Initial Scorecard display with no scores
      scorecard.displayScoreCard(scorecard);

      //Plays the Game
      gameplay.playerTurns();

      }
   }
