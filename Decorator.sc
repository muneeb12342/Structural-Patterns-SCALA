trait Coffee{
  def cost: Double
  def ingrediant:String
}
class SimpleCoffee extends Coffee{
  override def cost=1
  override def ingrediant ="Coffee"
}
abstract class CoffeeDecorator(decoratedCoffee: Coffee) extends Coffee{
  val sep=","
  override def cost=decoratedCoffee.cost
  override  def ingrediant=decoratedCoffee.ingrediant
}
class Milk (decoratedCoffee: Coffee) extends CoffeeDecorator(decoratedCoffee){
  override def cost= super.cost + 0.5
  override def ingrediant= super.ingrediant + sep + "milk"
}
class Juice(decoratedCoffee:Coffee) extends CoffeeDecorator(decoratedCoffee){
  override def cost= super.cost + 1
  override def ingrediant= super.ingrediant + sep + "Juice"
}
class Drinks (decoratedCoffee:Coffee) extends CoffeeDecorator(decoratedCoffee){
  override def cost=super.cost + 2
  override  def ingrediant= super.ingrediant +sep+ "Drinks"
}
object decoratorSample{
  def main(args: Array[String])= {
    var c:Coffee = new SimpleCoffee
    printf("Cost:%f Ingrediants %s\n",c.cost,c.ingrediant)
    c= new Milk(c)
    printf("Cost:%f Ingrediants %s\n",c.cost,c.ingrediant)
    c= new Juice(c)
    printf("Cost:%f Ingrediant %s\n",c.cost, c.ingrediant)
    c=new Drinks(c)
    printf("Cost: %f Ingrediant %s\n", c.cost,c.ingrediant)
  }
}

decoratorSample.main(Array())


