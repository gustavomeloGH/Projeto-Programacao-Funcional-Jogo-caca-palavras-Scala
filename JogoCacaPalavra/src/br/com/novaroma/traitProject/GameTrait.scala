package br.com.novaroma.traitProject

trait GameTrait {


  //DEFINITION OF CLASS METHODS

  def buildGame(startLevel: Int)
  
   //--------------- FILL MATRIX 
  
   //------------ VERTICAL GENERATOR ------------------
  
    def fillVert(word: String): Unit 
    
    //------------ HORIZONTAL GENERATOR -------------------
    
     def fillHoriz(word: String): Unit 

    //------------ DIAGONAL GENERATOR -------------------
 
    def fillDiag(word: String): Unit 
    
    //----------- TRANSVERSAL GENERATOR ---------------
    
    def fillTrans(word: String): Unit 
    
     //----------- GENERIC GENERATOR ---------------
    
    def fill(px: Int, py: Int)(x: Int, y: Int)(word: String): Unit 
    def getInd(px: Int, py: Int)(x: Int, y: Int)(word: String): (Int, Int) 
    

  //----------- GET/SET METHODS GAME ---------------

    def getMatrix: Array[Array[Char]] 
    def getMatrixGame: Array[Array[Char]]
    def getWordsAswers: List[String]
    def setMatrixGame(newMatrix: Array[Array[Char]]): Unit

 }