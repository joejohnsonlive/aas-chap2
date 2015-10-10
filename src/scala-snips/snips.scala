/*
 * Scala REPL snippets for aas-chap2
*/
val rawblocks = sc.textFile("C:/Users/Joe/aas-chap2/linkage")
rawblocks.take(5)

// Nicer presentation:
rawblocks.take(10).foreach(println)

// oneliner func to filter header row:
def isHeader(line: String) = line.contains("id_1")

// Three ways to filter headers - use simplest clear expression
rawblocks.take(10).filterNot(isHeader).foreach(println)
rawblocks.take(10).filter(x => !isHeader(x)).foreach(println)
rawblocks.take(10).filter(!isHeader(_)).foreach(println)


