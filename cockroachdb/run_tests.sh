#!/bin/bash
rm *.out
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
date
#
./rand -batch=1 -concurrency=2 -db=setask -table=orders -duration=1m > rand_b1_c2_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=10 -concurrency=2 -db=setask -table=orders -duration=1m > rand_b10_c2_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=50 -concurrency=2 -db=setask -table=orders -duration=1m > rand_b50_c2_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=100 -concurrency=2 -db=setask -table=orders -duration=1m > rand_b100_c2_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=500 -concurrency=2 -db=setask -table=orders -duration=1m > rand_b500_c2_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=1 -concurrency=4 -db=setask -table=orders -duration=1m > rand_b1_c4_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=1 -concurrency=8 -db=setask -table=orders -duration=1m > rand_b1_c8_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=100 -concurrency=4 -db=setask -table=orders -duration=1m > rand_b100_c4_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=100 -concurrency=8 -db=setask -table=orders -duration=1m > rand_b100_c8_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=500 -concurrency=4 -db=setask -table=orders -duration=1m > rand_b500_c4_o.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_o.sql
sleep 30
./rand -batch=500 -concurrency=8 -db=setask -table=orders -duration=1m > rand_b500_c8_o.out
#
#
date
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=1 -concurrency=2 -db=setask -table=lineitem -duration=1m > rand_b1_c2_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=10 -concurrency=2 -db=setask -table=lineitem -duration=1m > rand_b10_c2_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=50 -concurrency=2 -db=setask -table=lineitem -duration=1m > rand_b50_c2_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=100 -concurrency=2 -db=setask -table=lineitem -duration=1m > rand_b100_c2_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=500 -concurrency=2 -db=setask -table=lineitem -duration=1m > rand_b500_c2_i.out
#
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=10 -concurrency=4 -db=setask -table=lineitem -duration=1m > rand_b10_c4_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=50 -concurrency=4 -db=setask -table=lineitem -duration=1m > rand_b50_c4_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=100 -concurrency=4 -db=setask -table=lineitem -duration=1m > rand_b100_c4_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=500 -concurrency=4 -db=setask -table=lineitem -duration=1m > rand_b500_c4_i.out
#
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=10 -concurrency=8 -db=setask -table=lineitem -duration=1m > rand_b10_c8_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=50 -concurrency=8 -db=setask -table=lineitem -duration=1m > rand_b50_c8_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=100 -concurrency=8 -db=setask -table=lineitem -duration=1m > rand_b100_c8_i.out
#
./cockroach-v1.1.2.linux-amd64/cockroach sql --insecure --host=localhost < truncate_i.sql
sleep 30
./rand -batch=500 -concurrency=8 -db=setask -table=lineitem -duration=1m > rand_b500_c8_i.out
#
date
