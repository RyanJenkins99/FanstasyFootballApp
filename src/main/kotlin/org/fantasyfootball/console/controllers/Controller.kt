package org.fantasyfootball.console.controllers

import mu.KotlinLogging
import org.fantasyfootball.console.models.PlayerMemStore
import org.fantasyfootball.console.models.PlayerModel
import org.fantasyfootball.console.models.TeamMemStore
import org.fantasyfootball.console.models.TeamModel
import org.fantasyfootball.console.views.PlayerView
import org.fantasyfootball.console.views.TeamView

class Controller {

    val teams = TeamMemStore()
    val players = PlayerMemStore()
    val teamView = TeamView()
    val playerView = PlayerView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Fantasy Football App" }
        println("Fantasy FootballApp ")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> addTeam()
                2 -> updateTeam()
                3 -> listTeams()
                4 -> searchTeams()
                5 -> deleteTeam()
                6 ->{ players.create()
                    playerView.playerMenu()}
                -99 -> dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Fantasy Football App" }
    }

    fun menu() :Int { return teamView.menu() }
    fun menu2() :Int { return playerView.menu2() }

    fun addTeam(){
        val aTeam = TeamModel()

        if (teamView.addTeamData(aTeam))
            teams.create(aTeam)
        else
            logger.info("Team Not Added")
    }

    fun listTeams() {
        teamView.listTeams(teams)
    }

    fun listPlayers() {
        playerView.listPlayers(players)
    }

    fun deleteTeam() {
        listTeams()
        print("Enter index to delete")
        var index = readLine()!!

        teams.delete(teams.teams.get(index.toInt()))

    }

    fun updateTeam() {

        teamView.listTeams(teams)
        val searchId = teamView.getId()
        val aTeam = search(searchId)

        if(aTeam != null) {
            if(teamView.updateTeamData(aTeam)) {
                teams.update(aTeam)
                teamView.showTeam(aTeam)
                logger.info("Team Updated : [ $aTeam ]")
            }
            else
                logger.info("Team Not Updated")
        }
        else
            println("Team Not Updated...")
    }

    fun searchTeams() {
        val aTeam = search(teamView.getId())!!
        teamView.showTeam(aTeam)
    }


    fun search(id: Long) : TeamModel? {
        val foundTeam = teams.findOne(id)
        return foundTeam
    }



    fun dummyData() {
        teams.create(TeamModel(title = "New York New York", description = "So Good They Named It Twice"))
        teams.create(TeamModel(title= "Ring of Kerry", description = "Some place in the Kingdom"))
        teams.create(TeamModel(title = "Waterford City", description = "You get great Blaas Here!!"))
    }
}