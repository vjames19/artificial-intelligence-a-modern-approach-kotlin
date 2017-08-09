package com.github.vjames19.aima.agent

/**
 * Created by victor.reventos on 8/8/17.
 */
interface Environment {

    fun agents(): List<Agent>
    fun addAgent(agent: Agent)
    fun removeAgent(agent: Agent)


    fun isDone(): Boolean
    fun step()
    fun step(n: Int) {
        for (i in 0 until n) {
            step()
        }
    }
    fun stepUntilDone()
}