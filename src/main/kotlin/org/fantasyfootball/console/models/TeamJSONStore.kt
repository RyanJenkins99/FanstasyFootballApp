package org.fantasyfootball.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.fantasyfootball.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}


val JSON_FILE = "teams.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<TeamModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class TeamJSONStore : TeamStore {

    var teams = mutableListOf<TeamModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<TeamModel> {
        return teams
    }

    override fun findOne(id: Long, teams: MutableList<TeamModel>) : TeamModel? {
        var foundTeam: TeamModel? = teams.find { p -> p.id == id }
        return foundTeam
    }

    override fun create(team: TeamModel) {
        team.id = generateRandomId()
        teams.add(team)
        logAll()
        serialize()
    }

    override fun update(team: TeamModel) {
//        var foundTeam = findOne(team.id!!)
//        if (foundTeam != null) {
//            foundTeam.title = team.title
//            foundTeam.description = team.description
//        }
//        serialize()
    }

    override fun delete(Team:TeamModel){
        teams.remove(Team)
    }

    internal fun logAll() {
        teams.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(teams, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        teams = Gson().fromJson(jsonString, listType)
    }
}