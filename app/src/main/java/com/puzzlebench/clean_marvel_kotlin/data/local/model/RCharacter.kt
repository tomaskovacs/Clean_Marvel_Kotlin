package com.puzzlebench.clean_marvel_kotlin.data.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

private const val EMPTY_STRING = ""
private const val ID_DEFAULT_VALUE = 0

open class RCharacter(
        @PrimaryKey
        var id: Int = ID_DEFAULT_VALUE,
        var name: String = EMPTY_STRING,
        var description: String = EMPTY_STRING,
        var rThumbnail: RThumbnail = RThumbnail()
): RealmObject()
