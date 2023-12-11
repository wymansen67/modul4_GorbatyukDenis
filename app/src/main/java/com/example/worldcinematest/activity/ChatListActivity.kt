package com.example.worldcinematest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldcinematest.databinding.ActivityChatListBinding

class ChatListActivity : AppCompatActivity() {

    private lateinit var chatList: ActivityChatListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatList = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(chatList.root)

        chatList.buttonBack.setOnClickListener {
            finish()
        }
    }
}