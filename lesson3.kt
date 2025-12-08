package example.myapp

import java.lang.Math.PI

class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    // Dimensions in cm
    var length: Int = length
    var width: Int = width
    var height: Int = height

    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }

    var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 liter
        set(value) {
            height = (value * 1000) / (width * length)
        }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm Length: $length cm Height: $height cm")
        // 1 liter = 1000 cm^3
        println("Volume: $volume liters")
    }
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()
}

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}

fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
    // println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")
}

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm Length: $length cm Height: $height cm")
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
    // ellipse area = π * r1 * r2
    get() = (width/2 * length/2 * height / 1000 * PI).toInt()
    set(value) {
        height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
    }

    override var water = volume * 0.8
    override val shape = "cylinder"
}

fun buildAquarium() {
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
}

fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun main() {
    buildAquarium()
}

package example.myapp

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish() {
    override val color = "grey"
}

class Plecostomus: AquariumFish() {
    override val color = "gold"
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}

interface FishAction  {
    fun eat()
}

class Shark: AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

interface FishAction  {
    fun eat()
}

abstract class AquariumFish : FishAction {
   abstract val color: String
   override fun eat() = println("yum")
}

fun main () {
    makeFish()
}

package example.myapp

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus: FishAction, FishColor {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

object GoldColor : FishColor {
   override val color = "gold"
}

class Plecostomus:  FishAction, FishColor by GoldColor {
   override fun eat() {
       println("eat algae")
   }
}

class Plecostomus(fishColor: FishColor = GoldColor):  FishAction,
       FishColor by fishColor {
   override fun eat() {
       println("eat algae")
   }
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main () {
    makeFish()
}

package example.myapp.decor

data class Decoration(val rocks: String)

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)
    
    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))
}

data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

fun makeDecorations() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

// Assign all properties to variables.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}


enum class Color(val rgb: Int) {
   RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

object GoldColor : FishColor {
   override val color = "gold"
}

fun main() {
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}

fun main(){
    makeDecorations()
}

class Choice {
   companion object {
       var name: String = "lyric"
       fun showDescription(name:String) = println("My favorite $name")
   }
}

fun main() {
   println(Choice.name)
   Choice.showDescription("pick")
   Choice.showDescription("selection")
}

fun main(){
    val equipment = "fish net" to "catching fish"
	println("${equipment.first} used for ${equipment.second}")
    
    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())
    
    val equipment2 = ("fish net" to "catching fish") to "equipment"
	println("${equipment2.first} is ${equipment2.second}\n")
	println("${equipment2.first.second}")

    val equipment = "fish net" to "catching fish"
	val (tool, use) = equipment
    println("$tool is used for $use")
    
    val numbers = Triple(6, 9, 42)
	val (n1, n2, n3) = numbers
	println("$n1 $n2 $n3")
    
    val list = listOf(1, 5, 3, 4)
    println(list.sum())
    
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sum())
    
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumBy { it.length })

	val list2 = listOf("a", "bbb", "cc")
	for (s in list2.listIterator()) {
    	println("$s ")
	}
    
    val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )
    println (scientific.get("guppy"))
    println(scientific.get("zebra fish"))
//     println("scientific.get("swordtail"")
    
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
    
    println(scientific.getOrElse("swordtail") {"sorry, I don't know"})
}


//Top-level constant
const val rocks = 3

// Singleton object holding constants
object Constants {
    const val CONSTANT2 = "object constant"
}

// Accessing the object constant
val foo = Constants.CONSTANT2

// Class with a companion object
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

// Accessing the companion object constant
fun main() {
    println("Top-level constant: $rocks")
    println("Singleton object constant: $foo")
    println("Companion object constant: ${MyClass.CONSTANT3}")
}

// Step 1: String extension function
fun String.hasSpaces() = indexOf(' ') != -1

// Step 2: AquariumPlant class and extensions
open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

// Extension functions
fun AquariumPlant.isRed() = color == "red" // OK
// fun AquariumPlant.isBig() = size > 50 // gives error

fun AquariumPlant.printPlant() = println("AquariumPlant")
fun GreenLeafyPlant.printPlant() = println("GreenLeafyPlant")

// Step 3: Extension property
val AquariumPlant.isGreen: Boolean
    get() = color == "green"

// Step 4: Nullable receiver extension
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

// Main function to test everything
fun main() {
    // Testing String extension
    println("Hello World".hasSpaces()) // true
    println("HelloWorld".hasSpaces())  // false

    // Testing AquariumPlant extensions
    val plant = GreenLeafyPlant(10)
    plant.printPlant()  // GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.printPlant()  // AquariumPlant

    println("Is aquariumPlant green? ${aquariumPlant.isGreen}")  // true
    println("Is plant red? ${plant.isRed()}")                    // false

    // Nullable receiver extension
    val nullPlant: AquariumPlant? = null
    nullPlant.pull()                 // no output

    val anotherPlant: AquariumPlant? = AquariumPlant("red", 5)
    anotherPlant.pull()              // prints: removing AquariumPlant@<hashcode>
}
