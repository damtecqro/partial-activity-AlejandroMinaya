package com.itesm.pokedex.utils

fun prettifyPokemonNumber(number : Int, zeroBased : Boolean = false) : String{
    var offset = 0
    if(zeroBased) { offset = 1 }
    var prettyNumber = "#"

    if(number < 9) {
        prettyNumber += "00"
    } else if (number < 99){
        prettyNumber += "0"
    }
    prettyNumber += (number + offset)
    return prettyNumber
}

fun toTitleCase(s : String) : String{
    val sentence = s as CharSequence
    var result = ""
    var isFollowedBySpace = true
    for(i in 0 until sentence.length){
        var new_c = sentence[i]
        if(sentence[i] == ' ')
            isFollowedBySpace = true
        else
            if(isFollowedBySpace){
                new_c = sentence[i].toUpperCase()
                isFollowedBySpace = false
            }
        result += new_c
    }
    return result

}

fun snakeToSpace(s : String) : String{
    val sentence = s as CharSequence
    var result = ""
    for(i in 0 until sentence.length){
        var new_c = sentence[i]
        if(new_c == '-')
            new_c = ' '
        result += new_c
    }
    return result
}
