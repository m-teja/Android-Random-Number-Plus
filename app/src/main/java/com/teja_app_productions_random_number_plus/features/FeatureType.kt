package com.teja_app_productions_random_number_plus.features

import com.teja_app_productions_random_number_plus.features.coinflip.CoinFlipResult
import java.lang.reflect.Type

enum class FeatureType {
    COIN_FLIP {
        override val historyType: Type
            get() = CoinFlipResult::class.java
    },
    RANDOM_NUMBER {
        override val historyType: Type
            get() = TODO("Create a data class for the history item and provide its type here.")
    },
    RANDOM_COLOR {
        override val historyType: Type
            get() = TODO("Create a data class for the history item and provide its type here.")
    };

    abstract val historyType: Type
}

fun FeatureType.toHistoryKey(): String {
    return when (this) {
        FeatureType.COIN_FLIP -> "history_coin_flip"
        FeatureType.RANDOM_NUMBER -> "history_random_number"
        FeatureType.RANDOM_COLOR -> "history_random_color"
    }
}
