package org.fantasyfootball.console.views

import org.fantasyfootball.console.main.controller
import org.fantasyfootball.console.models.PlayerMemStore

class PlayerView {

    fun menu2() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. List All Players")
        println(" 2. Add Player")
        println(" 3. Search Players")
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

    fun playerMenu() {
        var input: Int

        do {
            input = menu2()
            when (input) {
                1 -> listPlayers(controller.players)
//                2 -> updateTeam()
//                3 -> listTeams()


                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
       // logger.info { "Shutting Down Fantasy Football App" }
    }
    fun listPlayers(players : PlayerMemStore) {
        println("List All Players")
        println()
        players.logAll()

        println()
    }


    }



