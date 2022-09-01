fun main() {
    var supplies = arrayOf<Array<String>>()
    val items = arrayOf("buns", "sausage links", "mustard", "relish", "pickles")
    var qty = arrayOf("10", "7", "9", "5", "14")
    var menuOption = 0

    supplies += items
    supplies += qty

    // THIS FUNCTION ALLOWS THE USER TO SEARCH FOR AN ITEM WITHIN THE ARRAY AND SEE ITS QUANTITY
    fun search(){
        print("Search item to see its name and quantity: ")
        val userSearch = readLine()!!.toString()

        for (item1 in supplies[0]){
            if (userSearch.compareTo(item1, ignoreCase = true) == 0){
                println("${item1.capitalize()} has a quantity of ${supplies[1][supplies[0].indexOf(item1)]}") // NOT SURE WHY IT SAYS CAPITALIZE IS DEPRECATED WHILE IT STILL WORKS
            }
        }
    }

    // THIS FUNCTION ALLOWS THE USER TO MAKE A CHANGE TO AN ITEM WITHIN THE ARRAY
    fun update(){
        println("1. buns")
        println("2. sausage links")
        println("3. mustard")
        println("4. relish")
        println("5. pickles")
        print("Which items quantity would you like to change(type the name of the item): ")
        val userUpdate = readLine()!!.toString() // LETS USER CHOOSE WHICH ITEM TO CHANGE

        print("How much would you like to change the quantity by(positive for addition, negative for subtraction): ")
        val userQuantityChange = readLine()!!.toInt() // VALUE OF CHANGE

        // THIS FOR LOOP LOOKS IN THE ARRAY TO SEE IF THE USER CHOSE A VALID OPTION, THEN MAKES THE CHANGES IF THE OPTION IS VALID
        for (item2 in supplies[0]){
            if (userUpdate.compareTo(item2, ignoreCase = true) == 0){
                val oldQuantity = supplies[1][supplies[0].indexOf(userUpdate)].toInt()
                var newQuantity = supplies[1][supplies[0].indexOf(userUpdate)].toInt() + userQuantityChange
                println("Item: $item2 \nOld quantity: $oldQuantity \nNew quantity: $newQuantity \nDifference of amounts: $userQuantityChange")

                // CHECKS TO MAKE SURE THE NEW QUANTITY ISN'T NEGATIVE
                if (newQuantity < 0){
                    println("ERROR: Quantity can't be less than 0, setting to 0")
                    newQuantity = 0
                }

                supplies[1][supplies[0].indexOf(userUpdate)] = newQuantity.toString() // ACTUALLY MAKES THE CHANGE TO THE ARRAY

            }
        }
    }

    // CONSTANTLY SHOWS THE MENU UNTIL THE USER WANTS TO EXIT, ALLOWS FOR INFINITE CHANGES AND SEARCHES
    while (menuOption != 3) {
        println("1. Search")
        println("2. Update")
        println("3. Exit")
        print("Choose an option(type the number of the action): ")
        menuOption = readLine()!!.toInt()

        // OPENS THE DIFFERENT FUNCTIONS BASED ON WHAT THE USER CHOSE
        if (menuOption == 1){
            search()
        } else if (menuOption == 2){
            update()
        }
    }
}