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
import java.util.Scanner;


public class GamePlay
{
   private int dieOne;
   private int dieTwo;
   private int dieThree;
   private int dieFour;
   private int dieFive;


   private int aces = 0;
   private int twos = 0;
   private int threes = 0;
   private int fours = 0;
   private int fives = 0;
   private int sixes =0;
   private int upperTotal = 0;
   private int lowerTotal = 0;




   Random rand = new Random();
   Scanner input = new Scanner(System.in);
   ScoreCard scorecard = new ScoreCard();
   ScoreCard scorecard2 = new ScoreCard();


//This calculates all scoring.
   private int scoreDice(int section, int category, int dieOne, int dieTwo, int dieThree, int dieFour, int dieFive)
   {
       //Adds up the individual dice total and hands it to runningCounter
       int runningCounter = 0;
       if(section == 1)
       {
           if(category == dieOne)
           {
               runningCounter = runningCounter + dieOne;
           }
           if(category == dieTwo)
           {
               runningCounter = runningCounter + dieTwo;
           }
           if(category == dieThree)
           {
               runningCounter = runningCounter + dieThree;
           }
           if(category == dieFour)
           {
               runningCounter = runningCounter + dieFour;
           }
           if(category == dieFive)
           {
               runningCounter = runningCounter + dieFive;
           }
           return runningCounter;
       }
       //Keeps track of how many of each type of die there is
       if(section == 2)
       {
           int onesCounter = 0;
           int twosCounter = 0;
           int threesCounter = 0;
           int foursCounter = 0;
           int fivesCounter = 0;
           int sixesCounter = 0;

           if(dieOne == 1) onesCounter++;
           if(dieOne == 2) twosCounter++;
           if(dieOne == 3) threesCounter++;
           if(dieOne == 4) foursCounter++;
           if(dieOne == 5) fivesCounter++;
           if(dieOne == 6) sixesCounter++;

           if(dieTwo == 1) onesCounter++;
           if(dieTwo == 2) twosCounter++;
           if(dieTwo == 3) threesCounter++;
           if(dieTwo == 4) foursCounter++;
           if(dieTwo == 5) fivesCounter++;
           if(dieTwo == 6) sixesCounter++;

           if(dieThree == 1) onesCounter++;
           if(dieThree == 2) twosCounter++;
           if(dieThree == 3) threesCounter++;
           if(dieThree == 4) foursCounter++;
           if(dieThree == 5) fivesCounter++;
           if(dieThree == 6) sixesCounter++;

           if(dieFour == 1) onesCounter++;
           if(dieFour == 2) twosCounter++;
           if(dieFour == 3) threesCounter++;
           if(dieFour == 4) foursCounter++;
           if(dieFour == 5) fivesCounter++;
           if(dieFour == 6) sixesCounter++;

           if(dieFive == 1) onesCounter++;
           if(dieFive == 2) twosCounter++;
           if(dieFive == 3) threesCounter++;
           if(dieFive == 4) foursCounter++;
           if(dieFive == 5) fivesCounter++;
           if(dieFive == 6) sixesCounter++;


           //calculates total sum of all dice
           int sum = dieOne + dieTwo + dieThree + dieFour + dieFive;


           //Handles scoring for each type of hand.
           //3 of a Kind
           if(category == 1)
           {
               if(onesCounter >= 3 || twosCounter >= 3 || threesCounter >= 3 || foursCounter >= 3 || fivesCounter >= 3 || sixesCounter >= 3)
                   return sum;
           }
           //4 of a kind
           if(category == 2)
           {
               if(onesCounter >= 4 || twosCounter >= 4 || threesCounter >= 4 || foursCounter >= 4 || fivesCounter >= 4 || sixesCounter >= 4)
                   return sum;
           }
           //Full House
           if(category == 3)
           {
               if((onesCounter == 3 || twosCounter == 3 || threesCounter == 3 || foursCounter == 3 || fivesCounter == 3 || sixesCounter == 3) &&
               (onesCounter == 2 || twosCounter == 2 || threesCounter == 2 || foursCounter == 2 || fivesCounter == 2 || sixesCounter == 2))
               { return 25;}
           }
           //Yahtzee
           if(category == 4)
           {
               if(onesCounter == 5 || twosCounter == 5 || threesCounter == 5 || foursCounter == 5 || fivesCounter == 5 || sixesCounter == 5)
                   return 50;
           }
           //Chance
           if(category == 5)
           {
               return sum;
           }

       }
       //If you try and place a score but do not meet the criteria, you instead will receive a 0 instead, just like real yahtzee
       return 0;
   }

