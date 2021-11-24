CREATE TABLE t1 
( 
    a         NUMBER, 
    x         NUMBER
   
); 

CREATE TABLE t2 
( 
    b         NUMBER, 
    y         NUMBER
   
); 

CREATE TABLE t3 
( 
    c         NUMBER, 
    z         NUMBER 
   
); 

--case o inserts:
INSERT INTO t1 (a, x) VALUES (2, 1); 
INSERT INTO t1 (a, x) VALUES (3, 1);
INSERT INTO t1 (a, x) VALUES (4, 1);
INSERT INTO t1 (a, x) VALUES (5, 1);

INSERT INTO t2 (b, y) VALUES (1, 1); 
INSERT INTO t2 (b, y) VALUES (2, 1);
INSERT INTO t2 (b, y) VALUES (3, 1);

INSERT INTO t3 (c, z) VALUES (1, 1); 
INSERT INTO t3 (c, z) VALUES (2, 1);



--case 2 inserts:
INSERT INTO t1 (a, x) VALUES (0.970000 , 0.600000); 
INSERT INTO t1 (a, x) VALUES (0.050000 , 0.330000); 
INSERT INTO t1 (a, x) VALUES (0.210000 , 0.300000); 
INSERT INTO t1 (a, x) VALUES (0.410000 , 0.450000); 
INSERT INTO t1 (a, x) VALUES (0.770000 , 0.500000); 


INSERT INTO t2 (b, y) VALUES (0.040000 , 0.710000); 
INSERT INTO t2 (b, y) VALUES (0.640000 , 0.580000);
INSERT INTO t2 (b, y) VALUES (0.190000 , 0.070000);
INSERT INTO t2 (b, y) VALUES (0.810000 , 0.880000); 
INSERT INTO t2 (b, y) VALUES (0.430000 , 0.710000);
INSERT INTO t2 (b, y) VALUES (0.300000 , 0.480000);
INSERT INTO t2 (b, y) VALUES (0.310000 , 0.350000); 
INSERT INTO t2 (b, y) VALUES (0.380000 , 0.560000);
INSERT INTO t2 (b, y) VALUES (0.550000 , 0.200000);
INSERT INTO t2 (b, y) VALUES (0.330000 , 0.480000); 

INSERT INTO t3 (c, z) VALUES (0.060000 , 0.830000); 
INSERT INTO t3 (c, z) VALUES (0.600000 , 0.200000);
INSERT INTO t3 (c, z) VALUES (0.200000 , 0.520000); 
INSERT INTO t3 (c, z) VALUES (0.500000 , 0.620000);
INSERT INTO t3 (c, z) VALUES (0.780000 , 0.310000); 
INSERT INTO t3 (c, z) VALUES (0.650000 , 0.950000);
INSERT INTO t3 (c, z) VALUES (0.770000 , 0.080000); 
INSERT INTO t3 (c, z) VALUES (0.830000 , 0.690000);
INSERT INTO t3 (c, z) VALUES (0.110000 , 0.430000); 
INSERT INTO t3 (c, z) VALUES (0.570000 , 0.850000);







--queries
SELECT a, SUM(x * y * z) AS s FROM 
t1 LEFT JOIN (SELECT * FROM t2 JOIN t3) AS t
ON a < b + c
GROUP BY a
STABLE ORDER BY s DESC
LIMIT 10;


SELECT  u1.a a, COALESCE(sum(u1.x * d.y * d.z ),0) s 
FROM t1 u1 LEFT OUTER JOIN  (select u2.b ,u2.y, u3.c,u3.z from t2 u2, t3 u3) d 
on (u1.a < d.b + d.c) where ROWNUM <= 10  
group BY u1.a  ORDER BY s DESC;


--questions:
1)The other joins are full outer join without any common attribute ?
2)Should I use an embedded DB or an external ?
3)STABLE it's not clear to me the meaning
4)