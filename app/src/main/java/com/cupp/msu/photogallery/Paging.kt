package com.cupp.msu.photogallery

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cupp.msu.photogallery.api.GalleryItem

class Paging
private val repository: PhotoRepository
) : PagingSource<Int, GalleryItem>() {
    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, GalleryItem> {

    }


