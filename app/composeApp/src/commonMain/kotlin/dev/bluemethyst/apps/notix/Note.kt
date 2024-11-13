package dev.bluemethyst.apps.notix

data class Note(
    val title: String,
    val content: String,
    val lastEdited: Long? = null
)