package com.github.vjames19.aima.agent.impl

import com.github.vjames19.aima.agent.*

/**
 * Created by victor.reventos on 8/8/17.
 */
abstract class SimpleReflexAgentProgram<S: State> (val rules: Set<Rule>): AgentProgram {

    override fun execute(percept: Percept): Action {
        val state = interpretInput(percept)
        val rule = ruleMatches(state, rules)
        return rule?.action ?: NoopAction
    }

    abstract fun interpretInput(percept: Percept): S

    abstract fun ruleMatches(state: S, rules: Set<Rule>): Rule?
}