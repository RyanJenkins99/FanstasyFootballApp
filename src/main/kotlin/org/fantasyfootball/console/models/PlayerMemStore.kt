package org.fantasyfootball.console.models

import mu.KotlinLogging



private val logger = KotlinLogging.logger {}

class PlayerMemStore : PlayerStore {

    val players = ArrayList<PlayerModel>()

    override fun findAll(): List<PlayerModel> {
        return players
    }

    override fun findByPosition(position: String): ArrayList<PlayerModel> {
        val foundPlayers: ArrayList<PlayerModel>  = arrayListOf()//Assign empty array list of players
        players.forEach{//loop through all players in the mem store
            if(it.position == position) //it = current object and checks if the position match
                foundPlayers.add(it) //add it to the list
        }
        return foundPlayers
    }

    override fun findByNumber(number: Int): ArrayList<PlayerModel> {
        val foundPlayers: ArrayList<PlayerModel>  = arrayListOf()
        players.forEach{
            if(it.number == number)
                foundPlayers.add(it)
        }
        return foundPlayers
    }

    override fun create() {
        players.add(PlayerModel("Cristiano Ronaldo","Striker",7))
        players.add(PlayerModel("Erling Haaland","Striker",9))
        players.add(PlayerModel("Harry Kane","Striker",9))
        players.add(PlayerModel("Ivan Toney","Striker",17))
        players.add(PlayerModel("Muhammad Salah","Winger",11))
        players.add(PlayerModel("Jadon Sancho","Winger",25))
        players.add(PlayerModel("Marcus Rashford","Winger",10))
        players.add(PlayerModel("Phil Foden","Winger",47))
        players.add(PlayerModel("Kevin De Bruyne","Mid",17))
        players.add(PlayerModel("Bruno Fernandes","Mid",8))
        players.add(PlayerModel("Ngolo Kante","Mid",7))
        players.add(PlayerModel("Christian Erikson","Mid",14))
        players.add(PlayerModel("Declan Rice","Mid",41))
        players.add(PlayerModel("Ruben Dias","Defender",3))
        players.add(PlayerModel("Harry Maguire","Defender",5))
        players.add(PlayerModel("Raphael Varane","Defender",19))
        players.add(PlayerModel("Reece James","Defender",24))
        players.add(PlayerModel("Trent Alexander Arnold","Defender",66))
        players.add(PlayerModel("Virgil Van Dijk","Defender",4))
        players.add(PlayerModel("Ivan Perisic","Defender",14))
        players.add(PlayerModel("Joao Cancelo","Defender",7))


    }

    internal fun logAll() {
        players.forEach { logger.info("${it.name}, ${it.position}, ${it.number}") }
    }

    override fun add(player: PlayerModel) {
        players.add(player)
    }

}