package com.example.nearby.ui.screen.home

sealed class HomeUiEvent {
    data object OnGetCategories: HomeUiEvent()
    data class OnGetMarkets(val categoryId: String) : HomeUiEvent()
}