package com.github.vjames19.aima.environment.vacuum

import com.github.vjames19.aima.agent.Action
import com.github.vjames19.aima.agent.Agent
import com.github.vjames19.aima.agent.Percept
import com.github.vjames19.aima.agent.impl.AbstractEnvironment

/**
 * Created by victor.reventos on 8/9/17.
 */
class VacuumEnvironment(val state: VacuumEnvironmentState) : AbstractEnvironment() {

    override fun isDone(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPerceptSeenBy(agent: Agent): Percept {
        val location = state.agentLocation(agent)
        val dirtyStatus = state.locationDirtyStatus(location)
        return VacuumState(dirtyStatus, location)
    }

    override fun executeAction(agent: Agent, action: Action) {
        if (action is VacuumAction) {
            when(action) {
                is Suck -> cleanLocation(state.agentLocation(agent))
                is MoveLeft-> state.agentsLocation[agent] = VacuumEnvironmentLocation.Left
                is MoveRight -> state.agentsLocation[agent] = VacuumEnvironmentLocation.Right
            }
        }
    }

    private fun cleanLocation(location: VacuumEnvironmentLocation) {
        state.locationDirtyStatus[if (location == VacuumEnvironmentLocation.Left) 0 else 1] = DirtyStatus.Clean
    }
}
