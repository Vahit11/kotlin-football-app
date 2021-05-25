package com.vahitkeskin.kotlinfootballapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.vahitkeskin.kotlinfootballapp.R
import com.vahitkeskin.kotlinfootballapp.databinding.FragmentSystemSettingsBinding
import com.vahitkeskin.kotlinfootballapp.util.CustomSharedPreferences

class SystemSettingsFragment : Fragment() {

    private lateinit var binding: FragmentSystemSettingsBinding
    private var customSharedPreferences = CustomSharedPreferences()
    private var updateThemeMode: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSystemSettingsBinding.inflate(inflater)
        activity?.applicationContext?.let {
            CustomSharedPreferences(it)
        }
        updateThemeMode = customSharedPreferences.getThemeMode()
        if (updateThemeMode != null) {
            if (updateThemeMode!!) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.tvThemeMode.text = context?.getString(R.string.disable_dark_mode)
                binding.scDarkTheme.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.tvThemeMode.text = context?.getString(R.string.enable_dark_mode)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scDarkTheme.setOnClickListener {
            if (updateThemeMode != null) {
                if (updateThemeMode!!) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    customSharedPreferences.saveThemeMode(false)
                    binding.tvThemeMode.text = context?.getString(R.string.enable_dark_mode)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    customSharedPreferences.saveThemeMode(true)
                    binding.tvThemeMode.text = context?.getString(R.string.disable_dark_mode)
                }
            }
        }
    }
}