package com.github.vjames19.aima.agent

/**
 * Created by victor.reventos on 8/8/17.
 */
interface Environment {

    fun agents(): List<Agent>
    fun addAgent(agent: Agent)
    fun removeAgent(agent: Agent)


    fun isDone(): Boolean
    fun step(n: Int = 1)
    fun stepUntilDone()
}