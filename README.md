# CSE204: Data Structures and Algorithms I Sessional

This repository contains all assignments and online exam solutions for CSE204 - Data Structures and Algorithms I Sessional course.

## 📚 Course Overview

This course covers fundamental data structures and algorithms including:
- Linear data structures (Arrays, Linked Lists, Stacks, Queues)
- Tree data structures (Binary Search Trees, Heaps)
- Graph algorithms
- Algorithm design paradigms (Greedy, Divide & Conquer, Dynamic Programming)

## 🗂️ Repository Structure

### Offline Assignments

#### 01. ArrayList, LinkedList & LRU Cache
- **Topics**: Dynamic arrays, Linked lists, Cache implementation
- **Key Files**:
  - `ArrayList/MyList.java` - Custom ArrayList implementation
  - `LinkedList/MyList.java` - Custom LinkedList implementation
  - `LRUCache/LRUCache.java` - LRU Cache using custom data structures
- **Problem**: Implement dynamic data structures and an LRU cache system

#### 02. Stack, Queue & Gaming Store Simulation
- **Topics**: Stack, Queue, Gaming store queue simulation
- **Key Files**:
  - `Stack/Stack.java` - Stack implementation
  - `Queue/Queue.java` - Queue implementation
  - `Task2/GamingStoreQueue.java` - Gaming store customer queue simulation
- **Problem**: Customer queue management system for a gaming store

#### 03. Binary Search Tree
- **Topics**: Binary Search Tree operations, tree traversals
- **Key Files**:
  - `BST/BST.java` - Complete BST implementation with insert, delete, search
- **Problem**: Implement BST with all standard operations

#### 04. Binary Heap
- **Topics**: Min Heap, Heap operations, Priority Queue
- **Key Files**:
  - `MinHeap/MinHeap.java` - Min Heap implementation
- **Problem**: Implement min heap with insert, delete, heapify operations

#### 05. Graph Algorithms
- **Topics**: Graph representation, BFS, DFS, shortest path
- **Key Files**:
  - `Graph/Graph.java` - Graph implementation with various algorithms
- **Problem**: Graph traversal and pathfinding algorithms

#### 06. Greedy Algorithm - Activity Selection
- **Topics**: Greedy algorithms, Activity selection problem
- **Key Files**:
  - `Main.java` - Activity selection using greedy approach
- **Problem**: Select maximum number of non-overlapping activities

#### 07. Divide and Conquer
- **Topics**: Divide and conquer paradigm, sorting, searching
- **Key Files**:
  - `Main.java` - Various divide and conquer algorithms
- **Problem**: Implement algorithms using divide and conquer strategy

#### 08. Dynamic Programming - Knapsack
- **Topics**: Dynamic programming, 0/1 Knapsack problem
- **Key Files**:
  - `Main.java` - Knapsack problem solution using DP
- **Problem**: Solve 0/1 knapsack problem using dynamic programming

### Online

#### Online/01-ArrayList-LinkedList
- Online problems related to linear data structures

#### Online/02-Binary-Search-Tree
- Online problems related to BST operations

#### Online/03-Binary-Heap
- Online problems related to heap operations

#### Online/04-Graph-Algorithms
- Online problems related to graph algorithms

#### Online/05-Greedy-Algorithms
- Online problems using greedy approach

#### Online/06-Divide-and-Conquer
- Online problems using divide and conquer

#### Online/07-Dynamic-Programming
- Online problems using dynamic programming

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running Individual Assignments

1. Navigate to the specific assignment directory
2. Compile the Java files:
   ```bash
   javac *.java
   # or for packages
   javac -d . src/**/*.java
   ```
3. Run the main class:
   ```bash
   java Main
   # or for packages
   java package.Main
   ```
