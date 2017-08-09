package com.github.vjames19.aima.agent.impl

import com.github.vjames19.aima.agent.Action
import com.github.vjames19.aima.agent.Agent
import com.github.vjames19.aima.agent.AgentProgram
import com.github.vjames19.aima.agent.Percept

/**
 * Created by victor.reventos on 8/8/17.
 */
abstract class AgentExecutingAgentProgram(val agentProgram: AgentProgram) : Agent {

    override fun execute(percept: Percept): Action {
        return agentProgram.execute(percept)
    }
}