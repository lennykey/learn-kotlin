package sealedclasses.paymentorigin

import sealedclasses.RuleProvider.Rule

class PaymentOriginNumberUsaRule : Rule<String>() {

    override fun execute(): String {
        return "Payment from USA"
    }
}
