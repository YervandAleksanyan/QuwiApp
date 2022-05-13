package com.example.quwi.feature_chats.presentation

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.quwi.core.adapter.BaseAdapter
import com.example.quwi.core.adapter.BaseViewHolder
import com.example.quwi.feature_chats.data.entity.projectentity.ChannelEntity
import com.example.quwi.databinding.ItemChatBinding

class ChatsListAdapter : BaseAdapter<ChannelEntity>() {


    override val areItemsTheSameCallback: (ChannelEntity, ChannelEntity) -> Boolean =
        { oldValue, newValue -> oldValue == newValue }

    override val areContentsTheSameCallback: (ChannelEntity, ChannelEntity) -> Boolean =
        { oldValue, newValue -> oldValue.id == newValue.id }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ChannelEntity> =
        ChatViewHolder(ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    class ChatViewHolder(private val binding: ItemChatBinding) :
        BaseViewHolder<ChannelEntity>(binding.root) {
        override fun bind(item: ChannelEntity, position: Int) {
            binding.lastMessage.text = item.lastMessage.text
            if (item.pinToTop) {
                binding.pinIcon.visibility = View.VISIBLE
            }
            if (!item.isMessageUnread) {
                binding.seenMessageIcon.visibility = View.VISIBLE
                binding.seenMessageIcon2.visibility = View.VISIBLE
            }
            binding.messageTime.text = item.lastMessage.sendTime.split(" ")[1].split(".")[0]
            binding.chatName.text = item.lastMessage.user.name

            if (item.lastMessage.isRead.toInt() == 1) {
                binding.lastMessage.setTypeface(null, Typeface.BOLD)
            }
            if (item.lastMessage.user.imageUrl.isBlank()) {
                Glide.with(binding.root).load(DEFAULT_CHAT_IMAGE_URL).apply(
                    RequestOptions().override(110, 110)
                ).circleCrop()
                    .into(binding.chatImage)
            } else {
                Glide.with(binding.root).load(item.lastMessage.user.imageUrl).apply(
                    RequestOptions().override(110, 110)
                ).circleCrop()
                    .into(binding.chatImage)
            }

        }
    }

}