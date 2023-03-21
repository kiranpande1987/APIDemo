package com.kprights.apidemo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}