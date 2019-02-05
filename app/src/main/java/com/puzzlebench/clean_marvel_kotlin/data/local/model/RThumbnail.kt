package com.puzzlebench.clean_marvel_kotlin.data.local.model

import io.realm.RealmObject

private const val EMPTY_STRING = ""

open class RThumbnail(
        var path: String = EMPTY_STRING,
        var extension: String = EMPTY_STRING
): RealmObject()
