<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.5 Comparing Legacy File and NIO.2 Methods

| Legacy Method  | NIO.2 Method   |
| -------------- | -------------- |
| file.exists()  | Files.exists(path) |
| file.getName() | path.getFileName() |
| file.getAbsolutePath() | path.toAbsolutePath() |
| file.isDirectory() | Files.isDirectory(path) |
| file.isFile() | Files.isRegularFile(path) |
| file.isHidden() | Files.isHidden(path) |
| file.length() | Files.size(path) |
| file.lastModified() | Files.getLastModifiedTime(path) |
| file.setLastModifiedTime(path) | Files.setLastModifiedTime(path,fileTime) |
| file.delete() | Files.delete(path) |
| file.renameTo(otherFile) | Files.move(path,otherPath) |
| file.mkdir() | Files.createDirectory(path) |
| file.mkdirs() | Files.createDirectories(path) |
| file.listFiles() | Files.list(path) |