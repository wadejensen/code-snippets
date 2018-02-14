val appsummary = spark.read.json("/path/to/appsummary/*.json")

val containerSizes = appsummary.select("id", "runningContainers", "allocatedMB", "allocatedVCores")
                               .filter($"allocatedMB" =!= 0 && $"allocatedMB".isNotNull )
                               .filter($"allocatedVCores" =!= 0 && $"allocatedVCores".isNotNull )
                               .withColumn("vcoresPerContainer", $"allocatedVCores"/$"runningContainers")
                               .withColumn("allocatedGbPerContainer", $"allocatedMB"/1024/$"runningContainers")
containerSizes.cache

import org.apache.spark.ml.feature.Bucketizer
import org.apache.spark
val splits = Array[Double](0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, Double.PositiveInfinity)

val bucketizer = new Bucketizer().setInputCol("allocatedGbPerContainer")
                                 .setOutputCol("memBin")
                                 .setSplits(splits)

val binnedMemorySize = bucketizer.transform(containerSizes.distinct)
                                 .withColumn("containerSizeGb", $"memBin" * 5)
                                 .groupBy("containerSizeGb")
                                 .agg(count("*"))
                                 .orderBy("containerSizeGb")