   public GamePlay()
   {
      dieOne = 0;
      dieTwo = 0;
      dieThree = 0;
      dieFour = 0;
      dieFive = 0;
   }
   

   public GamePlay(int a, int b, int c, int d, int e)
   {
      dieOne = a;
      dieTwo = b;
      dieThree = c;
      dieFour = d;
      dieFive = e;
   }
   
   
   
   //Rolls a single die
   public int rollDie() 
       {
           return 1 + rand.nextInt(6);
       }
       
       
       
   //Displays dice and markers
   public void displayDice()
       {
           System.out.println("+---+ +---+ +---+ +---+ +---+ ");
           System.out.printf("| %d | | %d | | %d | | %d | | %d |  %n", dieOne, dieTwo, dieThree, dieFour, dieFive);
           System.out.println("+---+ +---+ +---+ +---+ +---+ ");
           System.out.println("  1     2     3     4     5\n");

       }


    //Uses a network sorting algorithm to organize the dice from smallest to largest
    //Used in the final dice display
    public void displayFinalDice()
    {
        int tmp;

        for(int count = 0; count < 4; count++) {
            if (dieTwo < dieOne) {
                tmp = dieOne;
                dieOne = dieTwo;
                dieTwo = tmp;
            }
            if (dieThree < dieTwo) {
                tmp = dieTwo;
                dieTwo = dieThree;
                dieThree = tmp;
            }
            if (dieFour < dieThree) {
                tmp = dieThree;
                dieThree = dieFour;
                dieFour = tmp;
            }
            if (dieFive < dieFour) {
                tmp = dieFour;
                dieFour = dieFive;
                dieFive = tmp;
            }
        }
        System.out.println("+---+ +---+ +---+ +---+ +---+ ");
        System.out.printf("| %d | | %d | | %d | | %d | | %d |  %n", dieOne, dieTwo, dieThree, dieFour, dieFive);
        System.out.println("+---+ +---+ +---+ +---+ +---+ ");
    }





   
   //Re-rolls only selected die
   public void reRollChoices(String reRoll)
       {
           char choice;
           for(int i = 0; i < reRoll.length(); i++)
           {
   
               choice = reRoll.charAt(i);
   
               if(choice == '1')
               {
                   dieOne = 1 + rand.nextInt(6);
               }
   
               if(choice == '2')
               {
                   dieTwo = 1 + rand.nextInt(6);
               }
   
               if(choice == '3')
               {
                   dieThree = 1 + rand.nextInt(6);
               }
   
               if(choice == '4')
               {
                   dieFour = 1 + rand.nextInt(6);
               }
   
               if(choice == '5')
               {
                   dieFive = 1 + rand.nextInt(6);
               }
   
               if(choice == ' '){}
           }
   
       }



