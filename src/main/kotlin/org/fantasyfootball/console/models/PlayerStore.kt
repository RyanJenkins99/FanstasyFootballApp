package org.fantasyfootball.console.models

interface PlayerStore {

    fun findAll(): List<PlayerModel>
    fun findOne(id: Long): PlayerModel?
    fun create()


}

