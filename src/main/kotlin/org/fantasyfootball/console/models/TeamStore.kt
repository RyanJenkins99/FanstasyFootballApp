package org.fantasyfootball.console.models

interface TeamStore {
    fun findAll(): List<TeamModel>
    fun findOne(id: Long, team: MutableList<TeamModel>): TeamModel?
    fun create(team: TeamModel)
    fun update(team: TeamModel)
    fun delete(team: TeamModel)
}