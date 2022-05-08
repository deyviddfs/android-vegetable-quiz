package br.com.deyvidfernandes.androidvegetablequiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import br.com.deyvidfernandes.androidvegetablequiz.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)

        binding.buttonPlayAgain.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameWonFragment_to_titleFragment))
        return binding.root
    }
}
