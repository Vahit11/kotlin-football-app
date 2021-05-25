package com.vahitkeskin.kotlinfootballapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.vahitkeskin.kotlinfootballapp.databinding.FragmentNextWeekBinding
import com.vahitkeskin.kotlinfootballapp.viewmodel.TeamsViewModel

class NextWeekFragment : Fragment() {

    private lateinit var binding: FragmentNextWeekBinding
    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNextWeekBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        viewModel.getDataScoreStatusAPI()

        arguments?.let {
            val selectTeamRanking = NextWeekFragmentArgs.fromBundle(it).nextArgument
            observeLiveData(selectTeamRanking)
        }
    }

    private fun observeLiveData(selectedNextWeek: Int) {
        viewModel.teams.observe(viewLifecycleOwner, { teamList ->
            teamList?.let { list ->
                for (next1 in list) {
                    if (next1.ranking == selectedNextWeek) {
                        for (next2 in list) {
                            if (next2.ranking == next1.next_week_opponent?.ranking!!) {
                                binding.nextWeekTeam1 = next1
                                binding.nextWeekTeam2 = next2
                            }
                        }
                    }
                }
            }
        })
    }
}