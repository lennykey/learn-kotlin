package sealedclasses.paymentorigin

import sealedclasses.RuleProvider

class PaymentOriginNumberStandardRule : RuleProvider.Rule<String>() {

    override fun execute(): String {
        return "standardOrigin"
    }
}
