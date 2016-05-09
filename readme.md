# BrickBreaker

This repository/game is part of a career day presentation I had to give on 5/10/16.

My goal was to demonstrate something fun they could create if they learned how to program and also as a fun, interactive, "see if you can get the high score" activity at then end.

## The Game

The game is pretty simple and pretty easy to understand how it works. 

The code is a little bit all over the place but I plan on cleaning it up it a little bit more before the presentation.

### Game Scenarios

#### Game Ball

1. Ball hits goalie/bottom game piece:
    - Change ball direction to up
    - Keep X (left/right) direction going the same way
2. Ball hits a brick
    - Change Y direction (up/down) 
    - Change X direction
3. Ball hits left wall/boundary
    - Keep Y direction
    - Change X direction
4. Ball hits right wall/boundary
    - Keep Y direction
    - Change X direction   
5. Ball hits below the goalie
    - End the game
    

#### Scoring
1. Points < 5
    - Ball X Speed: 2px/100ms
    - Ball Y Speed: 2px/100ms
2. Points >= 5 && Points < 10
    - Ball X Speed: 3px/100ms
    - Ball Y Speed: 4px/100ms
3. Points >= 10
    - Ball X Speed: 4px/100ms
    - Ball Y Speed: 6px/100ms


    



