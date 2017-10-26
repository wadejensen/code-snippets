object TimerMain extends App {
  println("For 1,000,000 System.nanoTime calls: in us")
  for ( i <- 0 until 20) {
    val timer1 = System.nanoTime

    var i = 0
    var time: Long = 0
    while ( i < 999999 ) {
      i += 1
      time = System.nanoTime
    }

    val timer2 = System.nanoTime
    println( (timer2-timer1) / 1000)
  }
  System.exit(1)
}

  
