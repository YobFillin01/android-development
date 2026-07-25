package com.example.androidbasictoadvanced.feature.spacer



data class Transaction(
    val id: String,
    val referenceNumber: String,
    val senderName: String,
    val receiverName: String,
    val senderAccount: String,
    val receiverAccount: String,
    val amount: Double,
    val currency: String,
    val transactionType: String,
    val status: String,
    val paymentMethod: String,
    val description: String,
    val transactionDate: String,
    val createdAt: String,
    val updatedAt: String,
    val fee: Double,
    val tax: Double,
    val exchangeRate: Double,
    val location: String,
    val deviceId: String
)
