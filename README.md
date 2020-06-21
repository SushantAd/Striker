A new game in carrom-board called Clean Strike is played by 2 players with multiple turn s. A turn has a player attempting to strike a coin with the striker. Players alternate in taking turns.The game is described as follows:  
* There are 9 black coins, a red coin and a striker on the carrom-board 
* Strike - When a player pockets a coin he/she wins a point 
* Multi-strike - When a player pockets more than one coin he/she wins 2 points. All, but 2 coins, that were pocketed, get back on to the carrom-board 
*  Red strike - When a player pockets red coin he/she wins 3 points. If other coins are pocketed along with red coin in the same turn, other coins get back on to the carrom-board 
*  Striker strike - When a player pockets the striker he/she loses a point 
*  Defunct coin - When a coin is thrown out of the carrom-board, due to a strike, the player loses 2 points, and the coin goes out of play 
*  When a player does not pocket a coin for 3 successive turns he/she loses a point
*  When a player fouls 3 times (a foul is a turn where a player loses, at least, 1 point), he/she loses an additional point 
*  A game is won by the first player to have won at least 5 points, in total, and, at least, 3 points more than the opponent 
*  When the coins are exhausted on the board, if the highest scorer is not leading by, at least, 3 points or does not have a minimum of 5 points, the game is considered a draw 

## Input 
Input bases on given menu options

```
Input 
Player 1: Choose an outcome from the list below 
1. Strike 
2. Multistrike 
3. Red strike 
4. Striker strike 
5. Defunct coin 
6. None
>1

Player 2: Choose an outcome from the list below 
1. Strike 
2. Multistrike 
3. Red strike 
4. Striker strike 
5. Defunct coin 
6. None
>1
```

## Output 
```
Output 
Player 2 has won... Exiting System!
Score: Player 1: 2 Player 2:5
```

## Getting Started

Clone this repo to your local machine using https://github.com/SushantAd/myRepo.git


## Prerequisites

* java jdk and/or any java ide.

## Running the Code:
We can run the code using 2 modes:
#### IDE:
For console inputs:
* Run Game.java


For test values from File:
* Run GameFileInput.java


#### Command Prompt:
For console inputs:
* javac Game.java
* java GameFileInput.java

For test values from File:
* javac GameFileInput.java
* java GameFileInput 


## Test Cases

For test cases I have used file input to check if all the outcomes are correct:

#### Test cases will deal with the following use cases:
For input to menu console:
* Leading Zeroes
* Strings and Alpha numeric Values
* Negative Values
* Floating point Values
* Empty spaces in Input values 

For output oriented results:
* Player 1 wins
* Player 2 wins
* To reproduce Foul check (When a player fouls 3 times)
* To reproduce NoPocketCheck (When a player does not pocket a coin for 3 successive turns)
* No Black coins Available (When number of Black coins are finished)
* No Red Available (When number of Black coins are finished)
* Draw (When the coins are exhausted on the board, if the highest scorer is not leading by, at least, 3 points or does not have a minimum of 5 points, the game is considered a draw)

Assumptions:
* Each occurence when a player doesn't pocket, will be considered for NoPocket.
* Each occurence when a player gives a wrong input, will be treated as an actual turn and the next player will get to strike.
* Currently only 2 players will be allowed for the game.
* No of coins can be changed when the gameRule object in initialized.
