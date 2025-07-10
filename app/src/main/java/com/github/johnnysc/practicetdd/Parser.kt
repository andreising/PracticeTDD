package com.github.johnnysc.practicetdd

interface Parser {

    fun parse(raw: String): List<Any>

    class Base(private val delimiter: String) : Parser {
        init {
            if (delimiter.isEmpty()) throw IllegalStateException()
        }

        override fun parse(raw: String): List<Any> {
            if (raw.isBlank()) return emptyList()
            return raw.split(delimiter).filter { it.isNotEmpty() }.map { value ->
                when {
                    value == "true" -> true
                    value == "false" -> false
                    value.toByteOrNull() != null -> value.toByte()
                    value.toShortOrNull() != null -> value.toShort()
                    value.toIntOrNull() != null -> value.toInt()
                    value.toLongOrNull() != null -> value.toLong()
                    value.toFloatOrNull() != null && value.toFloat()!= Float.POSITIVE_INFINITY -> value.toFloat()
                    value.toDoubleOrNull() != null -> value.toDouble()
                    value.length == 1 -> value.toCharArray()[0]
                    else -> value
                }
            }
        }
    }
}
