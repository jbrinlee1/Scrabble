SCRABBLE

Summary: This repository contains the code for a rudimentary scrabble game that was desinged for an introduction
to programming class. It depicts the game Scrabble and can be played between two - four users on a computer. The
display is implemented using Java swing. Although the game class contains a GUI object, the GUI is more of a display
than a GUI. The user's inputs are prompted throughout using a seperate JFrame object as the game class requires 
decisions to be made. While there are many improvements to be made this is a fully functioning game that can allow 
users to play scrabble where ever they can bring thier computer!

Game Play: As described above the user is prompted to make desisions that would be made in the traditional scrabble game. 
For rules that might differ slightly from typical scrabble, click the view rules button in the welcome screen to see 
all the rules.

The game starts by prompting the players for the number of players that want to play, thier names, and the score they'd like
to play to. From there, all the objects for the game are created. One player is chosen at random to start. Each player starts
their turn by deciding if they'd like to use their turn to play a word or to replace times. Based on the users decision, the
correct game logic runs. When the player is done with their turn, they select the end turn buttom. Scores are calculated, tiles
are replaced, the display is updated and the next player's turn begins! Once one player's score excides the score to win,
the game ends!

Future improvements: 
