package com.puzzlebench.clean_marvel_kotlin.data.local.model

import io.realm.RealmObject

open class RThumbnail(
        var path: String = "",
        var extension: String = ""
): RealmObject()
