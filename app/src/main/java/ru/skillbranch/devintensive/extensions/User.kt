package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils



/**
 * Created by CheNeo on 01.07.2019.
 * Copyright (c) 2019 NetNik. All rights reserved.
 **/

fun User.toUserView(): UserView {

    val nickname = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще не был" else if (isOnline) "online" else "Последнее посещение  ${lastVisit}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickname,
        initials = initials,
        avatar = avatar,
        status = status
    )
}


