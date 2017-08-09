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

    override val agentProgram: AgentProgram = object : SimpleReflexAgentProgram<VacuumEnvironmentState>(rules) {
        override fun interpretInput(percept: Percept): VacuumEnvironmentState {
            return percept as VacuumEnvironmentState
        }
    }

    companion object {
        val rules = setOf(
                DirtyRule,
                MoveRightRule,
                MoveLeftRule)
    }
}

object DirtyRule : Rule<VacuumEnvironmentState> {

    override fun evaluate(state: VacuumEnvironmentState): Boolean {
        return state.dirtyStatus == DirtyStatus.Dirty
    }

    override val action: Action = Suck
}

object MoveRightRule : Rule<VacuumEnvironmentState> {
    override fun evaluate(state: VacuumEnvironmentState): Boolean {
        return state.location == Location.Left
    }

    override val action: Action = MoveRight
}

object MoveLeftRule : Rule<VacuumEnvironmentState> {
    override fun evaluate(state: VacuumEnvironmentState): Boolean {
        return state.location == Location.Left
    }

    override val action: Action = MoveRight
}