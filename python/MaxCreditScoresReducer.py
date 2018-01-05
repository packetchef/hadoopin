#!/usr/bin/python

import sys

(last_key, max_val) = (None, -sys.maxsize)

for line in sys.stdin:
    (key, val) = line.strip().split('\t')
    if last_key and last_key != key:
        print('{0}\t{1}'.format(last_key, max_val))
        (last_key, max_val) = (key, int(val))
    else:
        (last_key, max_val) = (key, max(max_val, int(val)))

if last_key:
    print('{0}\t{1}'.format(last_key, max_val))


