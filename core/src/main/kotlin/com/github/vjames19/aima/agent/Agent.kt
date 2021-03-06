package com.github.vjames19.aima.agent

/**
 * Created by victor.reventos on 8/8/17.
 */
interface Agent {

    fun execute(percept: Percept): Action

    var isAlive: Boolean
}