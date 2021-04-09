package com.example.chattingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.R
import com.example.chattingapp.dto.ChatMessage
import com.example.chattingapp.dto.User

class MessagelistAdapter(val userId : Int, val messageList: List<ChatMessage>) :  RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    companion object{
        val MY_CHATTING = 0
        val OTHER_CHATTING = 1
        val ENTER = 2
    }

    inner class OtherChatHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val messageView : TextView = itemView?.findViewById<TextView>(R.id.item_chat_customer_content)!!
        val timeView : TextView = itemView?.findViewById<TextView>(R.id.item_chat_customer_date)!!

        fun bind(chatMessage : ChatMessage){
            messageView.text = chatMessage.content
        }
    }

    inner class MyChatHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val messageView : TextView = itemView?.findViewById<TextView>(R.id.item_chat_customer_content)!!
        val timeView : TextView = itemView?.findViewById<TextView>(R.id.item_chat_customer_date)!!

        fun bind(chatMessage : ChatMessage){
            messageView.text = chatMessage.content
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == MY_CHATTING) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.widget_chat_customer, parent, false)
            return MyChatHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.widget_chat_company, parent, false)
        return OtherChatHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyChatHolder) {
            holder.bind(messageList[position])
        }else if(holder is OtherChatHolder){
            holder.bind(messageList[position])
        }
    }

    override fun getItemCount(): Int {
        return messageList.size;
    }

    override fun getItemViewType(position: Int): Int {
        if (userId == messageList[position].userId){
            return MY_CHATTING
        }
        return OTHER_CHATTING
    }
}