package com.example.mindbenders.models

class Client {
    var imageUrl:String=""
    var firstName:String=""
    var lastName:String=""
    var gender:String=""
    var age:String=""
    var bio:String=""
    var id:String=""

    constructor(
         imageUrl:String,
         firstName:String,
         lastName:String,
         gender:String,
         age:String,
         bio:String,
         id:String,
    ){
        this.imageUrl=imageUrl
        this.firstName=firstName
        this.lastName=lastName
        this.gender=gender
        this.age=age
        this.bio=bio
        this.id=id
    }
    constructor()
}