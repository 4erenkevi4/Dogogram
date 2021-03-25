package com.example.dogogram3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(
    private val photo: MutableList<Int>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    private val userTypeRow = 0
    private val followTypeRow = 1
    private val buttonTypeRow = 2
    private val photoTypeRow = 3

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return userTypeRow
        if (position == 1) return followTypeRow
        if (position == 2) return buttonTypeRow
        return if (position == 3) photoTypeRow
        else photoTypeRow
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProfileViewHolder {
        when (viewType) {
            0 -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.row_type_user, viewGroup, false)
                return ProfileViewHolder(view, onClick)
            }
            1 -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.row_type_follow, viewGroup, false)
                return ProfileViewHolder(view, onClick)
            }
            2 -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.row_type_button, viewGroup, false)
                return ProfileViewHolder(view, onClick)
            }
            else -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_photo, viewGroup, false)
                return ProfileViewHolder(view, onClick)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ProfileViewHolder, position: Int) {
        if (position == 3) {
            viewHolder.perlacePhotoOne(photo[position])
        }
        if (position == 4) {
            viewHolder.perlacePhotoOne(photo[position])
        }
        if (position == 5) {
            viewHolder.perlacePhotoOne(photo[position])
        }
        if (position == 6) {
            viewHolder.perlacePhotoOne(photo[position])
        }
        if (position == 7) {
            viewHolder.perlacePhotoOne(photo[position])
        }
        if (position == 8) {
            viewHolder.perlacePhotoOne(photo[position])
        }
        if (position == 9) {
            viewHolder.perlacePhotoOne(photo[position])
        }
    }

    override fun getItemCount() = 11
    class ProfileViewHolder(
        view: View,
        private val onClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val photoOne: ImageView? = view.findViewById(R.id.photo_left)
        private val photoTwo: ImageView? = view.findViewById(R.id.photo_center)
        private val photoThree: ImageView? = view.findViewById(R.id.photo_right)

        fun perlacePhotoOne(photo: Int) {
            photoOne?.setImageResource(photo)
            photoOne?.setOnClickListener {
                onClick(photo)
            }
            photoTwo?.setImageResource(photo + 1)
            photoTwo?.setOnClickListener {
                onClick(photo + 1)
            }
            photoThree?.setImageResource(photo - 1)
            photoThree?.setOnClickListener {
                onClick(photo - 1)
            }
        }
    }
}
