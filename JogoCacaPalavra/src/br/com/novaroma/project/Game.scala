package br.com.novaroma.project

import scala.util.Random
import br.com.novaroma.util.EnumLevel
import sun.invoke.empty.Empty
import sun.security.util.Length
import br.com.novaroma.util.EnumAmountWord
import br.com.novaroma.util.EnumLineType
import br.com.novaroma.util.EnumFillMatrix

class Game {

  //Definition variables
  private val wordsListClass = new WordList
  private val wordsLevelEasy = wordsListClass.getWordList(EnumAmountWord.Easy.id);
  private val wordsLevelMedium = wordsListClass.getWordList(EnumAmountWord.Medium.id)
  private val wordsLevelHard = wordsListClass.getWordList(EnumAmountWord.Hard.id)
  private var wordsAswers = List("")
  private var empty = ('\0')
  private var matrix = Array.ofDim[Char](0, 0)
  private var matrixGame = Array.ofDim[Char](0, 0)
  private var alphabet = "abcdefghijklmnopqrstuwvxz"

  //First-order function
  private var randomN = (start: Int, end: Int) => start + Random.nextInt((end - start) + 1)
  private val lineGame = (word: String, n: Int) => n match {
    case 1 => fillHoriz(word)
    case 2 => fillVert(word)
    case 3 => fillDiag(word)
    case 4 => fillTrans(word)
  }
  

  //DEFINITION OF CLASS METHODS

  def buildGame(startLevel: Int) = {
    var boo = false
    do {
      boo = false
      val (size, wordsList, lineType) = startLevel match {
        case 1 => (EnumLevel.Easy.id, wordsLevelEasy, EnumLineType.vertHorizon.id)
        case 2 => (EnumLevel.Medium.id, wordsLevelMedium, EnumLineType.vertHorizonDiag.id)
        case 3 => (EnumLevel.Hard.id, wordsLevelHard, EnumLineType.vertHorizonDiagTrans.id)
      }
      matrix = Array.ofDim[Char](size, size)
      try {
        wordsList.foreach(c => lineGame(c, randomN(1, randomN(1, lineType))))
        matrixGame = matrix.map(r => r.map(c => if (c.==(empty)) alphabet.charAt(randomN(0, alphabet.length() - 1)) else c))
        wordsAswers = wordsList
      } catch {
        case ex: Throwable => boo = true
      }
    } while (boo)
  }


   //--------------- FILL MATRIX 
  
   //------------ VERTICAL GENERATOR ------------------
  
    def fillVert(word: String): Unit = {
       var x = randomN(0, Math.abs(word.size - matrix.size))
       var y = randomN(0, matrix.size - 1)
       var (p,q) = getInd(1,0)(x,y)(word)
        p match {
          case -1 => fillVert(word)
          case _ => fill(1,0)(x,y)(word)
        }
    }

    //------------ HORIZONTAL GENERATOR -------------------
    
     def fillHoriz(word: String): Unit = {
       var x = randomN(0, matrix.size - 1)
       var y = randomN(0, Math.abs(word.size - matrix.size))
       var (p,q) = getInd(0,1)(x,y)(word)
        p match {
          case -1 => fillHoriz(word)
          case _ => fill(0,1)(x,y)(word)
        }
    }

    //------------ DIAGONAL GENERATOR -------------------
 
    def fillDiag(word: String): Unit =  {
       var x = randomN(0, Math.abs(word.size - matrix.size))
       var y = randomN(0, Math.abs(word.size - matrix.size))
       var (p,q) = getInd(1,1)(x,y)(word)
        p match {
          case -1 => fillDiag(word)
          case _ => fill(1,1)(x,y)(word)
        }
    }
    
    //----------- TRANSVERSAL GENERATOR ---------------
    
    def fillTrans(word: String): Unit = {
        var x = randomN(0, Math.abs(word.size - matrix.size)) 
        var y = randomN(0, Math.abs(word.size - matrix.size)) + word.size - 1
        var (p,q) = getInd(1,-1)(x,y)(word)
        p match {
          case -1 => fillTrans(word)
          case _ => fill(1,-1)(x,y)(word)
        }
    }
    
