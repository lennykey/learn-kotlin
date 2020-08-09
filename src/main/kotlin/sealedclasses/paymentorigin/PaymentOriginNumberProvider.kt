package sealedclasses.paymentorigin

import sealedclasses.RuleProvider
import sealedclasses.ceditcard.CreditCardNumberProvider
import kotlin.reflect.KProperty

class PaymentOriginNumberProvider(private val origin: String = "standard", private val creditCardProvider: String? = null) : RuleProvider.Provider<String>() {

    override var ruleProvider: RuleProvider<String> = CreditCardNumberProvider()

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        ruleProvider = when (origin) {
            "creditCard" -> {
                CreditCardNumberProvider(checkNotNull(creditCardProvider))
            }
            "USA" -> {
                PaymentOriginNumberUsaRule()
            }
            else -> {
                PaymentOriginNumberStandardRule()
            }
        }

        return evaluate(ruleProvider, thisRef, property)
    }
}
