package br.com.deyvidfernandes.androidvegetablequiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import br.com.deyvidfernandes.androidvegetablequiz.databinding.FragmentGameBinding
import br.com.deyvidfernandes.androidvegetablequiz.model.Answer
import br.com.deyvidfernandes.androidvegetablequiz.model.Question

class GameFragment : Fragment() {

    private val questions: MutableList<Question> = mutableListOf()
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<Answer>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        prepareQuestions()

        showQuestion(binding)


        //Lógica do botão enviar resposta
        binding.buttonSend.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.radioGroupQuestions.checkedRadioButtonId
            // Verifica se tem uma opção escolhida
            if (-1 != checkedId) {
                val radioButton: View = binding.radioGroupQuestions.findViewById(checkedId)
                val answerIndex = binding.radioGroupQuestions.indexOfChild(radioButton)
                //Pega a resposta selecionada
                val answerChecked = answers[answerIndex]
                if(answerChecked.correct){
                    // We've won!  Navigate to the gameWonFragment.
                    view.findNavController()
                        .navigate(R.id.action_gameFragment_to_gameWonFragment)
                    //Safe Arguments
//                        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(numQuestions, questionIndex))
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().
                        navigate(R.id.action_gameFragment_to_gameOverFragment)
                    //Safe Arguments
//                    view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment())
                }
            }
        }
        return binding.root
    }

    private fun showQuestion(binding: FragmentGameBinding) {
        //Escolhe uma das questões e exibe na tela
        currentQuestion = questions[0]
        //Cria uma nova lista com as respostas
        answers = currentQuestion.answers.toMutableList()
        //Embaralha a lista de respostas
        answers.shuffle()

        binding.imageViewQuestion.setImageResource(currentQuestion.image)
        binding.textViewQuestion.text = currentQuestion.text
        binding.radioButtonFirstAnswer.text = answers[0].text
        binding.radioButtonSecondAnswer.text = answers[1].text
        binding.radioButtonThirdAnswer.text = answers[2].text
        binding.radioButtonFourthAnswer.text = answers[3].text
    }

    private fun prepareQuestions() {
        //Cria a base de questões
        questions.add(
            Question(
                getString(R.string.question_quiz1), R.drawable.ic_questions_artichoke,
                listOf(
                    Answer(getString(R.string.answers_quiz1_option1),true),
                    Answer(getString(R.string.answers_quiz1_option2),false),
                    Answer(getString(R.string.answers_quiz1_option3),false),
                    Answer(getString(R.string.answers_quiz1_option4),false)
                )
            )
        )

        questions.add(
            Question(
                getString(R.string.question_quiz2), R.drawable.ic_questions_asparagus,
                listOf(
                    Answer(getString(R.string.answers_quiz2_option1),true),
                    Answer(getString(R.string.answers_quiz2_option2),false),
                    Answer(getString(R.string.answers_quiz2_option3),false),
                    Answer(getString(R.string.answers_quiz2_option4),false)
                )
            )
        )

        questions.add(
            Question(
                getString(R.string.question_quiz3), R.drawable.ic_questions_bell_pepper,
                listOf(
                    Answer(getString(R.string.answers_quiz3_option1), true),
                    Answer(getString(R.string.answers_quiz3_option2), false),
                    Answer(getString(R.string.answers_quiz3_option3), false),
                    Answer(getString(R.string.answers_quiz3_option4), false)
                )
            )
        )

        questions.add(
            Question(
                getString(R.string.question_quiz4), R.drawable.ic_questions_carrot,
                listOf(
                    Answer(getString(R.string.answers_quiz4_option1),true),
                    Answer(getString(R.string.answers_quiz4_option2),false),
                    Answer(getString(R.string.answers_quiz4_option3),false),
                    Answer(getString(R.string.answers_quiz4_option4), false)
                )
            )
        )

        questions.add(
            Question(
                getString(R.string.question_quiz5), R.drawable.ic_questions_corn,
                listOf(
                    Answer(getString(R.string.answers_quiz5_option1), true),
                    Answer(getString(R.string.answers_quiz5_option2), false),
                    Answer(getString(R.string.answers_quiz5_option3), false),
                    Answer(getString(R.string.answers_quiz5_option4), false)
                )
            )
        )

        questions.add(
            Question(
                getString(R.string.question_quiz6), R.drawable.ic_questions_pumpkin,
                listOf(
                    Answer(getString(R.string.answers_quiz6_option1), true),
                    Answer(getString(R.string.answers_quiz6_option2), false),
                    Answer(getString(R.string.answers_quiz6_option3), false),
                    Answer(getString(R.string.answers_quiz6_option4), false)
                )
            )
        )

        //Embaralha a lista de questões
        questions.shuffle()
    }
}
