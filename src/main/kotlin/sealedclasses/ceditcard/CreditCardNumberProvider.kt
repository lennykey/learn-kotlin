package sealedclasses.ceditcard

import sealedclasses.RuleProvider
import kotlin.reflect.KProperty

class CreditCardNumberProvider(private val company: String = "standard") : RuleProvider.Provider<String>() {

    override var ruleProvider: RuleProvider<String> = CreditCardStandardRule()

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        if (company == "Visa") {
            ruleProvider = CreditCardVisaRule()
        } else if (company == "MasterCard") {
            ruleProvider = CreditCardMasterCardRule()
        }

        return evaluate(ruleProvider, thisRef, property)
    }
}
