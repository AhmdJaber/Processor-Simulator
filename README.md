# Processor Execution Simulation

## Overview

This project simulates task execution across multiple processors, where tasks are prioritized and scheduled efficiently using a custom scheduling system. It models the lifecycle of task creation, scheduling, assignment to processors, and execution across multiple clock cycles.

## Features

- **Priority-Based Scheduling**: Tasks are assigned a priority (0 or 1) and scheduled using a list of `Scheduler` objects that manage a priority queue.
- **Dynamic Task Creation**: Tasks are dynamically created at specific clock cycles and organized for efficient access.
- **Processor Assignment**: Available processors are assigned tasks based on priority and task duration.
- **Simulation Report**: The simulation outputs a color-coded report in the console using ANSI escape codes to visually represent:
  - Blue: Processor
  - Red: Cycle
  - Orange: Created Task
  - Green: Task in progress
  - White: Completed Task

## Design

The software is built with clean OOP principles and includes the following main classes:

- `Task`: Represents a task with duration, priority, and ID.
- `Processor`: Represents a processor that can execute a task.
- `Scheduler`: Manages task queues based on priority.
- `Cycle`: Controls simulation timing.
- `Simulator`: Coordinates the entire simulation.
- `Report`: A utility class for generating output.
- `Main`: Entry point for running the simulation.
- `TaskSpecReader`: Reads task specs from an input file.

## Reusability & Efficiency

- Easily extendable to support more priority levels.
- Utilizes `PriorityQueue` for efficient task management with O(log N) operations.

## How to Run

1. Prepare a `.txt` file with task specifications.
2. Compile and run the program via the `Main` class.
3. The simulation will output a detailed report in the console.
