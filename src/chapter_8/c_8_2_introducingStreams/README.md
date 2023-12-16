<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 8.2 Introducing Streams
* This section will show how streams are used for input/output (IO) processing
* IO refers to how data is read from a  resource, or writter to a resource.
* The streams here are unrelated to the streams in chapter 4!

<hr>

## 🟥 8.2.1 Stream Fundamentals
* Contents of a file may be accessedor written via a stream, which is a list of data elements presented sequentially

## 🟥 8.2.2 Stream Nomenclature
* The `java.io` API has multiple classes for accessing, creating and manipulating streams.

### 🟡 Byte Streams vs Character Streams
* The `java.io` API has two sets of classes denoted by their name for reading and writing streams:
1) Those which contain `Stream` in their name
2) Thos which contain `Reader`/`Writer` in their name
* E.g. we have a `FileInputStream` and `FilleReader` classes

<br>

1) Stream classes are used for inputting and outputting all types of binary or byte data
2) Reader and Writer classes are used for inputting and outputting only Character and String data

### Input

## 🟥 8.2.3 Common Stream Operations