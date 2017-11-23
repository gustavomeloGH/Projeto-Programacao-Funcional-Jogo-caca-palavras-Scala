package br.com.novaroma.main

import br.com.novaroma.project.WordList
import br.com.novaroma.project.GameGUI
import br.com.novaroma.util.EnumLevel

object Main {

  def main(args: Array[String]) {
    
    val wordHuntGUI = new GameGUI
    wordHuntGUI.startGame()
    
  }
}