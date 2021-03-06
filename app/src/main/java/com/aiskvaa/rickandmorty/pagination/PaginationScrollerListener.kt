package com.aiskvaa.rickandmorty.pagination

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollerListener(
    var layoutManager: LinearLayoutManager,
    private val doRequest: () -> Unit
) : RecyclerView.OnScrollListener() {
    abstract fun isLoading(): Boolean

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition()

        if (!isLoading()) {
            if ((visibleItemCount + firstVisibleItemItemPosition) >= totalItemCount && firstVisibleItemItemPosition >= 0) {
                doRequest()
            }
        }
    }
}