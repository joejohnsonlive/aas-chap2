/*
 * Scala REPL snippets for aas-chap2
 * NOTE - first set up data using src/data-load-stage code
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

// assign head toy/prototype dataset as in book:
val head = rawblocks.take(10)

// convert String to Double, except "?" to NaN
    def toDouble(s: String) = {
     if ("?".equals(s)) Double.NaN else s.toDouble
    }

// class for a tuple
    case class MatchData(id1: Int, id2: Int,
      scores: Array[Double], matched: Boolean)
    case class Scored(md: MatchData, score: Double)

// convert a line into a structured typed tuple
    def parse(line: String) = {
      val pieces = line.split(',')
      val id1 = pieces(0).toInt
      val id2 = pieces(1).toInt
      val scores = pieces.slice(2, 11).map(toDouble)
      val matched = pieces(11).toBoolean
      MatchData(id1, id2, scores, matched)
    }

// try out our funcs:
val line = head(5)
val tup = parse(line)
tup.productElement(0)
tup.productArity

