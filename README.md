# cs2114-project1-group20

A console-based trivia game designed to host trivia nights—with a fun twist!

This game is a Jeopardy-style trivia game played entirely in the console. It features multiple categories and difficulties, unique power-ups, multiplayer support, and a save system that allows players to continue building their progress across multiple sessions.

## How to Play

1. Run the application.
2. Create a new player profile or load an existing saved profile.
3. Add additional players if desired. The game supports up to 4 players.
4. Once all players are selected, the game begins. There are 4 categories, each with 3 difficulty levels.
5. Player A chooses a category and difficulty.
6. Player A is shown a question and can either answer normally or use one of their available power-ups.
7. If the player answers correctly, they earn points based on the difficulty of the question. If they answer incorrectly, they earn no points.
8. Player B then takes their turn and follows the same process.
9. Play continues between all players for up to 5 complete rounds.
10. The game ends after 5 rounds or when a player selects **Stop Early**.
11. Player progress is saved so that profiles can be loaded again in future sessions.

## Power-Ups

Each player has access to four single-use power-ups:

* **Hint** — Gives the player a hint for the current question.
* **50/50** — Removes two incorrect answer choices.
* **Double Points** — Doubles the points earned if the question is answered correctly.
* **Second Chance** — Gives the player another attempt after an incorrect answer.

## Question Bank

The game contains **36 questions** divided among:

* 4 categories
* 3 difficulty levels
* 3 questions for each category-difficulty combination

Once all 3 questions from a specific category and difficulty combination have been used, players can no longer select questions from that combination. However, the overall question bank contains enough questions for a complete 5-round game.

## UML Diagram
<img width="1774" height="887" alt="ChatGPT Image Sep 24, 2026, 09_00_17 PM" src="https://github.com/user-attachments/assets/638e3e73-82aa-46a0-8396-059e5b6b76d0" />
