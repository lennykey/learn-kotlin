package sealedclasses.ceditcard

import sealedclasses.RuleProvider

class CreditCardVisaRule : RuleProvider.Rule<String>() {
    override fun execute(): String {
        return "Visa-12345"
    }
}
