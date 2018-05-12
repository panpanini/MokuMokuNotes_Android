package jp.co.panpanini.mokumokunotes

import java.io.Serializable
import java.util.*

data class Note(
        val text: String,
        val createdAt: Date,
        val completed: Boolean = false,
        val completedAt: Date? = null
): Serializable