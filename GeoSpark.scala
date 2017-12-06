package sparkpkg

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Test2 {
def main(args: Array[String]) {
    println("Hello World")
    
    //spark context setup
    val jobName = "PatientDrugCount"    
    val conf = new SparkConf().setAppName(jobName).setMaster("local");
    val sc = new SparkContext(conf)
    
    val city = sc.textFile("file:///home/datadotz/topology.txt", 1)       
    val citysplit=city.map(line=>{val ele=line.split(" "); (ele(0)+"|"+ele(1)+"|"+ele(2)+"T"+ele(3)+"Z"+"|"+ele(4)+"|"+ele(5)+"|"+ele(6)+"|"+ele(7))})
 
    val strreplace=city.map(line=>{val ele=line.replaceAll(" ","|");ele}) 

    strreplace.collect().foreach { println }
 
    citysplit.saveAsTextFile("file:///home/datadotz/topologyout")
}
}