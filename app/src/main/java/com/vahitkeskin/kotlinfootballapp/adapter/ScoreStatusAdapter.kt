package com.vahitkeskin.kotlinfootballapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.vahitkeskin.kotlinfootballapp.R
import com.vahitkeskin.kotlinfootballapp.databinding.ScoreStatusItemBinding
import com.vahitkeskin.kotlinfootballapp.model.Model
import com.vahitkeskin.kotlinfootballapp.view.ScoreStatusFragmentDirections
import kotlinx.android.synthetic.main.score_status_item.view.*

class ScoreStatusAdapter(
    private val scoreList: ArrayList<Model>,
    private val context: Context
) :
    RecyclerView.Adapter<ScoreStatusAdapter.ScoreStatusViewHolder>(), ScoreStatusClickListener {

    class ScoreStatusViewHolder(val view: ScoreStatusItemBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreStatusViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ScoreStatusItemBinding>(
            inflater,
            R.layout.score_status_item,
            parent,
            false
        )
        return ScoreStatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreStatusViewHolder, position: Int) {
        holder.view.laliga = scoreList[position]
        holder.view.listener = this

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.team_item_on
                )
            )
        } else {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.team_item_two
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return scoreList.size
    }

    fun uploadScoreList(newScoreList: List<Model>) {
        scoreList.clear()
        scoreList.addAll(newScoreList)
        notifyDataSetChanged()
    }

    override fun onScoreStatusClicked(view: View) {
        val uuid = view.teamArgumentId.text.toString().toInt()
        val action = ScoreStatusFragmentDirections.actionScoreStatusFragmentToTeamFragment(uuid)
        Navigation.findNavController(view).navigate(action)
    }

}