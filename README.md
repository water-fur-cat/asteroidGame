# asteroidGame
Instructions:
-
About how to play & New feature:
Run the main() in Game.java, and you'll see a video game. At the first time, you have 4 chances to press 'A' key on your
keyboard to have a shield to protect your falcon. And you have one chance to press 'B' key on your keyboard to kill all
the asteroids showed on the screen and enter the next level immediately. 'F' key can produce new bullet.

-
About Floater:
The NewShipFloater has four color: when you encounter blue one, you could add one life; encounter a yellow one, you will
have a special bullet which is faster in few seconds; encounter a green one, you will have a shield for a few seconds;
encounter a red one, it is a bomb, all the asteroids in the screen will be killed, then you will enter the next level
immediately.
There's two situation for generating a floater: The NewShipFloater may be produced when you have already survived for
a certain time or kill a big asteroid. In other words, when a big asteroid is killed, there is 50% chance to get a new
floater. And after some interval, a new floater is put in randomly

-
About score and level:
There will show current score and level on the left-top corner.

-
Explosion and Debris:
I have added explosion effect when an asteroid is killed. Debris will be produced by explosion which is not harmful to
the falcon and will disappear in a few seconds.

-
About HP:
I have added HP(Hit Points/Health Points) to Falcon. This is a quantitative display of the vitality/durability of the
Falcon unit in the game.

-
About weapon:
I have added two special weapon, one is class Cruise, one is Cruise_2. Cruise is produced by touching a yellow
NewShipFloater. Cruise_2 is produced by entering 'F' key.
