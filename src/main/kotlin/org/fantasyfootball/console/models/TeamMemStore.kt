package org.fantasyfootball.console.models

import mu.KotlinLogging
import org.fantasyfootball.console.models.TeamModel
import org.fantasyfootball.console.models.TeamStore

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class   TeamMemStore : TeamStore {

    val teams = ArrayList<TeamModel>()

    override fun findAll(): List<TeamModel> {
        return teams
    }

    override fun findOne(id: Long) : TeamModel? {
        var foundTeam: TeamModel? = teams.find { p -> p.id == id }
        return foundTeam
    }

    override fun create(Team: TeamModel) {

        teams.add(Team)
        logAll()
    }

    override fun update(team: TeamModel) {
        var foundTeam = findOne(team.id!!)
        if (foundTeam != null) {
            foundTeam.id = team.id

        }
    }
    override fun delete(Team:TeamModel){

    }

    internal fun logAll() {
        teams.forEach { logger.info("${it}") }
    }
}