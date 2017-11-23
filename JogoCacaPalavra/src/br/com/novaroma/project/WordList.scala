package br.com.novaroma.project

  import scala.io.Source
  import scala.util.Random
    
  class WordList {
      
      private val wordsList = Source.fromFile("src/resources/Palavras.txt").getLines.toList
      def getWordList(n:Int): List[String] = Random.shuffle(wordsList).take(n)
                  
  }