###By default, a part-I-##### is created for each node.  These can be merged on HDFS or brought back to the edge node and merged there.

To merge on the edge node:
hdfs dfs -getmerge results/part* results.txt

To merge on HDFS:
hdfs dfs -cat results/part* | hdfs dfs -put - results/results.txt


