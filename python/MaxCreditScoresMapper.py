#!/usr/bin/python

import sys

for line in sys.stdin:
    try:
        ssn, score = line.strip().split(',')
        print('{0}\t{1}'.format(ssn, score))
    except ValueError as e:
        # ValueError usually means not enough values to unpack in the input,
        # eg. empty lines or only one column
        pass 

