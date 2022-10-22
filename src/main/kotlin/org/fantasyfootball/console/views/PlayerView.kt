package org.fantasyfootball.console.views

import org.fantasyfootball.console.main.controller
import org.fantasyfootball.console.models.PlayerMemStore
import org.fantasyfootball.console.models.PlayerModel


class PlayerView {

    fun menu2() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. List All Players")
        println(" 2. Add Player")
        println(" 3. Search Players")
        println(" -1. Exit")
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
                2 -> addPlayer() // so this is broken now lets fix that
                3 -> searchPLayers(controller.players)


                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
       // logger.info { "Shutting Down Fantasy Football App" }
    }
    fun listPlayers(players : PlayerMemStore) {


        println(
            "\n" +
                    "\n" +
                    "█░░ █ █▀ ▀█▀   █▀█ █░░ ▄▀█ █▄█ █▀▀ █▀█ █▀\n" +
                    "█▄▄ █ ▄█ ░█░   █▀▀ █▄▄ █▀█ ░█░ ██▄ █▀▄ ▄█"
        )

        println("List All Players")
        println()
        players.logAll()

        println()
    }

    fun addPlayer(): PlayerModel {

        println(
            "\n" +
                    "\n" +
                    "▄▀█ █▀█ █▀█   █▀█ █░░ ▄▀█ █▄█ █▀▀ █▀█ █▀\n" +
                    "█▀█ █▀▀ █▀▀   █▀▀ █▄▄ █▀█ ░█░ ██▄ █▀▄ ▄█"
        )


        println("Adding a new player")
        val newPLayer = PlayerModel()

        println("Enter PLayer Name: ")
        newPLayer.name = readLine()!!

        println("Enter PLayer Position: ")
        newPLayer.position = readLine()!!

        println("Enter PLayer Number: ")
        newPLayer.number = readLine()!!.toInt()

        return newPLayer
    }

    fun searchPLayers(players : PlayerMemStore): Int {
        val choice : Int


        println(
            "\n" +
                    "\n" +
                    "█▀ █▀▀ ▄▀█ █▀█ █▀▀ █░█   █▀█ █░░ ▄▀█ █▄█ █▀▀ █▀█ █▀\n" +
                    "▄█ ██▄ █▀█ █▀▄ █▄▄ █▀█   █▀▀ █▄▄ █▀█ ░█░ ██▄ █▀▄ ▄█"
        )


        println("Search for a Player Menu")
        println()
        println("1. Search by Pos")
        println("2. Search by num")
        val input: String? = readLine()!!
        choice = if (input!!.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return choice
    }


    }



