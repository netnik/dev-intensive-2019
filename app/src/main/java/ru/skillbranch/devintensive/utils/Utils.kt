package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts= fullName?.trim()?.split(" ")

        val firstName = if (parts?.getOrNull(0).isNullOrBlank()) null else parts?.get(0)
        val lastName = if (parts?.getOrNull(1).isNullOrBlank()) null else parts?.get(1)
        //val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var result = ""
        val letters = getLetter()

        for (inChar in payload) {
            val outChar = letters[inChar.toLowerCase()] ?: inChar.toString()
            result += if (inChar.isUpperCase() && outChar.isNotEmpty()) outChar.capitalize() else outChar
        }

        return result.trim().replace(" ", divider)

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var result = ""
        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) return null
        if (!firstName.isNullOrBlank()) result += firstName.trim().first().toUpperCase().toString()

        if (!lastName.isNullOrBlank()) result += lastName.trim().first().toUpperCase().toString()
        return result


    }

    private fun getLetter() = hashMapOf(
        'а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d", 'е' to "e", 'ё' to "e",
        'ж' to "zh", 'з' to "z", 'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l", 'м' to "m",
        'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r", 'с' to "s", 'т' to "t", 'у' to "u",
        'ф' to "f", 'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh",
        'ъ' to "", 'ы' to "i", 'ь' to "", 'э' to "e", 'ю' to "yu", 'я' to "ya"
    )
}

