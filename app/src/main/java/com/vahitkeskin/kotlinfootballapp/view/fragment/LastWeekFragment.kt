package com.vahitkeskin.kotlinfootballapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.vahitkeskin.kotlinfootballapp.databinding.FragmentLastWeekBinding
import com.vahitkeskin.kotlinfootballapp.viewmodel.TeamsViewModel

class LastWeekFragment : Fragment() {

    private lateinit var binding: FragmentLastWeekBinding
    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLastWeekBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        viewModel.getDataScoreStatusAPI()

        arguments?.let {
            val selectTeamRanking = LastWeekFragmentArgs.fromBundle(it).lastArgument
            observeLiveData(selectTeamRanking)
        }
    }

    private fun observeLiveData(selectedLastWeek: Int) {
        viewModel.teams.observe(viewLifecycleOwner, { teamList ->
            teamList?.let { list ->
                for (last1 in list) {
                    if (last1.ranking == selectedLastWeek) {
                        for (last2 in list) {
                            if (last2.ranking == last1.last_week_opponent?.ranking!!) {
                                binding.lastWeekTeam1 = last1
                                binding.lastWeekTeam2 = last2
                            }
                        }
                    }
                }
            }
        })
    }
}