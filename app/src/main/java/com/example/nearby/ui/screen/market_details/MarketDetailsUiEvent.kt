package com.example.nearby.ui.screen.market_details

sealed class MarketDetailsUiEvent {
    data class OnGetRules(val marketId: String) : MarketDetailsUiEvent()
    data class OnGetCoupon(val qrCodeContent: String) : MarketDetailsUiEvent()
    data object OnResetCoupon : MarketDetailsUiEvent()
}