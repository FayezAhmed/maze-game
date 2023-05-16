[![buddy pipeline](https://app.buddy.works/group21/group21/pipelines/pipeline/440571/badge.svg?token=ed6accf4049acde7c0afe7e45e246f88c3680fd321a2b43ae2ed67a2cca4c623 "buddy pipeline")](https://app.buddy.works/group21/group21/pipelines/pipeline/440571)

# Raccoon Raiders

Raccoon Raiders is a 2D game built in Java using Java Swing and Java AWT. In this game, the player must collect rewards in the form of bubble tea and coffee while avoiding punishments such as failed homework. The game features enemies in the form of raccoons that chase the player using the A* pathfinding algorithm. If a raccoon catches the player, the game ends and the player dies.

## Features

- Collect rewards (bubble tea and coffee) to gain points.
- Avoid collecting punishments (failed homework) to prevent losing points.
- Raccoons chase the player using A* pathfinding algorithm.
- Player death upon being caught by a raccoon results in game over.
- Collecting all rewards opens the portal to end the game.
- User interface (UI) for an interactive gameplay experience.
- Music enhances the immersion of the game.

## How to Play

- Use the arrow keys (<kbd>↑</kbd><kbd>↓</kbd><kbd>←</kbd><kbd>→</kbd>) to move the character.
- Press <kbd>P</kbd> or <kbd>Esc</kbd> to pause the game.
- Press <kbd>Enter</kbd> to select options on the menu.

## Building and Running the Game

To build the project, run the following command:

```sh
make
```

To run the game, use the following command:

```sh
make run
```

To test the project, execute the following commands:

```sh
make test
```

Junit testing was performed, and both unit and integration tests were written to ensure the game's functionality. Testing coverage is reported using the jacoco plugin.

## Artifacts

- Javadocs: [Click here for Javadocs](https://github.com/FayezAhmed/maze-game/tree/master/RaccoonRaiders/target/apidocs)
- JAR Executable: [Click here for JAR](https://github.com/FayezAhmed/maze-game/raw/master/RaccoonRaiders/target/RaccoonRaiders.jar)

## Tutorial/Demo

For a tutorial and demo of the game, please watch [this YouTube video](https://www.youtube.com/watch?v=d7QG1P4O0Fk).

## Project Progress and Pipeline

Check out the project progress on [ClickUp](https://app.clickup.com/14235132/v/l/6-198620771-1?pr=60711082) and the pipeline on [Buddy](https://app.buddy.works/group21/group21).

## Developers

Raccoon Raiders was developed by a group of 4 developers as part of the CMPT276 group project for group 21.