     //----------- GENERIC GENERATOR ---------------
    
    def fill(px: Int, py: Int)(x: Int, y: Int)(word: String): Unit = {
      for ((c, i) <- word.zipWithIndex) {
        matrix(x + px * i)(y + py * i) = c
        }
    }
  
    def getInd(px: Int, py: Int)(x: Int, y: Int)(word: String): (Int, Int) = {
      var seq = 0 until word.length - 1
      
      seq.filter(i => matrix(x + i * px)(y + i * py) != empty).size match {
        case 0 => return (x, y)
        case _ => return(-1, -1)
      }
    }

    

  //----------- GET/SET METHODS GAME ---------------

  def getMatrix = matrix
  def getMatrixGame = matrixGame
  def getWordsAswers = wordsAswers
  def setMatrixGame(newMatrix: Array[Array[Char]]) = { matrixGame = newMatrix }

    
    //CÓDIGO ANTERIOR
    
      //ALTERNATIVE WAY
  //by: Leonardo Lucena -> git.io/vF9FY

  //   private val lineGame = (word: String, n: Int) => n match {
  //    case 1 => fill(1, 0)(word)
  //    case 2 => fill(0, 1)(word)
  //    case 3 => fill(1, 1)(word)
  //    case 4 => fill(1, -1)(word)
  //  }
  

  //  def fill(px: Int, py: Int)(word: String): Unit = {
  //    var (x, y) = ind(px, py)(word)
  //    for ((c, i) <- word.zipWithIndex) {
  //      matrix(x + px * i)(y + py * i) = c
  //    }
  //  }
  //
  //  def ind(px: Int, py: Int)(word: String): (Int, Int) = {
  //    var x = randomN(0, Math.abs(word.size - matrix.size))
  //    var y = randomN(0, matrix.size - 1)
  //    var seq = 0 until word.length
  //    seq.filter(i => matrix(x + i * px)(y + i * py) != empty).size match {
  //      case 0 => return (x, y)
  //      case _ => ind(px, py)(word)
  //    }
  //  }
    
    
    
    
    
    
    //------------------------------------------------------------------
    
    
//      //------------ VERTICAL GENERATOR ------------------
//
//  def fillVert(word: String) = {
//    var (x, y) = getVertInd(word)
//    for (seq <- x until word.length() + x)
//      yield matrix(seq)(y) = word.charAt(seq - x)
//  }
//
//  def getVertInd(word: String): (Int, Int) = {
//    var x = randomN(0, Math.abs(word.size - matrix.size))
//    var y = randomN(0, matrix.size - 1)
//    var seq = List.range(x, word.length() + x)
//    seq.filter(matrix(_)(y) != empty).size match {
//      case 0 => return (x, y)
//      case _ => getVertInd(word)
//    }
//  }
//
//  //------------ HORIZONTAL GENERATOR -------------------
//
//  def fillHoriz(word: String) = {
//    matrix = matrix.transpose
//    fillVert(word)
//    matrix = matrix.transpose
//  }
//
//  //------------ DIAGONAL GENERATOR -------------------
//
//  def fillDiag(word: String) = {
//    var (x, y) = getDiagSeq(word)
//    for (seq <- 0 until word.length()) {
//      matrix(x)(y) = word.charAt(seq)
//      x += 1
//      y += 1
//    }
//  }
//
//  def getDiagSeq(word: String): (Int, Int) = {
//    var x = randomN(0, Math.abs(word.size - matrix.size))
//    var y = randomN(0, Math.abs(word.size - matrix.size))
//    var (seqX, seqY) = ((List.range(x, word.length() + x)), (List.range(y, word.length() + y)))
//    seqX.zip(seqY).filter(idxLC => (matrix(idxLC._1)(idxLC._2) != empty)).size match {
//      case 0 => return (x, y)
//      case _ => getDiagSeq(word)
//    }
//  }
//
//  //----------- TRANSVERSAL GENERATOR ---------------
//
//  def fillTrans(word: String) = {
//    matrix = matrix.map(_.reverse)
//    fillDiag(word)
//    matrix = matrix.map(_.reverse)
//  }
    
    
    
    

}