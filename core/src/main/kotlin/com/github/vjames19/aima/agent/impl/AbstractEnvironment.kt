package com.github.vjames19.aima.agent.impl

import com.github.vjames19.aima.agent.Action
import com.github.vjames19.aima.agent.Agent
import com.github.vjames19.aima.agent.Environment
import com.github.vjames19.aima.agent.Percept

/**
 * Created by victor.reventos on 8/9/17.
 */
abstract class AbstractEnvironment : Environment {

    val agents = mutableSetOf<Agent>()

    override fun agents(): List<Agent> = agents.toList()

    override fun addAgent(agent: Agent) {
        agents.add(agent)
    }

    override fun removeAgent(agent: Agent) {
        agents.remove(agent)
    }

    override fun step() {
        agents.asSequence()
                .filter { it.isAlive }
                .forEach(this::stepAgent)
    }

    private fun stepAgent(agent: Agent) {
        val percept = getPerceptSeenBy(agent)
        val action = agent.execute(percept)
        executeAction(agent, action)
    }

    override fun stepUntilDone() {
        while(!isDone()) {
            step()
        }
    }


    abstract fun getPerceptSeenBy(agent: Agent): Percept
    abstract fun executeAction(agent: Agent, action: Action)
}