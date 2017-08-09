package com.github.vjames19.aima.agent.impl

import com.github.vjames19.aima.agent.*

/**
 * Created by victor.reventos on 8/8/17.
 */
abstract class ModelbasedReflexAgentProgram<S: State, M: Model>(val rules: Set<Rule>) : AgentProgram {

    var state: S? = null
    var model: M? = null
    var action: Action? = null

    override fun execute(percept: Percept): Action {
        val state = updateState(state, model, action, percept)
        val rule = ruleMatch(rules, state)
        return rule?.action ?: NoopAction
    }

    abstract fun updateState(state: S?, model: M?, action: Action?, percept: Percept): S
    abstract fun ruleMatch(rules: Set<Rule>, state: S): Rule?
}