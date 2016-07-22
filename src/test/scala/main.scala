import org.specs2.mutable._
import money.parser.Money._
import scala.io.Source


class MoneyTxtParsing extends Specification {
  "money.txt parsing" >> {
    "parseLine for various line types" >> {
      parseLine("2015.09.25 food, sweets 54") === Entry("2015.09.25", List("food", "sweets"), 54, "")
      parseLine("2015.09.25 food,sweets 54") === Entry("2015.09.25", List("food", "sweets"), 54, "")
      parseLine("2015.09.25 food,  sweets 54") === Entry("2015.09.25", List("food", "sweets"), 54, "")

      parseLine("2015.09.25 food 54") === Entry("2015.09.25", List("food"), 54, "")
      parseLine("2015.09.25   food  54") === Entry("2015.09.25", List("food"), 54, "")
      parseLine(" 2015.09.25   food  54") === Entry("2015.09.25", List("food"), 54, "")
      parseLine(" 2015.09.25   food  54 ") === Entry("2015.09.25", List("food"), 54, "")

      parseLine("2015.09.25 food 54 note with spaces") === Entry("2015.09.25", List("food"), 54, "note with spaces")
      parseLine("abracadabra") === Entry("", List(), 0, "")
    }

    "load sample money.txt file" >> {
      //    java.lang.ClassLoader.getRes
      //    val filename = "/home/arwer/project/money.txt-scala/src/test/resources/money-sample.txt"
      //    Source.fromFile(filename).getLines.toList.map(
      //      (x: String) => {
      //        println(x)
      //      }
      //    )
    }
  }
}
