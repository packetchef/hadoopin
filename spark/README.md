### pyspark
Some functional stuff with a sample of web filtering data, with a schema the same as ws.sample.csv:

[00] record_number
[01] date_time
[02] user_id
[03] category_name
[04] disposition
[05] url_hostname
[06] dst_port
[07] src_ip
[08] dst_ip
[09] bytes_sent
[10] bytes_received


get_distinct_blocked_categories.py - Get a list of blocked categories
get_count_by_blocked_category.py - Get a count of hits to each blocked category


