import net.petitviolet.ulid4s.ULID

import scala.util.chaining._
import java.util.Date

object Main {
  /** ULIDを生成してULIDの昇順にソートしたSeqを作成する */
  def main(args: Array[String]): Unit = {
    val ulids = (1 to 5)
      .map(_ => ULID.generate.tap(println))
      .sortWith((s1, s2) => s1 < s2) // 昇順にソート
      .tap(println)

    ulids.foreach(ulid => println(ULID.timestamp(ulid)))
    ulids.foreach(ulid => println(new Date(ULID.timestamp(ulid).get)))
  }
}