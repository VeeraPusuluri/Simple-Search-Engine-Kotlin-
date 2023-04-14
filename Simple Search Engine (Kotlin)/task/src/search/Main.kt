package search

import java.io.File

var inputData = mutableListOf<String>()
val mapWithIndices = mutableMapOf<String, MutableList<Int>>()

fun main(args: Array<String>) {
    val fileName = args[1]
    inputData = File(fileName).readLines().toMutableList()
    for (i in inputData.indices) {
        val eachLine = inputData[i].split(" ").toMutableList()
        for (eachLineIndex in eachLine.indices) {
            val eachWord = eachLine[eachLineIndex].lowercase()
            if (mapWithIndices.contains(eachWord)) {
                val res = mapWithIndices[eachWord]
                res!!.add(i)
            } else {
                mapWithIndices[eachWord] = mutableListOf(i)
            }
        }
    }
    Stage2()
}

class Stage2 {
    init {
        displayMenu()
    }
    private fun displayMenu() {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
        when (readln().toInt()) {
            0 -> {
                println("Bye!")
                return
            }

            1 -> findSearch() // Finding search word in users list

            2 -> printAllPeople()
            else -> {
                println("Incorrect option! Try again.")
                displayMenu()
            }
        }
    }


    private fun printAllPeople() {
        println("=== List of people ===")
        inputData.forEach { println(it) }
        displayMenu()
    }

    private fun findSearch() {
        println("Select a matching strategy: ALL, ANY, NONE")
        when (readln()) {
            "ALL" -> {
                searchAllMatchesFromQuery(printEnterSearchInstructionStatement())
            }

            "ANY" -> {
                searchAnyMatchesFromQuery(printEnterSearchInstructionStatement())
            }

            "NONE" -> {
                searchNoneMatchesFromQuery( printEnterSearchInstructionStatement())
            }
        }

    }

    private fun searchAllMatchesFromQuery(searchWord: String) {
        val search = searchWord.split(" ")
        val searchResults = mutableListOf<String>()
        inputData.forEach { line ->
            var matchingWordCount = 0
            search.forEach { word ->
                if (line.lowercase().contains(word.lowercase())) matchingWordCount++
            }
            if (matchingWordCount == search.size) {
                searchResults.add(line)
            }
        }
        printlnSearchResults(searchResults)
    }

    private fun searchAnyMatchesFromQuery(searchWord: String) {
        val search = searchWord.split(" ")
        val searchResults = mutableListOf<String>()
        inputData.forEach { line ->
            var containsAtleastOneWord = false
            search.forEach { word ->
                if (line.lowercase().contains(word.lowercase())) containsAtleastOneWord = true
            }
            if (containsAtleastOneWord) searchResults.add(line)
        }
        printlnSearchResults(searchResults)
    }

    private fun searchNoneMatchesFromQuery(searchWord: String) {
        val search = searchWord.split(" ")
        val searchResults = mutableListOf<String>()
        inputData.forEach { line ->
            var containsAtleastOneWord = false
            search.forEach { word ->
                if (line.lowercase().contains(word.lowercase())) containsAtleastOneWord = true
            }
            if (!containsAtleastOneWord) searchResults.add(line)
        }
        printlnSearchResults(searchResults)
    }


    private fun printlnSearchResults(searchResults: MutableList<String>) {
        val size = searchResults.size
        val person = if (size > 1) "persons" else "person"
        println("$size $person found:")
        searchResults.forEach {
            println(it)
        }
        displayMenu()
    }

    private fun printEnterSearchInstructionStatement(): String {
        println("Enter a name or email to search all matching people.")
        return readln()
    }
}















/*
*
*  /* println("Enter a name or email to search all matching people.")
        val searchName = readln().lowercase()
        val searchResult = mapWithIndices[searchName]
        if (searchResult != null) {
            val size = searchResult.size
            val person = if (size > 1) "persons" else "person"
            println("$size $person found")
            searchResult.forEach {
                println(inputData[it])
            }
        } else {
            println("No matching people found.")
        }
        displayMenu()
        */
    */


/*
*  private fun printResultList(data: List<String>) {
        return if (data.isNotEmpty()) {
            data.forEach { println(it) }
        } else println("No matching people found.")
    }
    * */

/*fun findIndexOfSearch() {
    val inputData: List<String> = readln().split(" ").toMutableList()
    val wordToSearch = readln()
    var searchPosition = ""
    searchPosition =
        if (inputData.contains(wordToSearch)) (inputData.indexOf(wordToSearch) + 1).toString() else "Not found"
    println(searchPosition)
}*/

/*
*  private fun findSearch() {
        println("Enter a name or email to search all suitable people.")
        val searchCount = readln().toInt()
        println("Enter data to search people:")
        for (i in 1..searchCount) {
            val searchWord = readln()
            println()
            val resultList = mutableListOf<String>()
            inputList.forEach {
                if (it.lowercase().contains(searchWord.lowercase())) resultList.add(it)
            }
            printResultList(resultList)
        }
        displayMenu()
    }

    private fun printResultList(data: List<String>) {
        return if (data.isNotEmpty()) {
            data.forEach { println(it) }
        } else println("No matching people found.")
    }
* */

/*
*     private fun readInputData() {
//        //Taking input data
//        println("Enter the number of people:")
//        val inputDataSize = readln().toInt()
//        println("Enter all people:")
//        for (i in 1..inputDataSize) {
//            this.inputList.add(readln().trim())
//        }
//        println()
        displayMenu()
    }*/

/*
* private fun findSearch() {
        val resultList = mutableListOf<String>()
        println("Enter a name or email to search all suitable people.")
        val searchName = readln()
        inputData.forEach {
            if (it.lowercase().contains(searchName.lowercase())) resultList.add(it)
        }
        printResultList(resultList)
        displayMenu()
    }*/