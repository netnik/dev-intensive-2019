package ru.skillbranch.devintensive

import android.os.Build
import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.models.User.Factory.makeUser
import ru.skillbranch.devintensive.utils.Utils.parseFullName
import ru.skillbranch.devintensive.utils.Utils.toInitials
import ru.skillbranch.devintensive.utils.Utils.transliteration
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "Alberto", "Lucchiano" )
        val user3 = User("3", "Franchesko", "Gotti", null, lastVisit= Date(), isOnline = true)

        //user.printMe()
        //user2.printMe()
        //user3.printMe()


        println("$user")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("Danilo Zio")
    //    val user2 = User.makeUser("Danilo Savino")
    //    val user3 = User.makeUser("Danilo Motegano")
        val user2 = user.copy(id="2", lastName = "Vitto", lastVisit = Date())
        print("$user, \n$user2")


    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("Andrea Gusto")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName. $lastName")  // 0, Andrea. Gusto
        println("${user.component1()}, ${user.component2()}. ${user.component3()}")  //0, Andrea. Gusto

    }

    @Test
    fun test_copy() {

        val user = User.makeUser("Sanino Carleone")
        val user2 = user.copy(id = "2", lastVisit = Date())
        val user3 = user.copy(id = "2", lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user.copy(lastName = "Terzi", lastVisit = Date().add(2, TimeUnits.HOUR))

        if (user == user2) {
            println("equals data and hash: \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        } else {
            println("NOT equals data and hash: \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }



        if (user === user2) {
            println("equals adress: \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        } else {
            println("equals adress: \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        }

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_dataq_maping() {
        val user = User.makeUser("Ник Нонсо")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(user)
        println(newUser)
        val userView = user.toUserView()
        val newUserView = newUser.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Vittorio Clastino")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type="text", date = Date() )
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type="image", date = Date() )
/*
        when(txtMessage) {
            is BaseMessage -> println("Questo Base message")
            is TextMessage -> println("Questo text message")
            is ImageMessage -> println("Questo image message")
        }
*/
        println(txtMessage.formatMessage())  // id:0 Vittorio  отправил Message "any text message"
        println(imgMessage.formatMessage())  // id:1 Vittorio  отправил Images "any image url"
    }

    @Test
    fun test_parse_fullname() {
        val user =  User.makeUser("Василий Теркин")
        val user2 =  User.makeUser("")
        val user3 =  User.makeUser(" ")
        val user4 =  User.makeUser("Сергей")
        val user5 =  User.makeUser(null)

        println(parseFullName("$user"))
        println(parseFullName("$user2"))
        println(parseFullName("$user3"))
        println(parseFullName("$user4"))
        println(parseFullName("$user5"))

    }

    @Test
    fun test_transliteration() {
        println(transliteration("Женя Стереотипов"))
        println(transliteration("Amazing Петр", "_"))



    }

    @Test
    fun test_toInitials() {
        println(toInitials("Артем", "Вольнов")) //АВ
        println(toInitials("john" ,"doe")) //JD
        println(toInitials("John", null)) //J
        println(toInitials(null , null)) //null
        println(toInitials(" " , ""))   //null

    }

    @Test
    fun test_formatdate() {
        var time = Date()
        println("$time")   //Sun Jul 07 23:47:14 MSK 2019
        println("${time.format()}") //23:47:14 07.07.19
        println("${time.format("HH:mm")}") //23:48
    }

    @Test
    fun test_date_extension() {
        //var time = Date()
        println(Date().add(2, TimeUnits.SECOND)) //Sun Jul 07 23:53:14 MSK 2019
        println(Date().add(-4, TimeUnits.DAY)) // Wed Jul 03 23:54:22 MSK 2019
    }





}




