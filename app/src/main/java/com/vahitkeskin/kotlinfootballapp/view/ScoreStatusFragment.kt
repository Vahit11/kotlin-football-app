package com.vahitkeskin.kotlinfootballapp.view

import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vahitkeskin.kotlinfootballapp.R
import com.vahitkeskin.kotlinfootballapp.adapter.ScoreStatusAdapter
import com.vahitkeskin.kotlinfootballapp.databinding.FragmentScoreStatusBinding
import com.vahitkeskin.kotlinfootballapp.viewmodel.TeamsViewModel
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class ScoreStatusFragment : Fragment() {

    private lateinit var binding: FragmentScoreStatusBinding
    private lateinit var viewModel: TeamsViewModel
    private lateinit var scoreStatusAdapter: ScoreStatusAdapter

    private val leftSwipeCallBack =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val action =
                    ScoreStatusFragmentDirections.actionScoreStatusFragmentToNextWeekFragment(viewHolder.adapterPosition+1)
                Navigation.findNavController(viewHolder.itemView).navigate(action)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(context!!,R.color.swipe_bg))
                    .addActionIcon(R.drawable.ic_next_white)
                    .create()
                    .decorate()

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }

    private val rightSwipeCallBack =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val action =
                    ScoreStatusFragmentDirections.actionScoreStatusFragmentToLastWeekFragment(viewHolder.adapterPosition+1)
                Navigation.findNavController(viewHolder.itemView).navigate(action)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(context!!,R.color.swipe_bg))
                    .addActionIcon(R.drawable.ic_last_white)
                    .create()
                    .decorate()

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScoreStatusBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            val action = ScoreStatusFragmentDirections.actionScoreStatusFragmentToSystemSettingsFragment()
            Navigation.findNavController(it).navigate(action)
        }

        viewModel = ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        viewModel.getDataScoreStatusAPI()

        context?.let {
            scoreStatusAdapter = ScoreStatusAdapter(arrayListOf(),it)
        }

        binding.rvScoreStatus.layoutManager = LinearLayoutManager(context)
        binding.rvScoreStatus.adapter = scoreStatusAdapter
        ItemTouchHelper(leftSwipeCallBack).attachToRecyclerView(binding.rvScoreStatus)
        ItemTouchHelper(rightSwipeCallBack).attachToRecyclerView(binding.rvScoreStatus)

        observerLiveData()
    }

    private fun observerLiveData() {
        viewModel.teams.observe(viewLifecycleOwner, { teamList ->
            teamList?.let {
                scoreStatusAdapter.uploadScoreList(it)
            }
        })
    }
}