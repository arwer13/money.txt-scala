package money.parser

import scala.io.Source

object Money {

  case class Entry(date: String, categories: List[String], value: Float, note: String)


  def parseLine(line: String): Entry = {
    val pattern = """ *(\d\d\d\d\.\d\d\.\d\d)? *(.*?) +([\(\)\d\+-\.,\*]+)\w*(.*)""".r

    pattern.findFirstMatchIn(line) match {
      // alternative approach is to use named groups:
      // http://stackoverflow.com/questions/3029657/scala-regex-named-capturing-groups
      case Some(pattern(date, cats, expression, note)) => Entry(
        date,
        cats.split(",").map((x:String) => x.trim).toList,
        expression.toFloat,
        note.trim
      )
      case None => Entry("", List(), 0, "")
    }
  }



  def loadMoneyTxt(filename: String): List[Entry] = {
    val filename = "/home/arwer/project/money.txt-scala/src/test/resources/money-sample.txt"
    Source.fromFile(filename).getLines.toList.map(
      (x: String) => {
        println(x)
      }
    )
    List()
  }

  def test = 1
}

