package org.fantasyfootball.console.main

import mu.KotlinLogging
import org.fantasyfootball.console.models.TeamModel

private val logger = KotlinLogging.logger {}

val teams = ArrayList<TeamModel>()

fun main(args: Array<String>) {
    logger.info { "Launching Fantasy Football App" }
    println(" Fanstasy Football app ")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addTeam()
            2 -> updateTeam()
            3 -> listTeams()
            4 -> searchTeam()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Fantasy App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("MAIN MENU")
    println(" 1. Add Team")
    println(" 2. Update Team")
    println(" 3. List All Team")
    println("-1. Exit")
    println()
    print("Enter Option : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addTeam(){
    var aTeam = TeamModel()
    println("Add Team")
    println()
    print("Enter a Title : ")
    aTeam.title = readLine()!!
    print("Enter a Description : ")
    aTeam.description = readLine()!!

    if (aTeam.title.isNotEmpty() && aTeam.description.isNotEmpty()) {
        aTeam.id = teams.size.toLong()
        teams.add(aTeam.copy())
        logger.info("Team Added : [ $aTeam ]")
    }
    else
        logger.info("Team Not Added")
}


fun updateTeam() {
    println("Update Team")
    println()
    listTeams()
    var searchId = getId()
    val aTeam = search(searchId)
    var tempTitle: String?
    var tempDescription: String?

    if (aTeam != null) {
        print("Enter a new Title for [ " + aTeam.title + " ] : ")
        tempTitle = readLine()!!
        print("Enter a new Description for [ " + aTeam.description + " ] : ")
        tempDescription = readLine()!!

        if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
            aTeam.title = tempTitle
            aTeam.description = tempDescription
            println(
                "You updated [ " + aTeam.title + " ] for title " +
                        "and [ " + aTeam.description + " ] for description"
            )
            logger.info("Placemark Updated : [ $aTeam ]")
        } else
            logger.info("Team Not Updated")
    } else
        println("Team Not Updated...")
}

fun listTeams() {
    println("List All Teams")
    println()
    teams.forEach { logger.info("${it}") }
    println()
}

fun searchTeam() {

    var searchId = getId()
    val aTeam = search(searchId)

    if(aTeam != null)
        println("Team Details [ $aTeam ]")
    else
        println("Team Not Found...")
}

fun getId() : Long {
    var strId : String? // String to hold user input
    var searchId : Long // Long to hold converted id
    print("Enter id to Search/Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : TeamModel? {
    var foundTeam: TeamModel? = teams.find { p -> p.id == id }
    return foundTeam
}

fun dummyData() {
    teams.add(TeamModel(1, "New York New York", "So Good They Named It Twice"))
    teams.add(TeamModel(2, "Ring of Kerry", "Some place in the Kingdom"))
    teams.add(TeamModel(3, "Waterford City", "You get great Blaas Here!!"))
}