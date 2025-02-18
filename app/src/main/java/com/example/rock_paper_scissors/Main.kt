package com.example.rock_paper_scissors

fun main() {
    val choices = listOf("Rock", "Paper", "Scissors", "Lizard", "Spock")

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

        val winner = when {
            playerChoice == computerChoice -> "Tie"
            playerChoice == "Rock" && (computerChoice == "Scissors" || computerChoice == "Lizard") -> "Player"
            playerChoice == "Paper" && (computerChoice == "Rock" || computerChoice == "Spock") -> "Player"
            playerChoice == "Scissors" && (computerChoice == "Paper" || computerChoice == "Lizard") -> "Player"
            playerChoice == "Lizard" && (computerChoice == "Spock" || computerChoice == "Paper") -> "Player"
            playerChoice == "Spock" && (computerChoice == "Scissors" || computerChoice == "Rock") -> "Player"
            else -> "Computer"
        }

        println(if (winner == "Tie") "It's a tie!" else "$winner is the winner!")

        var playAgain: String
        while (true) {
            println("\nWould you like to play again? (y/n)")
            playAgain = readln().trim().lowercase()

            // Check for valid play again input
            if (playAgain in listOf("y", "n")) break
            println("Enter a valid selection (y or n)!")
        }

    } while (playAgain == "y")

    println("Goodbye! Thanks for playing.")
}

