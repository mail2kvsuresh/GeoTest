package scalaproj
import java.io._


object CityWeather {
def main(args: Array[String]) {
  var finalstr:String=""
  val bufferedSource=io.Source.fromFile("/home/datadotz/topology.txt")
  val writer = new PrintWriter(new File("/home/datadotz/topoutscala.txt" ))
  
  for(line <- bufferedSource.getLines)
  {
    val cols=line.split(" ").map {_.trim()}
    for(i<-0 to 7) {
      if (i==2)
        finalstr = finalstr + cols(i) + "T"
      else if(i==3)
        finalstr = finalstr + cols(i) + "z"+"|"
      else
      finalstr = finalstr + cols(i) + "|"
      
    }
    println(finalstr)
    
    writer.write(finalstr)
    writer.write("\n")
    finalstr=""
    //println(s"${cols(0)}|${cols(1)}|${cols(2)} ${cols(3)}|${cols(4)}|${cols(5)}${cols(6)}|${cols(7)}")
      
  } 
  writer.close()
bufferedSource.close()
}

}
