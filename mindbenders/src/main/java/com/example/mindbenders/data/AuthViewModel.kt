package com.example.mindbenders.data

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.mindbenders.models.User
import com.example.mindbenders.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthViewModel (var navController: NavController,  var context: Context) {
    var mAuth: FirebaseAuth

    init {
        mAuth = FirebaseAuth.getInstance()
    }

    @SuppressLint("SuspiciousIndentation")
    fun signup(
        firstName: String,
        secondName: String,
        emailAddress: String,
        password: String
    ) {
        if (firstName.isBlank() || secondName.isBlank() ||
            emailAddress.isBlank() || password.isBlank()
        ) {
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener { it ->
                    if (it.isSuccessful) {
                        val userData =
                            User(
                                firstName,
                                secondName,
                                emailAddress,
                                password,
                                mAuth.currentUser!!.uid
                            )
                        val regRef = FirebaseDatabase
                            .getInstance()
                            .getReference()
                            .child("Users/" + mAuth.currentUser!!.uid)
                        regRef.setValue(userData).addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(
                                    context,
                                    "Successfully Registered",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    context,
                                    "${it.exception!!.message}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    } else {
                        navController.navigate(ROUTE_REGISTER)
                    }
                }
        }
    }

    fun login(
        emailAddress: String,
        password: String
    ) {
        mAuth.signInWithEmailAndPassword(emailAddress, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context,"Successfully logged in",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }
    }
}