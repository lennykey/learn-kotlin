package sealedclasses.ceditcard

import sealedclasses.RuleProvider.Rule

class CreditCardMasterCardRule : Rule<String>() {
    override fun execute(): String {
        return "MasterCard-12345"
    }
}
