package com.example.core3

data class Medallist(var name:String = "",
                     var ioc:String = "",
                     var times:Int = 0,
                     var gold:Int = 0,
                     var silver:Int = 0,
                     var bronze:Int =0
){
    fun totalmed():Int{
        return this.gold+this.silver+this.bronze
    }
}
