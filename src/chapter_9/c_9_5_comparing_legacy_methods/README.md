<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.5 Comparing Legacy File and NIO.2 Methods
* Here is a table of the legacy File methods and their NIO.2 API equivalent counterpart:

| Legacy Methods           | NIO.2 Method             |
| -----------------------  | ------------------------ |
| file.exists()            | Files.exists(path)       |
| file.getName()           | Files.getFileName(path)  |
| file.getAbsolutePath()   | path.toAbsolutePath()    |
| file.isDirectory()       | Files.isDirectory(path)  |
| file.isFile()            | Files.isRegularFile(path)|
| file.isHidden()          | Files.isHidden(path)     |
| file.length()            | Files.size(path)         |
| file.lastModified()      | Files.getLastModifiedTime(path) |
| file.setLastModified(time) | Files.setLastModifiedTime(path, fileTime) |
| file.delete()            | Files.delete(path) |
| file.renameTo(otherFile) | Files.move(sourcePath, targetPath) |
| file.mkdir()             | Files.createDirectory(path) |
| file.mkdirs()            | Files.createDirectories(path) |
| file.listFiles()         | Files.list(path) |
