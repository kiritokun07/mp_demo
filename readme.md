# mybatis plus count查询报错测试

mybatis-plus 3.4.3.1
使用queryChainWrapper，在count前select了一下
sql为
`SELECT COUNT(  id,name  ) FROM mp_demo     WHERE (data_status = ?)`

报错
```
{
  "code": 999,
  "msg": "org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'name\n ) FROM mp_demo \n \n WHERE (data_status = 0)' at line 2\r\n### The error may exist in com/example/demo/mapper/MpDemoMapper.java (best guess)\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: SELECT COUNT(  id,name  ) FROM mp_demo     WHERE (data_status = ?)\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'name\n ) FROM mp_demo \n \n WHERE (data_status = 0)' at line 2\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'name\n ) FROM mp_demo \n \n WHERE (data_status = 0)' at line 2",
  "data": null
 }
```