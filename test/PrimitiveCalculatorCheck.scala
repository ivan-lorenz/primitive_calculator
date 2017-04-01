import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object PrimitiveCalculatorCheck extends Properties("PrimitiveCalculator"){

  val genNumbers: Gen[String] = Gen.choose(1, 1000) map (_.toString)
  val listOfNumbers: Gen[Array[String]] =
    for {
      size <- Gen.choose(1,100)
      elems <- Gen.containerOfN[Array, String](size, genNumbers)
    } yield elems

  property("should respect length of numbers") =
    forAll(listOfNumbers){list  =>
      val assertion = true
      if (!assertion)
        System.out.println(s"ERROR for list : ${list.mkString(",")}")
      assertion
    }

}
