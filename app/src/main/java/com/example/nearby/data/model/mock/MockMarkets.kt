package com.example.nearby.data.model.mock

import com.example.nearby.data.model.Market

val mockMarkets = listOf(
    Market(
        id = "1",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes da carne",
        coupons = 3,
//        rules = listOf(
//            Rule(
//                id = "ABC",
//                description = "Válido até o dia 25/12/2024",
//                marketId = "1"
//            ),
//            Rule(
//                id = "ABCD",
//                description = "Disponível apenas para consumo local",
//                marketId = "1"
//            ),
//        ),
        latitude = 0.0,
        longitude = 0.0,
        address = "Avenida Paulista, 2000",
        phone = "(11) 91234-5678",
        cover = "https://res.cloudinary.com/carona/image/upload/v1729808990/arrllgea2l9kg7qpma8q.jpg",
    ),
    Market(
        id = "2",
        name = "Café Central",
        description = "Café aconchegante com opções de lanches e bebidas artesanais.",
        coupons = 0,
        latitude = 0.0,
        longitude = 0.0,
        address = "Avenida Paulista, 2000",
        phone = "(11) 91234-5678",
        cover = "https://res.cloudinary.com/carona/image/upload/v1729808990/arrllgea2l9kg7qpma8q.jpg",
    )

)