package com.example.mindbenders.data

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.example.mindbenders.models.Client
import com.example.mindbenders.navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class ClientViewModel (var navController: NavController,var context: Context){
     var authRepository: AuthViewModel

    init {
        authRepository=AuthViewModel(navController,context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_LOGIN)
        }

    }
    fun saveClient(
        filePath: Uri,firstName:String,lastName:String,gender:String,age:String,bio:String){
        var id = System.currentTimeMillis().toString()
        var storageReference = FirebaseStorage.getInstance().getReference().child("Passport/$id")
        storageReference.putFile(filePath).addOnCompleteListener{
            if(it.isSuccessful){
                storageReference.downloadUrl.addOnSuccessListener{
                    var imageUrl = it.toString()
                    var houseData = Client(imageUrl,firstName,lastName,gender,age,bio,id)
                    var dbRef = FirebaseDatabase.getInstance().getReference().child("Client/$id")
                    dbRef.setValue(houseData)
                    Toast.makeText(context,"Client Added Successfully",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }
    }

}