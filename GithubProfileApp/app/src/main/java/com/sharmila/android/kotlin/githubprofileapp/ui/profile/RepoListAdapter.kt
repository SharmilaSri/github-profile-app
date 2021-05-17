package com.sharmila.android.kotlin.githubprofileapp.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.sharmila.android.kotlin.githubprofileapp.R
import com.sharmila.android.kotlin.githubprofileapp.databinding.RepositoryItemBinding


class RepoListAdapter(val repos: MutableList<ProfileDetailsQuery.Repositories?>) :
    RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    class ViewHolder(val binding: RepositoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return repos[0]?.nodes?.size!!
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repos[0]
        holder.binding.txtViewName.text = repo?.nodes?.get(position)?.owner?.login ?: ""
        holder.binding.txtViewRepoName.text = repo?.nodes?.get(position)?.name ?: ""
        holder.binding.txtViewRepoDescription.text = repo?.nodes?.get(position)?.description ?: ""
        holder.binding.imageViewProfile.load(repo?.nodes?.get(position)?.owner?.avatarUrl.toString()) {
            crossfade(true)
            placeholder(R.drawable.circle_background)
            transformations(CircleCropTransformation())
        }
        holder.binding.txtViewStarCount.text = repo?.nodes?.get(position)?.stargazerCount.toString()
        holder.binding.txtViewLanguage.text = repo?.nodes?.get(position)?.primaryLanguage?.name ?: ""

    }
}