   //PLAYS THE GAME
   public void playerTurns() {
        int turns= 1;
        String player;

       //Main loop that handles turns for each player.
       while (turns <= 2) {
           int rollCount = 1;

           //Marks each player's turn
           if (turns % 2 == 0) {
               player = "2";
           } else {
               player = "1";
           }


           //Starting the game
           System.out.println("                   +----------------+");
           System.out.println("-------------------|    Player " + player + "    |-------------------");
           System.out.println("                   +----------------+\n");
           turns++;


           //Setting a false flag for while loop
           boolean doneRolling = false;
           //BEGINS FIRST ROLL
           while (!doneRolling) {
               String rollAgain = "y";


               //Displays initial roll count for each turn
               System.out.println("Roll " + rollCount);
               System.out.println("======");


               //Rolls the dice for each player
               dieOne = rollDie();
               dieTwo = rollDie();
               dieThree = rollDie();
               dieFour = rollDie();
               dieFive = rollDie();


               //Displays dice
               displayDice();
               rollCount++;


               //Asks uses if he wants to roll again or stay with his current dice.
               System.out.print("\nRoll again? (y/n): ");
               rollAgain = input.nextLine();
               System.out.println("\n---------------------------------------------------------------\n");


               //Input Validation to continue rolling.
               if(!rollAgain.equals("y") && !rollAgain.equals("n"))
               {
                   System.out.print("Please enter (y/n): ");
                   rollAgain = input.nextLine();
               }


               //If he answers yes, it updates the rolls, rerolls selected dice and continues til 3 turns.
               while (rollAgain.equals("y") && rollCount <= 3) {
                   //Updating Roll Count
                   System.out.println("Roll " + rollCount);
                   System.out.println("======");

                   //Reroll only chosen dice
                   System.out.print("Enter dice to reroll (1-5): ");
                   String reRoll = input.nextLine();


                   if (player.equals("1")) {
                       reRollChoices(reRoll);
                       displayDice();

                   }
                   if (player.equals("2")) {

                       reRollChoices(reRoll);
                       displayDice();

                   }

                   if (rollCount < 3) {
                       System.out.print("\nRoll again? (y/n): ");
                       rollAgain = input.nextLine();
                       System.out.println("\n---------------------------------------------------------------\n");
                   }
                   rollCount++;

               }





               //Scorecard tabulation
               if(rollAgain.equals("n") || rollCount > 3) {
                   doneRolling = true;
                   scorecard.displayScoreCard(scorecard2);
                   System.out.println();
                   System.out.println("PLAYER " + player + "'s DICE ROLL");
                   System.out.println("====================\n");
                   displayFinalDice();


                   //Display menu for each section
                   System.out.println("\nSelect Section");
                   System.out.println("==============");
                   System.out.println("1. Upper Section");
                   System.out.println("2. Lower Section\n");

                   System.out.print("Enter section to update (1 or 2): ");
                   int section = input.nextInt();


                   //Chooses section based on user choice (1-2)
                   if (section == 1) {
                       //Display scorecard for that section
                       scorecard.displayUpperSection(scorecard2);

                       //Shows user the final dice setup one last time for scoring
                       System.out.println();
                       System.out.println("PLAYER " + player + "'s DICE ROLL");
                       System.out.println("====================\n");
                       displayFinalDice();
                       System.out.println();

                       //Shows user category options
                       System.out.println("Choose Category to Fill");
                       System.out.println("=======================");
                       System.out.println("1. Aces");
                       System.out.println("2. Twos");
                       System.out.println("3. Threes");
                       System.out.println("4. Fours");
                       System.out.println("5. Fives");
                       System.out.println("6. Sixes\n");


                       //Chooses category based on user choice (1-5)
                       System.out.print("Enter choice (1 - 5): ");
                       int category = input.nextInt();

                       //Clearing input buffer
                       input.nextLine();


                       //Handling zero inputs
                       System.out.print("Enter a zero instead? (y/n):  ");
                       String zero = input.nextLine();



                       //Adding scores to Upper Scoreboard if zero was not chosen
                       if (category == 1) {
                           if (player.equals("1")) {
                               scorecard.aces = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard.aces = 0;
                               }
                           }
                           if (player.equals("2")) {
                               scorecard2.aces = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard2.aces = 0;
                               }
                           }
                       }
                       if (category == 2) {
                           if (player.equals("1")) {
                               scorecard.twos = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard.twos = 0;
                               }
                           }
                           if (player.equals("2")) {
                               scorecard2.twos = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard2.twos = 0;
                               }
                           }
                       }
                       if (category == 3) {
                           if (player.equals("1")) {
                               scorecard.threes = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard.threes = 0;
                               }
                           }
                           if (player.equals("2")) {
                               scorecard2.threes = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard2.threes = 0;
                               }
                           }
                       }
                       if (category == 4) {
                           if (player.equals("1")) {
                               scorecard.fours = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard.fours = 0;
                               }

                           }
                           if (player.equals("2")) {
                               scorecard2.fours = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard2.fours = 0;
                               }
                           }
                       }
                       if (category == 5) {
                           if (player.equals("1")) {
                               scorecard.fives = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard.fives = 0;
                               }
                           }
                           if (player.equals("2")) {
                               scorecard2.fives = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard2.fives = 0;
                               }
                           }
                       }
                       if (category == 6) {
                           if (player.equals("1")) {
                               scorecard.sixes = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard.sixes = 0;
                               }
                           }
                           if (player.equals("2")) {
                               scorecard2.sixes = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                               if(zero.equals("y"))
                               {
                                   scorecard2.sixes = 0;
                               }
                           }
                       }
                   }

                   //Handles scoreboard point placement for lower scoreboard.
                   if (section == 2) {

                       //Display scorecard for that section
                       scorecard.displayLowerSection(scorecard2);


                       //Shows user the final dice setup one last time for scoring
                       System.out.println();
                       System.out.println("PLAYER " + player + "'s DICE ROLL");
                       System.out.println("====================\n");
                       displayFinalDice();
                       System.out.println();


                       //Shows user category options
                       System.out.println("Choose Category to Fill");
                       System.out.println("=======================");
                       System.out.println("1. 3 of a Kind");
                       System.out.println("2. 4 of a Kind");
                       System.out.println("3. Full House");
                       System.out.println("4. Yahtzee");
                       System.out.println("5. Chance\n");





                       //LOWER SCOREBOARD SCORING
                       //Chooses category based on user choice (1-5)
                       System.out.print("Enter choice (1 - 5): ");
                       int category = input.nextInt();

                       if (category == 1) {
                           if (player.equals("1")) {
                               scorecard._3ofKind = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                           if (player.equals("2")) {
                               scorecard2._3ofKind = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                       }
                       if (category == 2) {
                           if (player.equals("1")) {
                               scorecard._4ofKind = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                           if (player.equals("2")) {
                               scorecard2._4ofKind = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                       }
                       if (category == 3) {
                           if (player.equals("1")) {
                               scorecard.fullHouse = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                           if (player.equals("2")) {
                               scorecard2.fullHouse = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                       }
                       if (category == 4) {
                           if (player.equals("1")) {
                               scorecard.yahtzee = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                           if (player.equals("2")) {
                               scorecard2.yahtzee = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                       }
                       if (category == 5) {
                           if (player.equals("1")) {
                               scorecard.chance = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                           if (player.equals("2")) {
                               scorecard2.chance = scoreDice(section, category, dieOne, dieTwo, dieThree, dieFour, dieFive);
                           }
                       }
                   }
               }
           }


           //Updates Scores
           scorecard2.updateScore();
           scorecard.updateScore();



           //Displaying ScoreBoard
           scorecard.displayScoreCard(scorecard2);
       }

       //Sums up the total scores of both players at the end of the game.
       int playerOneTotal = scorecard.upperTotal + scorecard.lowerTotal;
       int playerTwoTotal = scorecard2.upperTotal + scorecard2.lowerTotal;


       //Prints out final scores
       System.out.println("==================");
       System.out.println("|  FINAL SCORES  |");
       System.out.println("==================");
       System.out.printf("| Player 1 | %-3d |\n",playerOneTotal);
       System.out.printf("| Player 2 | %-3d |\n",playerTwoTotal);
       System.out.println("==================");



       //Calculates Winner
       if(playerOneTotal > playerTwoTotal) System.out.println("* * * PLAYER 1 WINS! * * *");
       else if(playerOneTotal == playerTwoTotal)System.out.println("* * * ITS A TIE! * * *");
       else System.out.println("\n* * * PLAYER 2 WINS! * * *");

   }
}
