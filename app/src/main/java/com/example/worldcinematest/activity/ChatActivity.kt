package com.example.worldcinematest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldcinematest.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var chat: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chat = ActivityChatBinding.inflate(layoutInflater)
        setContentView(chat.root)

        var intent = intent.extras
        if (intent != null) {
            chat.ChatTitle.text = intent.getString("chatname", "")
        }

        chat.Back.setOnClickListener {
            finish()
        }
    }
}