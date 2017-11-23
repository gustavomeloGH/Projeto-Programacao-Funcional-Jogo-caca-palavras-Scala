package br.com.novaroma.project

import scala.util.Random
import br.com.novaroma.util.EnumLevel
import sun.invoke.empty.Empty
import sun.security.util.Length
import br.com.novaroma.util.EnumAmountWord
import br.com.novaroma.util.EnumLineType
import br.com.novaroma.util.EnumFillMatrix

class GameGUI {

  //Definition variables
  private val wordHunt = new Game
  private var jLine = (i: Int) => (0 to i).foreach(_ => print("\n"))
  private var empty = ('\0')
  private var rightWords = List("")
  private var win = 0

  //----------- GUI GAME ---------------

  //------GUI METHODS
  def startGame(): Unit = {
    wordHunt.buildGame(inputMenuGame)
    win = wordHunt.getWordsAswers.length
    loadGameRunning
  }

  def loadGameRunning(): Unit = {
     jLine(10)
    showGame(wordHunt.getMatrix)//mudar aqui
    while (win > 0) {
      inputMainGame
    }
    //finish game here
    println("\nTerminado o jogo!\n---> Resposta do jogo encerrado: \n")
    showGame(wordHunt.getMatrix)
  }
  
  def showGame(matrix: Array[Array[Char]]): Unit = {
     showWordsGame
     enumMatrix
     show(matrix)
  }

  //------SHOW METHODS
  
  def showWordsGame(): Unit = 
  println("\nSegue abaixo as palavras deste jogo:\n ---> " + (wordHunt.getWordsAswers mkString ", ") + " <--- \n")

  
  def show(currMatrix: Array[Array[Char]]): Unit = {
    var i = 0
    for (r <- 0 until currMatrix.length) {
      for (c <- 0 until currMatrix(r).length) {
        c match {
          case 0 => { if (i < 10) print(" " + i + " | " + currMatrix(r)(c) + "  ") else print(i + " | " + currMatrix(r)(c) + "  ") }
          case _ => print(currMatrix(r)(c) + "  ")
        }
      }
       i+=1 
       println();
    }
  }


  //------GAME MENU
  //inputs and changes

  def inputMenuGame: Int = {
    println("Digite o nível que deseja iniciar o jogo:  " +
      "\n1- Fácil (Contém linhas verticais e horizontais) " +
      "\n2- Médio (Contém linhas verticais, horizontais e diagonais) " +
      "\n3- Difícil (Contém linhas verticais, horizontais, diagonais e transversais)\n\n")
    var n = 0
    try {
      n = scala.io.StdIn.readLine().toInt
    } catch {
      case ex: Throwable => n = 0
    }
    
    if (n <= 0 || n > 3) inputMenuGame else n
  }

  def inputMainGame(): Unit = {
    
      println("\n0 - Para digitar a palavra\n1 - Para limpar tela\n2 - Sair")
      var n = 0
      try { n = scala.io.StdIn.readLine().toInt } catch { case ex => n = 3} 
      
      n match {
        case 0 => inputWordGame
        case 1 => jLine(10); showGame(wordHunt.getMatrix); 
        case 2 => win = 0
        case _ => println("Comando inválido!")
      }
  }
  
  def inputWordGame() : Unit = {
    val (t, line, initC, fromC) = inputWordFromPlayer
          t match {
            case null => println ("\nDigite corretamente!");
            case _ => {
                        jLine(10)
                        if (checkAswer(t, line, initC, fromC - 1)) win -= 1
                        println(s"\nFaltando $win palavras\n")
                        showGame(wordHunt.getMatrix)//mudarAqui
                      }
          }
  }
  
  def inputWordFromPlayer(): (String, Int, Int, Int) = {
    try {
         println("Digte o comando: " +
            "\n-> Tipos: vert, horiz, diag, trans. \n(Obs. apenas pertencentes a modalidade escolhida)")
          println("Tipo: ")
          var t = scala.io.StdIn.readLine()
          println("Linha: ")
          var line = scala.io.StdIn.readLine().toInt
          println("Inicio da coluna: ")
          var initC = scala.io.StdIn.readLine().toInt
          println("Quantidade letras desta palavra: ")
          var fromC = scala.io.StdIn.readLine().toInt
          return checkInput(t, line, initC, fromC)
    } catch {
        case ex: Throwable => return (null, -1,-1,-1)
    }
  }
  
  def checkInput(t: String, line: Int, initC: Int, fromC: Int) : (String, Int, Int, Int) = {
    val booStr = t == "vert" || t == "horiz" || t == "diag" || t == "trans"
    val size = wordHunt.getMatrix.length
    val booInt = line < size && initC < size && fromC < size
    return if (booStr && booInt)  (t, line, initC, fromC) else (null, -1,-1,-1)
  }

  //----- GAME CHECK ASWERS

  def checkAswer(t: String, line: Int, initC: Int, fromC: Int): Boolean = {
    var foundWord = t match {
      case "vert"  => getString(1, 0, line, initC, (initC + fromC))
      case "horiz" => getString(0, 1, line, initC, (initC + fromC))
      case "diag"  => getString(1, 1, line, initC, (initC + fromC))
      case "trans" => getString(1, -1, line, initC, (initC + fromC))
    }
    var exist = wordHunt.getWordsAswers.contains(foundWord)
    var alreadyFound = rightWords.contains(foundWord)

    print(s"A palavra digitada foi: $foundWord,")
    if (exist) {
      if (alreadyFound) {
        print(" esta palavra já foi encontrada!")
      } else {
        rightWords = foundWord :: rightWords
        print(" você acertou! ")
      }
    } else {
      print(" você errou! ")
    }

    return exist && !alreadyFound
  }

  //-------GET WORD FROM MATRIX
  def getString(px: Int, py: Int, x: Int, y: Int, endY: Int): String = {
    var seq = List.range(y, endY + 1)
    seq.zipWithIndex.map(i => wordHunt.getMatrixGame(x + px * i._2)(y + py * i._2)).mkString
  }
  
  def setMatrixWordFound(): Unit = {
    
  }

  //-------SET ENUMERATION ON MATRIX
  def enumMatrix() = {
    var size = wordHunt.getMatrixGame.length
    print("    ")
    for (i <- 0 to size - 1) yield if (i < 10) print(s" $i ") else print(s"$i "); println()
    //just for esthetic =)
    for (i <- 0 to (size * 3) + 2) yield print("-"); println()

  }

}