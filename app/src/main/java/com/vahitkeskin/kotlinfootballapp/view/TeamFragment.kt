package com.vahitkeskin.kotlinfootballapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.vahitkeskin.kotlinfootballapp.databinding.FragmentTeamBinding
import com.vahitkeskin.kotlinfootballapp.viewmodel.TeamsViewModel

class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamBinding
    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        viewModel.getDataScoreStatusAPI()

        arguments?.let {
            val selectTeamRanking = TeamFragmentArgs.fromBundle(it).teamArgument
            observeLiveData(selectTeamRanking)
        }
    }

    private fun observeLiveData(selectedTeamId: Int) {
        viewModel.teams.observe(viewLifecycleOwner, { teamList ->
            teamList?.let {
                for (team in it) {
                    if (team.ranking == selectedTeamId) {
                        binding.selectedTeam = team
                    }
                }
            }
        })
    }
}