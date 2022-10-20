package org.fantasyfootball.console.models

interface PlayerStore {

    fun findAll(): List<PlayerModel>
    fun findByPosition(id: String): ArrayList<PlayerModel>
    fun create()
    fun add(player: PlayerModel)
    fun findByNumber(num: Int): ArrayList<PlayerModel>


}

