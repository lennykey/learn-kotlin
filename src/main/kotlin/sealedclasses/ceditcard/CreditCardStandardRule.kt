package sealedclasses.ceditcard

import sealedclasses.RuleProvider.Rule

class CreditCardStandardRule : Rule<String>() {
    override fun execute(): String {
        return "12345"
    }
}
