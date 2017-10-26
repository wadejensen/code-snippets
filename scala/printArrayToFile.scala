// FileWriter
val file = new File("myFile.csv")
val bw = new BufferedWriter(new FileWriter(file))
bw.write("index, speed\n")
for ( i <- 0 until speeds.length) {
  val t = i + timeInitial
  for ( j <- 0 until racePlan.length) {
    if ( t == racePlan(j).t1 || t == racePlan(j).t2 ) {
      bw.write(s"------------------------------------------------------\n")
      bw.write(s"------------------------------------------------------\n")
    }
  }
  val s = speeds(i)
  bw.write(s"$t, $s\n")
}
bw.close()

println(file.getAbsolutePath)
