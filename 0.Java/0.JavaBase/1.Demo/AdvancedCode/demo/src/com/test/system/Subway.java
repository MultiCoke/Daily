package com.test.system;

public class Subway {
    private String no;
    private String name;
    private String line;

    public Subway() {
    }

    public Subway(String no, String name, String line) {
        this.no = no;
        this.name = name;
        this.line = line;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "地铁站编号：" + no + "，地铁站名称："
                + name + "，所属路线：" + line;
    }
}
