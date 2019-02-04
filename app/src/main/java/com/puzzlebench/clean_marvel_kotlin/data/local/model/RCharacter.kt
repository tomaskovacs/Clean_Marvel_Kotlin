package com.puzzlebench.clean_marvel_kotlin.data.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCharacter(
        @PrimaryKey
        var id: Int = 0,
        var name: String = "",
        var description: String = "",
        var rThumbnail: RThumbnail? = null
): RealmObject()
