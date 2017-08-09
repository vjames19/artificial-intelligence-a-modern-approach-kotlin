package com.github.vjames19.aima.agent

/**
 * Created by victor.reventos on 8/8/17.
 */
interface AgentProgram {

    fun execute(percept: Percept): Action
}