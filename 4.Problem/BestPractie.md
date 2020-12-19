#### 1.nignx 服务启动与关闭

+ 管理员命令

+ 启动：

  + start nignx.exe

  + 重启 nignx.exe -s reload

+ 关闭：nignx.exe -s stop | quit

+ 强行关闭
  + netstat -ano 查看监控端口 PID
  + tasklist|findstr "PID" 找到进程
  + taskkill /f /t /im nginx.exe 关闭

#### 2.MyBatis 时间查询

```xml
where
<if test="null != start">
    and tu.created &gt;= #{start, jdbcType=TIMESTAMP}
</if>
<if test="null != end">
    and tu.created &lt;= #{end, jdbcType=TIMESTAMP}
</if>
```

