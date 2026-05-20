package com.santimattius.cmp.playground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform