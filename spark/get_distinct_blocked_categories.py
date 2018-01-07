lines = sc.textFile('ws/ws.20140623.sql.csv')
bc = lines.filter(lambda x: 'Blocked' in x).map(
	lambda x: x.split(',')[3]).filter(
	lambda x: x[0] != ' ').distinct()

cats = bc.collect()

.distinct() is unique to Spark.  With straight Python, this reduce function would get unique categories (assuming blocked_cats is a list of all blocked categories):
uniq_blocked_cats = reduce(lambda x, y: x+[y] if not y in x else x, blocked_cats, []

