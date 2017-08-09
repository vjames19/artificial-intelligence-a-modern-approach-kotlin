package com.github.vjames19.aima.environment.vacuum

import com.github.vjames19.aima.agent.Action
import com.github.vjames19.aima.agent.AgentProgram
import com.github.vjames19.aima.agent.Percept
import com.github.vjames19.aima.agent.impl.AgentExecutingAgentProgram
import com.github.vjames19.aima.agent.impl.Rule
import com.github.vjames19.aima.agent.impl.SimpleReflexAgentProgram

/**
 * Created by victor.reventos on 8/9/17.
 */
class SimpleReflexVacuumAgent : AgentExecutingAgentProgram() {

    override val agentProgram: AgentProgram = object : SimpleReflexAgentProgram<VacuumState>(rules) {
        override fun interpretInput(percept: Percept): VacuumState {
            val ves = percept as VacuumEnvironmentState
            val location = ves.agentLocation(this@SimpleReflexVacuumAgent)
            val dirtyStatus = ves.locationDirtyStatus(location)
            return VacuumState(dirtyStatus, location)
        }
    }

    companion object {
        val rules = setOf(
                DirtyRule,
                MoveRightRule,
                MoveLeftRule)
    }
}

object DirtyRule : Rule<VacuumState> {

    override fun evaluate(state: VacuumState): Boolean {
        return state.dirtyStatus == DirtyStatus.Dirty
    }

    override val action: Action = Suck
}

object MoveRightRule : Rule<VacuumState> {
    override fun evaluate(state: VacuumState): Boolean {
        return state.location == VacuumEnvironmentLocation.Left
    }

    override val action: Action = MoveRight
}

object MoveLeftRule : Rule<VacuumState> {
    override fun evaluate(state: VacuumState): Boolean {
        return state.location == VacuumEnvironmentLocation.Left
    }

    override val action: Action = MoveRight
}