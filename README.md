# Game of Life

## Introduction
**Game of Life** is a simple implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) in Java. This project simulates the evolution of cells on a grid based on predefined rules.

## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation-and-usage)
- [Rules](#rules)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Installation and Usage
1. Clone the repository:
   ```bash
   git clone https://github.com/mhmmdjafarg/GameOfLife.git
2. Navigate to the project
    ```bash
    cd GameOfLife
    ```
3. Build the project using Gradle:
    ```bash
    ./gradleW build
    ```
4. Run the application using:
    ```bash
    ./gradleW run
    ```
   
## Rules
The game starts by displaying a grid with randomly generated cells. Each cell can either be alive or dead, represented by different symbols. The game evolves the grid through generations based on Conway's rules:

- Any live cell with fewer than two live neighbors dies (underpopulation).
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies (overpopulation).
- Any dead cell with exactly three live neighbors becomes a live cell (reproduction).
- You can observe the evolution of the grid in the console.

### Example

When running the program, you should see a grid of cells where `⬜` represents live cells and `⬛` represents dead cells. The grid will update to show the next generation of cells.

## Dependencies

- Java 11 or higher
- Gradle

## Contributing

Contributions are welcome! Feel free to submit a Pull Request or open an issue to discuss changes or new features.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
