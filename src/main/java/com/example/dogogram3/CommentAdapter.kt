package com.example.dogogram3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private val dataSet: MutableList<String>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup, viewType: Int
    ): CommentAdapter.CommentViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_type_comment, viewGroup, false)
        return CommentAdapter.CommentViewHolder(view)
    }

    override fun getItemCount(): Int = 7

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        if (position == 1) {
            holder.avatarComment
            holder.makeComment("Норм")
            holder.perlacePhotoOne()
        }
        if (position == 2) {
            holder.avatarComment
            holder.makeComment("Крутое фото)")
            holder.perlacePhotoTwo()
        }
        if (position == 3) {
            holder.avatarComment
            holder.makeComment("Ах ты хитрая морда")
        }
        if (position == 4) {
            holder.avatarComment
            holder.makeComment("Когда на охоту?")
            holder.perlacePhotoOne()
        }
    }

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatarComment: ImageView? = view.findViewById(R.id.comment_avatars)
        private val textComment: TextView? = view.findViewById(R.id.text_comment)

        fun makeComment(comment: String) {
            textComment!!.text = comment
        }

        fun perlacePhotoOne() {
            avatarComment?.setImageResource(R.drawable.avatar2)
        }

        fun perlacePhotoTwo() {
            avatarComment?.setImageResource(R.drawable.avatar3)
        }
    }
}
