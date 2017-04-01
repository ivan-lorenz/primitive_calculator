import org.scalatest.FlatSpec
import scala.collection.JavaConverters._

class PrimitiveCalculatorTest extends FlatSpec {

  behavior of "PrimitiveCalculator"

  it should "compute minimum operations for a case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(1).asScala  === List(1))
  }

  it should "compute minimum operations for c case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(5).asScala  === List(1,2,4,5))
  }

  it should "compute minimum operations for d case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(198).asScala  === List(1,3,9,10,11,22,66,198))
  }

  it should "compute minimum operations for e case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(10).asScala  === List(1,3,9,10))
  }

  it should "compute minimum operations for f case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(6).asScala === List(1, 2, 6))
  }

  it should "compute minimum operations for g case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(7).asScala  === List(1,2,6,7))
  }

  it should "compute minimum operations for h case" in {
    assert(PrimitiveCalculator.DPoptimal_sequence(8).asScala === List(1, 2, 4, 8))
  }

}
