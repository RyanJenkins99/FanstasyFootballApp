package org.fantasyfootball.console.views

import org.fantasyfootball.console.models.TeamJSONStore
import org.fantasyfootball.console.models.TeamModel

class TeamView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println(
            "\n" +
                    "\n" +
                    "\n" +
                    "█▀▀ ▄▀█ █▄░█ ▀█▀ ▄▀█ █▀ █▄█   █▀▀ █▀█ █▀█ ▀█▀ █▄▄ ▄▀█ █░░ █░░   ▄▀█ █▀█ █▀█\n" +
                    "█▀░ █▀█ █░▀█ ░█░ █▀█ ▄█ ░█░   █▀░ █▄█ █▄█ ░█░ █▄█ █▀█ █▄▄ █▄▄   █▀█ █▀▀ █▀▀"
        )

        println("MAIN MENU")
        println(" 1. Add Team")
        println(" 2. Update Team")
        println(" 3. List All Teams")
        println(" 4. Search Teams")
        println(" 5. Delete Teams")
        println(" 6. Go to player options")
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

    fun listTeams(teams: TeamJSONStore) {

        println(
            "\n" +
                    "\n" +
                    "█░░ █ █▀ ▀█▀   ▀█▀ █▀▀ ▄▀█ █▀▄▀█ █▀\n" +
                    "█▄▄ █ ▄█ ░█░   ░█░ ██▄ █▀█ █░▀░█ ▄█"
        )

        println()
        teams.logAll()
        println()
    }

    fun showTeam(team : TeamModel) {
        if(team != null)
            println("Team Details [ $team ]")
        else
            println("Team Not Found...")
    }

    fun addTeamData(team : TeamModel) : Boolean {


        println(
            "\n" +
                    "\n" +
                    "▄▀█ █▀▄ █▀▄   ▀█▀ █▀▀ ▄▀█ █▀▄▀█\n" +
                    "█▀█ █▄▀ █▄▀   ░█░ ██▄ █▀█ █░▀░█"
        )

        println()
        print("Enter a Title : ")
        team.title = readLine()!!
        print("Enter a formation : ")
        team.description = readLine()!!

        return team.title.isNotEmpty() && team.description.isNotEmpty()
    }

    fun updateTeamData(team : TeamModel) : Boolean {

        val tempTitle: String?
        val tempDescription: String?


        println(
            "\n" +
                    "\n" +
                    "\n" +
                    "█░█ █▀█ █▀▄ ▄▀█ ▀█▀ █▀▀   ▀█▀ █▀▀ ▄▀█ █▀▄▀█ █▀\n" +
                    "█▄█ █▀▀ █▄▀ █▀█ ░█░ ██▄   ░█░ ██▄ █▀█ █░▀░█ ▄█"
        )

        if (team != null) {
            print("Enter a new Title for [ " + team.title + " ] : ")
            tempTitle = readLine()!!
            print("Enter a new formation for [ " + team.description + " ] : ")
            tempDescription = readLine()!!

            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
                team.title = tempTitle
                team.description = tempDescription
                return true
            }
        }
        return false
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
}