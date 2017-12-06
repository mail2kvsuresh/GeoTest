package scalaproj
import java.io._


object CityWeather {
def main(args: Array[String]) {
  var outrec:String=""
  //Input File Path
  val bufferedSource=io.Source.fromFile("/home/datadotz/topology.txt")
  
  //Output File
  val writer = new PrintWriter(new File("/home/datadotz/topoutscala.txt" ))
  
  //Reading i/p file
  for(line <- bufferedSource.getLines)
  {
    val cols=line.split(" ").map {_.trim()}
    
    for(i<-0 to 7) {
      if (i==2)
        outrec = outrec + cols(i) + "T"
      else if(i==3)
        outrec = outrec + cols(i) + "z"+"|"
      else
      outrec = outrec + cols(i) + "|"      
    }
    
    //Writing records into o/p file and Console
    println(outrec)    
    writer.write(outrec)
    writer.write("\n")
    outrec=""
        
  } //End of i/p file read

//Closing files
writer.close()
bufferedSource.close()
}
}
