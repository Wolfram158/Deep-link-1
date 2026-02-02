package ru.wolfram.deep_link_app

import kotlinx.serialization.Serializable

object Routes {
    const val URL = "http://10.0.2.2:8080/api/v1"

    interface Companion {
        val id: Int
        val label: String
    }

    @Serializable
    data class Task1(
        val p: String = "",
        val q: String = "",
        val n: String = ""
    ) {
        companion object : Routes.Companion {
            override val id = 0
            override val label = "Task 1"
        }
    }

    @Serializable
    data class Task2(
        val a: String = "",
        val b: String = "",
        val m: String = ""
    ) {
        companion object : Routes.Companion {
            override val id = 1
            override val label = "Task 2"
        }
    }
}