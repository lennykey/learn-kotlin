package sealedclasses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import sealedclasses.ceditcard.CreditCardNumberProvider
import sealedclasses.paymentorigin.PaymentOriginNumberProvider

internal class SealedClassesTest {

    @Nested
    inner class CreditCardTest {

        @Test
        fun `standard CreditCard`() {
            val creditCardNumber: String by CreditCardNumberProvider(company = "standard")

            assertEquals("12345", creditCardNumber)
        }

        @Test
        fun `standard VisaCard`() {
            val creditCardNumber: String by CreditCardNumberProvider(company = "Visa")

            assertEquals("Visa-12345", creditCardNumber)
        }

        @Test
        fun `standard MasterCard`() {
            val creditCardNumber: String by CreditCardNumberProvider(company = "MasterCard")

            assertEquals("MasterCard-12345", creditCardNumber)
        }
    }

    @Nested
    inner class PaymentOriginTest {

        @Test
        fun `paymentOrigin standard`() {
            val paymentOrigin: String by PaymentOriginNumberProvider(origin = "standard")

            assertEquals("standardOrigin", paymentOrigin)
        }

        @Test
        fun `paymentOrigin USA`() {
            val paymentOrigin: String by PaymentOriginNumberProvider(origin = "USA")

            assertEquals("Payment from USA", paymentOrigin)
        }

        @Test
        fun `paymentOrigin CreditCard standard`() {
            val paymentOrigin: String by PaymentOriginNumberProvider(origin = "creditCard", creditCardProvider = "standard")

            assertEquals("12345", paymentOrigin)
        }

        @Test
        fun `paymentOrigin CreditCard Visa`() {
            val paymentOrigin: String by PaymentOriginNumberProvider(origin = "creditCard", creditCardProvider = "Visa")

            assertEquals("Visa-12345", paymentOrigin)
        }

        @Test
        fun `paymentOrigin CreditCard MasterCard`() {
            val paymentOrigin: String by PaymentOriginNumberProvider(origin = "creditCard", creditCardProvider = "Visa")

            assertEquals("Visa-12345", paymentOrigin)
        }
    }
}
