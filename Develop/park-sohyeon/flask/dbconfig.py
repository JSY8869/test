import pymysql
db= pymysql.connect(host='localhost',port=3306,user='root',db='mysql',charset='utf8')


db.cursor().execute("show tables")
sql = """INSERT INTO test_table(name)
         VALUES('test_name')"""
 
db.cursor().execute(sql)
db.commit()

sql= """SELECT name FROM test_table"""

db.close()