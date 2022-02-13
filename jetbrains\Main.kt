package parking
import java.util.Scanner

val scanner = Scanner(System.`in`)

var parking = mutableListOf<String>()

var spotsNumber: Int = 0

var carNumber: Int = 0

fun main() {
    while(scanner.hasNext()) {
        when (scanner.next()) {
            "create" -> create()
            "status" -> status()
            "park" -> park()
            "leave" -> leave()
            "reg_by_color" -> regByColor()
            "spot_by_color" -> spotByColor()
            "spot_by_reg" -> spotByReg()
            "exit" ->  break
        }
    }
}

fun create() {
    spotsNumber = 0
    parking.clear()
    carNumber = scanner.nextInt()
    println("Created a parking lot with $carNumber spots.")
}

fun status() {
    if (parking.isNotEmpty() && carNumber > 0) {
        for (i in parking.indices) {
            if (parking[i].isNotEmpty()){
                println("${i + 1} " + parking[i])
            }
        }
    } else if (parking.isEmpty() && carNumber > 0) {
        println("Parking lot is empty.")
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}

fun park() {
    if (carNumber > 0) {
        spotsNumber += 1
        if (spotsNumber <= carNumber) {
            val car = scanner.nextLine().substringAfter(" ")
            parking += car.uppercase()
            val color = car.substringAfter(" ")
            println("$color car parked in spot ${parking.indexOf(car.uppercase()) + 1}.")
        } else {
            println("Sorry, the parking lot is full.")
        }
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}

fun leave() {
    if (parking.isNotEmpty() && carNumber > 0) {
        val slot = scanner.nextInt()
        parking[slot - 1] = ""
        println("Spot $slot is free.")
    }else if (parking.isEmpty() && carNumber > 0) {
        println("Parking lot is empty.")
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}

@Suppress("UNUSED_EXPRESSION")
fun regByColor() {
    val color = scanner.next()
    val regs = mutableListOf<String>()
    if (parking.isNotEmpty() && carNumber > 0){
        for (i in parking.indices) {
            if (color.uppercase() == parking[i].substringAfter(" ")) {
                regs += parking[i].substringBefore(" ")
            } else {
                null
            }
        }
        if (regs.isNotEmpty()) {
            println(regs.joinToString())
        } else {
            println("No cars with color $color were found.")
        }
    } else if (parking.isEmpty() && carNumber > 0) {
        println("Parking lot is empty.")
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}

@Suppress("UNUSED_EXPRESSION")
fun spotByColor() {
    val color = scanner.next()
    val slots = mutableListOf<Int>()
    if (parking.isNotEmpty() && carNumber > 0){
        for (i in parking.indices) {
            if (color.uppercase() == parking[i].substringAfter(" ")) {
                slots += i+1
            } else {
                null
            }
        }
        if (slots.isNotEmpty()) {
            println(slots.joinToString())
        } else {
            println("No cars with color $color were found.")
        }
    } else if (parking.isEmpty() && carNumber > 0) {
        println("Parking lot is empty.")
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}

@Suppress("UNUSED_EXPRESSION")
fun spotByReg() {
    val reg = scanner.next()
    var spot = 0
    if (parking.isNotEmpty() && carNumber > 0){
        for (i in parking.indices) {
            if (reg.uppercase() == parking[i].substringBefore(" ")) {
                spot = i+1
            } else {
                null
            }
        }
        if (spot != 0) {
            println(spot)
        } else {
            println("No cars with registration number $reg were found.")
        }
    } else if (parking.isEmpty() && carNumber > 0) {
        println("Parking lot is empty.")
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}
