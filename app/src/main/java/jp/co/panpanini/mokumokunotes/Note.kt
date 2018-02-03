package jp.co.panpanini.mokumokunotes

import java.util.*

data class Note(
        val text: String,
        val createdAt: Date,
        val completed: Boolean = false,
        val completedAt: Date? = null
)