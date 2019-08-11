package com.example.simpleapp.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.databinding.ItemCommentBinding
import com.example.simpleapp.databinding.ItemCommentHeaderBinding

enum class ViewType(val i: Int) {
    HEADER(0), BODY(1)
}

class DetailAdapter<T>(private val viewModel: DetailViewModel)
    : ListAdapter<T, DetailAdapter.CommentViewHolder<T>>(DetailDiffCallback<T>()) {

    override fun onBindViewHolder(holder: CommentViewHolder<T>, position: Int) {
        holder.bind(viewModel, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder<T> {
        return when(viewType) {
            ViewType.HEADER.i -> CommentItemViewHolder.from(parent)
            ViewType.BODY.i -> CommentHeaderViewHolder.from(parent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)::class.java.
    }

    abstract class CommentViewHolder<K>(itemView : View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(viewModel: DetailViewModel, item: K)
    }

    class CommentItemViewHolder private constructor(val binding: ItemCommentBinding)
        : CommentViewHolder<Comment>(binding.root) {

        override fun bind(viewModel: DetailViewModel, item: Comment) {

            binding.viewmodel = viewModel
            binding.comment = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CommentViewHolder<Comment> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCommentBinding.inflate(layoutInflater, parent, false)

                return CommentItemViewHolder(binding)
            }
        }
    }

    class CommentHeaderViewHolder private constructor(val binding: ItemCommentHeaderBinding)
        : CommentViewHolder<Post>(binding.root) {

        override fun bind(viewModel: DetailViewModel, item: Post) {

            binding.viewmodel = viewModel
            binding.post = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CommentViewHolder<Post> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCommentHeaderBinding.inflate(layoutInflater, parent, false)

                return CommentHeaderViewHolder(binding)
            }
        }
    }

}

class DetailDiffCallback<T> : DiffUtil.ItemCallback<T>() {
//    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
////        return oldItem.id == newItem.id
////    }
////
////    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
////        return oldItem == newItem
////    }
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChangePayload(oldItem: T, newItem: T): Any? {
        return super.getChangePayload(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
