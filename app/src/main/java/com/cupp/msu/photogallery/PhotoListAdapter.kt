package com.cupp.msu.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cupp.msu.photogallery.api.GalleryItem
import com.cupp.msu.photogallery.databinding.ListItemGalleryBinding


class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem) {
        binding.itemImageView.load(galleryItem.url) {
        }
    }
}

class PhotoListAdapter : PagingDataAdapter<GalleryItem,
        PhotoListAdapter.PhotoViewHolder>(DIFF_CALLBACK) {
    companion object
    {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GalleryItem>() {
            override fun areItemsTheSame(
                oldItem: GalleryItem, newItem: GalleryItem): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(
                oldItem: GalleryItem, newItem: GalleryItem): Boolean = oldItem == newItem
    }

        override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            getItem(position)?.let { holder.bind(it) }
    }

    override fun getItemCount() = galleryItems.size
}
