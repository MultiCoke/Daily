package com.itheima.exricse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo02 {
    /*
      现有两个队伍的人员，分别存入两个List集合中，如下所示：

      ```java
      // 队伍1
      ArrayList<String> team1 = new ArrayList<>();
      team1.add("陈玄风");
      team1.add("梅超风");
      team1.add("风清扬");
      team1.add("解风");
      team1.add("风波恶");
      team1.add("陆乘风");
      team1.add("曲灵风");
      team1.add("武眠风");
      team1.add("冯默风");
      team1.add("陆小风");
      // 队伍2
      ArrayList<String> team2 = new ArrayList<>();
      team2.add("宋远桥");
      team2.add("俞莲舟");
      team2.add("俞岱岩");
      team2.add("张松溪");
      team2.add("张翠山");
      team2.add("殷梨亭");
      team2.add("莫声谷");
      ```

      请使用流依次完成如下操作：

      1、从第一个队伍中筛选出名字为3个字并且以“风”字结尾的人，筛选之后，只保留前6个。

      2、从第二个队伍中筛选出姓张的人员，筛选之后，不要第一个。

      3、将两个筛选结果合并为一个队伍。

      4、打印结果队伍中的姓名信息

     */
    public static void main(String[] args) {
        // 队伍1
        ArrayList<String> team1 = new ArrayList<>();
        team1.add("陈玄风");
        team1.add("梅超风");
        team1.add("风清扬");
        team1.add("解风");
        team1.add("风波恶");
        team1.add("陆乘风");
        team1.add("曲灵风");
        team1.add("武眠风");
        team1.add("冯默风");
        team1.add("陆小风");
        // 队伍2
        ArrayList<String> team2 = new ArrayList<>();
        team2.add("宋远桥");
        team2.add("俞莲舟");
        team2.add("俞岱岩");
        team2.add("张松溪");
        team2.add("张翠山");
        team2.add("殷梨亭");
        team2.add("莫声谷");

        // 1、从第一个队伍中筛选出名字为3个字并且以“风”字结尾的人，筛选之后，只保留前6个。
        team1.stream().filter(s -> s.length() == 3).filter(s -> s.endsWith("风")).limit(6).forEach(System.out::println);

        // 2、从第二个队伍中筛选出姓张的人员，筛选之后，不要第一个。
        team2.stream().filter(s -> s.startsWith("张")).skip(1).forEach(System.out::println);

        // 3、将两个筛选结果合并为一个队伍。
        List<String> team = Stream.concat(team1.stream(), team2.stream()).collect(Collectors.toList());
        System.out.println(team);
    }
}
