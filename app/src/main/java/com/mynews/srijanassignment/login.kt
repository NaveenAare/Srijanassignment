package com.mynews.srijanassignment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.regex.Matcher
import java.util.regex.Pattern


class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.e1)
        val password = findViewById<EditText>(R.id.ed2)
        val login = findViewById<Button>(R.id.button_login)
        val error = findViewById<TextView>(R.id.error)
        error.isVisible=false
        login.isEnabled=false
        var usernameb= false
        var passwordb= false
        var alpha=false
        var number=false
        var cap=false
        var special=false


        username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.length != 0){
                    for (c in s)
                    {
                        if (c !in 'A'..'Z' && c !in 'a'..'z'&&c !in '0'..'9') {
                            usernameb=false
                            error.isVisible=true
                            error.setText("Error!Enter Proper Username")
                        }
                        else{
                            error.isVisible=false
                            usernameb=true
                        }
                    }

                }
                if(s.length==0){

                    usernameb=false
                }
                if(usernameb==true&&passwordb==true){
                    login.isEnabled=true
                }
                if(usernameb!=true||passwordb!=true){
                    login.isEnabled=false
                }
            }
        })
        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.length != 0){
                    if(s.length<5){
                        passwordb=false
                        error.isVisible=true
                        error.setText("Error!Password Not Meeting Criteria")
                    }
                    else{
                        for (c in s)
                        {
                            if (c in 'A'..'Z' ) {
                                cap=true
                                break
                            }
                            else{
                                cap=false
                            }
                        }
                        for (c in s)
                        {
                            if (c in 'a'..'z') {
                                alpha=true
                                break
                            }
                            else{
                                alpha=false
                            }
                        }
                        for (c in s)
                        {
                            if (c in '0'..'9') {
                                number=true
                                break
                            }
                            else{
                                number=false
                            }
                        }
                        val pattern: Pattern = Pattern.compile("[^a-zA-Z0-9]")
                        val matcher: Matcher = pattern.matcher(s)
                        val isStringContainsSpecialCharacter: Boolean = matcher.find()
                        if (isStringContainsSpecialCharacter){
                            special=true

                        }else
                        {
                            special=false
                        }




                        if(alpha==true&&cap==true&&number==true&&special==true){
                            passwordb=true
                            error.isVisible=false
                        }else{
                            passwordb=false
                            error.isVisible=true
                            error.setText("Error!Password not meeting the criteria")
                        }


                    }


                }
                if(s.length==0){
                    passwordb=false
                }
                if(usernameb==true&&passwordb==true){
                    login.isEnabled=true
                }
                if(usernameb!=true||passwordb!=true){
                    login.isEnabled=false
                }
            }
        })


        login.setOnClickListener{



            var us=username.text.toString()
            val intent = Intent(baseContext, MainActivity::class.java)
            Toast.makeText(this, us, Toast.LENGTH_SHORT).show()
            intent.putExtra("us", us);
            startActivity(intent)

        }
    }
}