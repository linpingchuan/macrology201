class C { override def toString = "C" }

object Test {
  def main(args: Array[String]): Unit = {
    def foo(x: => Optional[C]) = x
    // println(foo({ val y = new Optional(null); y }).getOrElse(new C))

    {
      val temp = foo({ val y = new Optional(null); y })
      if (temp.isEmpty) new C else temp.value
    }
  }
}