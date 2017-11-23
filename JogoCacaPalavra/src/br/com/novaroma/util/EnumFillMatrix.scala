package br.com.novaroma.util

 object EnumFillMatrix extends Enumeration {
  type EnumFillMatrix = Value
  val vert = Value("vert")
  val horiz = Value("horiz") 
  val diag = Value("diag") 
  val trans = Value("trans") 
}