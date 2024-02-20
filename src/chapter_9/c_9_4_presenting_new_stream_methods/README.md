<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.4 Presenting the New Stream Methods
* Before Java 8, the techniques to perform complex file operations in NIO.2 required alot of code, often requiring its own class.

<hr>

## 🟥 9.4.1 Conceptualising Directory Walking
* A common task in a file system is to iterate over descendants of a particular path
* E.g. you may want to look in a directory and collect all `.java` files.
* **Walking a directory** is the process of starting at a parent directory and iterate over all of its descendants until condition is met, or all files are iterated

### ⭐ Search Strategy ⭐
* There are 2 common strategies for walking a directory tree:
1) **Depth-first search** will go all the way down to a particular path, once it hits the end, it will back track up a node and traverse the paths its skipped
2) **Breadth-first** will traverse down 1 depth level, look at all records at that level, and then go down another depth level. Result will be ordered by depth
* For the exam, I need to know that the Streams API uses depth-first search, with a default maximum depth of `Integer.MAX_VALUE`

## 🟥 9.4.2 Walking a Directory
### ⭐ Avoiding Circular Paths ⭐

## 🟥 9.4.3 Searching a Directory

## 🟥 9.4.4 Listing Directory Contents

## 🟥 9.4.5 Printing File Contents