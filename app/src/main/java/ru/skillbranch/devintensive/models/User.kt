package ru.skillbranch.devintensive.models


import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var raiting: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false

) {

    //var introBit: String,

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id,"Marko", "Polo")

    init {
        println("It's best travel men!!!! \n" +
                "${if(lastName==="Polo") "His name id $firstName $lastName" else "And his name is $firstName $lastName!!!"}\n" )
    }

    companion object Factory {
        private var lastId : Int = -1
        fun makeUser(fullName: String?) : User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)

        }

    }

    class Builder {
        private var id: String = ""
        private var firstName: String? = null
        private var lastName: String? = null
        private var avatar: String? = null
        private var raiting: Int = 0
        private var respect: Int = 0
        private var lastVisit: Date? = Date()
        private var isOnline: Boolean = false

        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String?) = apply { this.firstName = firstName }
        fun lastName(lastName: String?) = apply { this.lastName = lastName }
        fun avatar (avatar: String?) = apply { this.avatar= avatar }
        fun raiting(raiting: Int) = apply { this.raiting = raiting }
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisit(lastVisit: Date?) = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }
        fun build() = User(id, firstName, lastName, avatar, raiting, respect, lastVisit, isOnline)
    }


}

