<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.2 Interacting with Paths and Files

* A Path object does not necessarily point to a file but instead represents a location in the file system
* Some methods require for the file to exist, e.g. `Path.toRealPath()`, and will throw a checked exception if thhe file is not available.

## 🟥 9.2.1 Providing Optional Arguments
* I am not required to memorize which of the NIO.2 methods have optional arguments but I do need to know what they do
* Here are the common optional arguments in NIO.2:
  
| Enum Value | Description | Usage       |
| ---------- | ---------------------- | ----------- |
| NOFOLLOW_LINKS | Symbolic links will NOT be traversed. | Copying/moving/reading files and test for existence |
| FOLLOW_LINKS | Symbolic links WILL be traversed | Traversing a directory tree |
| COPY_ATTRIBUTES | Metadata for a file will be copied with file copied | Copy file |
| REPLACE_EXISTING | Will replace if the target file exists. If not provided will throw exception when attempting to replace existing file | Copying/Moving files |
| ATOMIC_MOVE | File is moved atomically, ensuring any process using the file sees the complete record. Throws exception if OS does not support it | Moving files |