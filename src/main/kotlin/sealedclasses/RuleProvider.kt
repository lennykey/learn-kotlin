package sealedclasses

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

sealed class RuleProvider<T> {

    abstract class Rule<T> : RuleProvider<T>() {
        abstract fun execute(): T
    }

    abstract class Provider<T> : RuleProvider<T>(), ReadOnlyProperty<Nothing?, String> {
        abstract var ruleProvider: RuleProvider<T>
        fun evaluate(ruleProvider: RuleProvider<String>, thisRef: Nothing?, property: KProperty<*>): String {
            return when (ruleProvider) {
                is Rule -> ruleProvider.execute()
                is Provider -> ruleProvider.getValue(thisRef, property)
            }
        }
    }
}
