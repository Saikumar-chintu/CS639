// LESSON 1: : Get Started
fun printHello() {
    println("Hello World")
}

printHello()

// LESSON 1: : Kotlin basics

//Operators And Types
//STEP 1: Explore Numeric Operators
println(1 + 1)
println(53 - 3)
println(50 / 10)
println(1.0 / 2.0)
println(2.0 * 3.5)

//Integer vs floating point operations
println(6 * 50)
println(6.0 * 50.0)
println(6.0 * 50)

//Using methods on numbers
println(2.times(3))
println(3.5.plus(4))
println(2.4.div(2))
println()


//STEP 2: Practice Using Types

val i: Int = 6

//Conversions
val b1 = i.toByte()
println(b1)

//Byte variable
val b2: Byte = 1
println(b2)

// Uncomment to see type mismatch errors:
// val i1: Int = b2
// val i2: String = b2
// val i3: Double = b2

//Correct casting
val i4: Int = b2.toInt()
println(i4)

val i5: String = b2.toString()
println(i5)

val i6: Double = b2.toDouble()
println(i6)

//Numeric literals with underscores
val oneMillion = 1_000_000
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
println(oneMillion)
println(socialSecurityNumber)
println(hexBytes)
println(bytes)


//STEP 3: Learn the value of variable types
var fish = 1
fish = 2
println(fish)

val aquarium = 1
// aquarium = 2

//Explicit types
var fishCount: Int = 12
var lakes: Double = 2.5
println(fishCount)
println(lakes)


//STEP 4: Strings and Characters
val numberOfFish = 5
val numberOfPlants = 12

println("I have $numberOfFish fish" + " and $numberOfPlants plants")
println("I have ${numberOfFish + numberOfPlants} fish and plants")
println()

//Conditions And Booleans

//Basic if / else condition
val numberOfFish1 = 50
val numberOfPlants1 = 23

if (numberOfFish1 > numberOfPlants1) {
    println("Good ratio!")
} else {
    println("Unhealthy ratio")
}

//Using a range in an if statement
val fish1 = 50
if (fish1 in 1..100) {
    println(fish1)  // 50 is within the range
}

//If with multiple cases (else if)
if (numberOfFish1 == 0) {
    println("Empty tank")
} else if (numberOfFish1 < 40) {
    println("Got fish!")
} else {
    println("That's a lot of fish!")
}

//Using a 'when' statement (like switch)
when (numberOfFish1) {
    0 -> println("Empty tank")
    in 1..39 -> println("Got fish!")
    else -> println("That's a lot of fish!")
}
println()

// Nullability
// STEP 1: Learn About Nullability

// By default, variables cannot be null
// var rocks: Int = null // This will cause a compilation error

// Use '?' to allow null values
// var marbles: Int? = null
// Marbles: $marbles
// println()

// STEP 2: ? and ?: operators
// The longer way to check for null and decrement
// var fishFoodTreats = 6
// if (fishFoodTreats != null) {
//     fishFoodTreats = fishFoodTreats.dec()
//}
// After if check: $fishFoodTreats

// Kotlin way using '?' (safe call operator)
// fishFoodTreats = fishFoodTreats?.dec()
// println("After safe call: $fishFoodTreats") // Output: 4

// Using Elvis operator '?:' to provide a default value if null
// fishFoodTreats = fishFoodTreats?.dec() ?: 0
// println("After Elvis operator: $fishFoodTreats") // Output: 3

// Example of null value with Elvis operator
// var nullTreats: Int? = null
// nullTreats = nullTreats?.dec() ?: 0
// println("Null treats handled with Elvis: $nullTreats") // Output: 0

// STEP 4.3: Double-bang (!!) operator
// var s: String? = "Kotlin"
// val len1 = s!!.length
// println("Length of s using double-bang: $len1") // Output: 6

// Uncomment the lines below to see the NullPointerException
// var t: String? = null
// val len2 = t!!.length // This will throw NullPointerException

// Explore Arrays, Lists, and Loops
// STEP 1: Lists
val school = listOf("mackerel", "trout", "halibut")
println(school)   // [mackerel, trout, halibut]

val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")
println(myList)   // [tuna, salmon]

// STEP 2: Arrays
val fishArray = arrayOf("shark", "salmon", "minnow")
println(java.util.Arrays.toString(fishArray))   // [shark, salmon, minnow]

val mix = arrayOf("fish", 2)
println(java.util.Arrays.toString(mix))  // [fish, 2]

val numbers = intArrayOf(1, 2, 3)
val numbers3 = intArrayOf(4, 5, 6)
val foo2 = numbers3 + numbers
println(foo2[5])  // 3

val oceans = listOf("Atlantic", "Pacific")
val oddList = listOf(numbers, oceans, "salmon")
println(oddList)  // [[I@..., [Atlantic, Pacific], salmon]

val array = Array(5) { it * 2 }
println(java.util.Arrays.toString(array))   // [0, 2, 4, 6, 8]

// STEP 3: Loops
println("For loop through array")
val schoolFish = arrayOf("shark", "salmon", "minnow")
for (element in schoolFish) {
    print(element + " ")
}
println("\n")

// For loop with index
for ((index, element) in schoolFish.withIndex()) {
    println("Item at $index is $element")
}

// Ranges and steps
for (i in 1..5) print(i)
println()
for (i in 5 downTo 1) print(i)
println()
for (i in 3..6 step 2) print(i)
println()
for (i in 'd'..'g') print(i)
println()

// While loop, do...while loop, and repeat"
var bubbles = 0
while (bubbles < 50) {
    bubbles++
}
println("$bubbles bubbles in the water")

do {
    bubbles--
} while (bubbles > 50)
println("$bubbles bubbles in the water")

repeat(2) {
    println("A fish is swimming")
}
