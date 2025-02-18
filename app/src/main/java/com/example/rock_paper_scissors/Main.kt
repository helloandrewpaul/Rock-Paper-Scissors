package com.example.rock_paper_scissors

fun main() {
    val choices = listOf("Rock", "Paper", "Scissors", "Lizard", "Spock")

    val rules = mapOf(
        "Rock" to listOf("Scissors" to "Rock crushes Scissors", "Lizard" to "Rock crushes Lizard"),
        "Paper" to listOf("Rock" to "Paper covers Rock", "Spock" to "Paper disproves Spock"),
        "Scissors" to listOf("Paper" to "Scissors cuts Paper", "Lizard" to "Scissors decapitates Lizard"),
        "Lizard" to listOf("Spock" to "Lizard poisons Spock", "Paper" to "Lizard eats Paper"),
        "Spock" to listOf("Scissors" to "Spock smashes Scissors", "Rock" to "Spock vaporizes Rock")
    )

    fun getWinningMessage(winner: String): String {
        return if (winner == "Player") "Player is the winner!" else "Computer is the winner!"
    }

    fun checkWinner(playerChoice: String, computerChoice: String): String {
        return when {
            playerChoice == computerChoice -> "Tie"
            rules[playerChoice]?.any { it.first == computerChoice } == true -> "Player"
            rules[computerChoice]?.any { it.first == playerChoice } == true -> "Computer"
            else -> "Computer"
        }
    }

    do {
        var playerChoice: String

        while (true) {
            println("Choose your move:\n1 - Rock\n2 - Paper\n3 - Scissors\n4 - Lizard\n5 - Spock")
            val input = readln().trim()
            val choice = input.toIntOrNull()

            if (choice != null && choice in 1..5) {
                playerChoice = choices[choice - 1]
                break
            } else {
                println("Enter a valid selection!")
            }
        }

        val computerChoice = choices.random()

        println("\nYou chose: $playerChoice")
        println("Computer chose: $computerChoice")

        val winner = checkWinner(playerChoice, computerChoice)

        if (winner != "Tie") {
            val defeatMessage = rules[playerChoice]?.firstOrNull { it.first == computerChoice }?.second
                ?: rules[computerChoice]?.firstOrNull { it.first == playerChoice }?.second
                ?: "No special message"
            println(defeatMessage)
        }

        val resultMessage = if (winner == "Tie") "It's a tie!" else getWinningMessage(winner)

        println(resultMessage)

        var playAgain: String
        while (true) {
            println("\nWould you like to play again? (y/n)")
            playAgain = readln().trim().lowercase()

            if (playAgain in listOf("y", "n")) break
            println("Enter a valid selection (y or n)!")
        }

    } while (playAgain == "y")

    println("Goodbye! Thanks for playing.")
}




