package de.syntax_institut.theveggieapp.helper

object StringHelper {
    /**
     *
     * @param input Ist der zu kürzende Text
     * @return Gibt den gekürzten Text zurück
     * @sample shortenText(input: String)
     *
     */
    fun shortenText(input: String): String {
        var text = input.take(20) + "..."
        return text
    }
}

// String Extension als Alternative zum obigen StringHelper Objekt
fun String.shortText(): String {
    return this.take(20) + "..."
}

