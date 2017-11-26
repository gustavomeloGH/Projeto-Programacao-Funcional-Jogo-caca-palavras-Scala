package br.com.novaroma.main

import br.com.novaroma.project.WordList
import br.com.novaroma.project.GameGUIImpl
import br.com.novaroma.util.EnumLevel

object Main {

  def main(args: Array[String]) {
    
    val wordHuntGUI = new GameGUIImpl
    wordHuntGUI.startGame()
    
  }
}