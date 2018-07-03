## Project Description

This is a command-line program to navigate and control a squad of robotic explorers landing on the Saturn planet. 
The landing area is rectangular, which is divided into grid system with North facing.

### Command-line Input

#### Setting up Grid 

The first line of input is setting up the grid size of the landing area. 
It is represented upper-right coordinates of the landing area; the bottom-left coordinates are assumed to be (0, 0) . The input must be two positive integers separated by a space. 

#### Robot Explorer's Position and Navigation

The remaining input is information pertaining to the robot explorers that have been deployed. Each robot explorer has two lines of input.
The first line represented robot's position and location, i.e. (x, y) coordinates and a letter corresponding to one of the four cardinal compass points (N/S/E/W). An example position might be (0, 0, N), which means the robot is located at the bottom-left corner and facing North. The position must be within grid size. 

For navigating a robot, a string of letters, i.e. ‘L’, ‘R’ and ‘M’ would be sent through the program. ‘L’ and ‘R’ makes the robot spin 90 degrees left or right respectively, without moving from its current position. ‘M’ means move forward one grid point, and maintain the same heading.
Assume the grid directly North from (x, y) is (x, y+1). The robot could not move out of grid. Once the robot is located at the edge of the grid and facing out of grid,
it would not move one grid point further. 

### Program Output:
When <enter> key is pressed, the output for each robot should be its final coordinates and heading. For example, the robot that starts at initial position and heading of (1 2 N) , and instruction is "LMLMLMLMM", the output is (1 3 N).


## Getting Started

### Prerequisites

JDK (Java SE Development Kit), e.g. Java SE 10.0.1


## Built With

* Eclipse - Java IDE used
* JUnit 4 - Test framework used

## Running Executable

The program is written in Java programming language. The JAR packaged applications can be run with the Java launcher on a terminal.

      java -jar Saturn.jar


The program expects the first line of the input to be the upper-right coordinates of the landing area. This is followed by 2 lines of input for each robot; the first for its initial position and heading, the second for its navigation. If the input line was not a valid format, the program print the error message to the console terminal and expect the user to re-enter the valid input.

In order to stop the program and print output of each robot explorer to the console terminal, click enter.

##### Program Demo 

     Input the grid size for landing area, follow by a series of position and navigation pertaining to Robot Explorers:   
     5 5   
     1 2 N   
     LMLMLMLMM   
     3 3 E   
     MMRMMRMRRM

     Final position for all Robot Explorers:    
     1 3 N   
     5 1 E 
