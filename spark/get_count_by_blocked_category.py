lines = sc.textFile('ws/ws.20140623.sql.csv')
bcc = lines.filter(lambda x: 'Blocked' in x).map(
	lambda x: (x.split(',')[3], 1)).filter(
	lambda x: x[0][0] != ' ').reduceByKey(
	lambda x, y: x + y)

bcc.collect()


