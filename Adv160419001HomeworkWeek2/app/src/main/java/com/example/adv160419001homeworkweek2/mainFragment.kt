package com.example.adv160419001homeworkweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [mainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class mainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var num1 =  Random.nextInt(0, 20)
        var num2 =  Random.nextInt(0, 20)

        textNum1.text = num1.toString()
        textNum2.text = num2.toString()

        var hitungScore = 0
        buttonSubmit.setOnClickListener {
            val hasil = textNum1.text.toString().toInt() + textNum2.text.toString().toInt()

            if (answerText.text.toString().toInt() == hasil)
            {
                hitungScore += 1
                textMainScore.text = hitungScore.toString()
                var num1 =  Random.nextInt(0, 20)
                var num2 =  Random.nextInt(0, 20)

                textNum1.text = num1.toString()
                textNum2.text = num2.toString()

                answerText.setText("")
            }
            else {
                // Ambil score
                val score = hitungScore.toString()
                //mendapatkan action yang diinginkan
                val action = mainFragmentDirections.actionResultFragment(score)
                //run action
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
}