package br.com.novaroma.traitProject

trait GameGUITrait {

  //------GUI METHODS
  def startGame
  def loadGameRunning
  def showGame(matrix: Array[Array[Char]])
  
  //------SHOW METHODS
  
  def showWordsGame
  def show(currMatrix: Array[Array[Char]])

  //------GAME MENU
  //inputs and changes

  def inputMenuGame: Int
  def inputMainGame
  def inputWordGame
  def inputWordFromPlayer(): (String, Int, Int, Int)
  def checkInput(t: String, line: Int, initC: Int, fromC: Int) : (String, Int, Int, Int)

  //----- GAME CHECK ASWERS

  def checkAswer(t: String, line: Int, initC: Int, fromC: Int): Boolean

  //-------GET WORD FROM MATRIX
  
  def getString(px: Int, py: Int, x: Int, y: Int, endY: Int): String
  def setMatrixWordFound(px: Int, py: Int, size: Int, x: Int, y: Int)

  //-------SET ENUMERATION ON MATRIX
  
  def enumMatrix

}