package com.example.mindbenders.models

class User {
    var firstName: String = ""
    var lastName: String = ""
    var emailAddress: String = ""
    var password: String = ""
    var userid: String = ""
    constructor(firstName: String,
                lastName: String,
                emailAddress: String,
                password: String,
                userid: String){
        this.firstName=firstName
        this.lastName=lastName
        this.emailAddress=emailAddress
        this.password=password
        this.userid=userid
    }
    constructor()

}