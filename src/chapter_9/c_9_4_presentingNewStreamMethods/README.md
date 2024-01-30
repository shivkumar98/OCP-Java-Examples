<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.4 Presenting the New Stream Methods
* Java 8 provides you methods for performing complex operations like searching for a file in a directory tree with one-line code which prior to Java 8 would've needed entire classes!
## 🟥 9.4.1 Conceptualizing Directory Walking
* Files and directories can be represented as a tree, where every file/directory has exactly one parent directory
* A common task is to iterate across all files.
* Walking or traversing a directory is the process by which you start at a parent directory and iterating over all descendants until some condition is met
### ⭐ Selecting a Search Strategy ⭐
* Depth-first search goes all the way through an arbritary leaf and navigates back to the root and then traversing down fully any skipped directories
* Breadth first search starts at the roor and processes all elements of each particular depth
* The Streams API employs the depth-first strategy with a max value of `Integer.MAX_VALUE`
