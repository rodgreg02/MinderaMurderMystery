# Mindera Murder Mystery - Technical Documentation
## Introduction
Mindera Murder Mystery is a text-based game developed in Java 17 to be executed in the terminal. The game involves an investigation of a murder where the player has to discover the killer, the weapon, and the crime scene. It was conceived as part of a challenge proposed by Flávio and Gabriel, stemming from a group idea.

# Game Structure
## Core Classes
## Render

Description: Organizes rooms and distributes weapons and suspects.
Functionality: Distributes rooms, weapons, and suspects throughout the game. Controls the game's main logic.

## Room

Description: Represents the locations where events occur.
Functionality: Stores information about each room (location, description, etc.). Contains methods to manipulate events within the room.

## Weapons

Description: Represents the weapons used in the game.
Functionality: Stores information about available weapons. Provides methods to access weapon information.

## Character

Description: Represents the suspects in the game.
Functionality: Stores information about the characters/suspects. Provides methods to access suspect information.

# Additional Classes
## GameEngine

Description: Controls the main flow of the game.
Functionality: Initiates and manages the game, interacting with the player. Processes player commands and updates the game state.

## Player

Description: Represents the player in the game.
Functionality: Stores player information such as name and progress.

# Additional Features
## Utils
Functionality: Auxiliary methods to manipulate strings, generate random numbers, etc.

## Future Improvements
Removal of unnecessary code and refactoring to enhance code structure and efficiency.
Implementation of new features such as additional clues to expand gameplay.
Improvement of the user interface or addition of graphical elements to enhance the gaming experience.
Integration of automated testing to ensure game stability in future iterations.

# Final Remarks
Mindera Murder Mystery has undergone several iterations and versions to reach its current state, considered the best so far. As part of an ongoing project, there are plans to revisit the code, remove unnecessary parts, and possibly add new features to further enhance the game.

# Authors
Authors: Bruna Taketsuma, Pedro Barge, Tiago Padrão, Rodrigo Gregorio.
This documentation provides an overview of Mindera Murder Mystery, highlighting its core classes, functionalities, future improvements, and final considerations on the game's development and evolution.
