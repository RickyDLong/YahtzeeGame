//Name: Ricky Long            Date Assigned: 4/21/20
//
//Course: CSCI 2003 63794     Date Due: 4/28/20
//
//Instructor: Ms. Greer
//
//File Name: Yahtzee.java
//
//Program Description: Plays the game Yahtzee. Allows for two players / 11 Turns.

import java.util.Random;

/**
 Calculates, records, and displays players' scores
 */
public class ScoreCard
{
   // upper section
   Integer aces;
   Integer twos;
   Integer threes;
   Integer fours;
   Integer fives;
   Integer sixes;
   Integer upperTotal;

   // lower section
   Integer _3ofKind;
   Integer _4ofKind;
   Integer fullHouse;   // 3 of kind & 2 of kind
   Integer yahtzee;     // 5 of kind
   Integer chance;
   Integer lowerTotal;

   private Random rand;

   /**
    Initializes all scores to 0 to represent a blank scorecard and creates Random object to use for dice rolls.
    */
   public ScoreCard()
   {
      aces = null;
      twos = null;
      threes = null;
      fours = null;
      fives = null;
      sixes = null;
      upperTotal = 0;

      // lower section
      _3ofKind = null;
      _4ofKind = null;
      fullHouse = null;   // 3 of kind & 2 of kind
      yahtzee = null;     // 5 of kind
      chance = null;
      lowerTotal = 0;

      rand = new Random();
   }

//This was a pain. This helps corrects the zeros in the scorecard.
private String nullFix(Integer input)
{
   if(input == null){return "";}
   return Integer.toString(input);
}

//Updates the scores based on what is null or not.
public void updateScore()
{
   int runningTotalUpper = 0;
   int runningTotalLower = 0;

   if(aces != null) runningTotalUpper += aces;
   if(twos != null) runningTotalUpper += twos;
   if(threes != null) runningTotalUpper += threes;
   if(fours != null) runningTotalUpper += fours;
   if(fives != null) runningTotalUpper += fives;
   if(sixes != null) runningTotalUpper += sixes;

   upperTotal = runningTotalUpper;

   if(_3ofKind != null) runningTotalLower += _3ofKind;
   if(_4ofKind != null) runningTotalLower += _4ofKind;
   if(fullHouse != null) runningTotalLower += fullHouse;
   if(yahtzee != null) runningTotalLower += yahtzee;
   if(chance != null) runningTotalLower += chance;

   lowerTotal = runningTotalLower;
}


   /**
    Displays upper portion of scorecard. Shows both players' scores.
    @param other player 2's scorecard
    */
   public void displayUpperSection(ScoreCard other) // pass player 2's ScoreCard object to display it's data w/ player 1's
   {
      System.out.println("\n===========================");
      System.out.println("|    UPPER    |  1  |  2  |");
      System.out.println("===========================");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Aces", nullFix(aces), nullFix(other.aces));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Twos", nullFix(twos), nullFix(other.twos));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Threes", nullFix(threes), nullFix(other.threes));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Fours", nullFix(fours), nullFix(other.fours));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Fives", nullFix(fives), nullFix(other.fives));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Sixes", nullFix(sixes), nullFix(other.sixes));
      System.out.println("===========================");
      System.out.printf("| %-11s | %-3d | %-3d |\n", "Total", upperTotal, other.upperTotal);
      System.out.println("===========================\n");
   }

   /**
    Displays lower portion of scorecard. Shows both players' scores.
    @param other player 2's scorecard
    */
   public void displayLowerSection(ScoreCard other)
   {
      System.out.println("\n===========================");
      System.out.println("|    LOWER    |  1  |  2  |");
      System.out.println("===========================");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "3 of a Kind", nullFix(_3ofKind), nullFix(other._3ofKind));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "4 of a Kind", nullFix(_4ofKind), nullFix(other._4ofKind));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Full House", nullFix(fullHouse), nullFix(other.fullHouse));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Yahtzee", nullFix(yahtzee), nullFix(other.yahtzee));
      System.out.println("+-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |\n", "Chance", nullFix(chance), nullFix(other.chance));
      System.out.println("===========================");
      System.out.printf("| %-11s | %-3d | %-3d |\n", "Total", lowerTotal, other.lowerTotal);
      System.out.println("===========================\n");
   }

   /**
    Displays entire scorecard. Shows both players' scores.
    @param other player 2's scorecard
    */
   public void displayScoreCard(ScoreCard other)
   {
      System.out.println("\n===========================  ===========================");
      System.out.println("|    UPPER    |  1  |  2  |  |    LOWER    |  1  |  2  |");
      System.out.println("===========================  ===========================");
      System.out.printf("| %-11s | %-3s | %-3s |  | %-11s | %-3s | %-3s |\n", "Aces", nullFix(aces), nullFix(other.aces), "3 of a Kind", nullFix(_3ofKind), nullFix(other._3ofKind));
      System.out.println("+-------------+-----+-----+  +-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |  | %-11s | %-3s | %-3s |\n", "Twos", nullFix(twos), nullFix(other.twos), "4 of a Kind", nullFix(_4ofKind), nullFix(other._4ofKind));
      System.out.println("+-------------+-----+-----+  +-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |  | %-11s | %-3s | %-3s |\n", "Threes", nullFix(threes), nullFix(other.threes), "Full House", nullFix(fullHouse), nullFix(other.fullHouse));
      System.out.println("+-------------+-----+-----+  +-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |  | %-11s | %-3s | %-3s |\n", "Fours", nullFix(fours), nullFix(other.fours), "Yahtzee", nullFix(yahtzee), nullFix(other.yahtzee));
      System.out.println("+-------------+-----+-----+  +-------------+-----+-----+");
      System.out.printf("| %-11s | %-3s | %-3s |  | %-11s | %-3s | %-3s |\n", "Fives", nullFix(fives), nullFix(other.fives), "Chance", nullFix(chance), nullFix(other.chance));
      System.out.println("+-------------+-----+-----+  ===========================");
      System.out.printf("| %-11s | %-3s | %-3s |  | %-11s | %-3s | %-3s |\n", "Sixes", nullFix(sixes), nullFix(other.sixes), "Total", nullFix(lowerTotal), nullFix(other.lowerTotal));
      System.out.println("===========================  ===========================");
      System.out.printf("| %-11s | %-3d | %-3d |\n", "Total", upperTotal, other.upperTotal);
      System.out.println("===========================\n");
   }
}
