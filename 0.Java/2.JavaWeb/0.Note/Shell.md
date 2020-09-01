#Shell

+ 新建一个脚本文件
    ```
    touch a.sh // 新建文件
    chmod 777 a.sh // 更改执行权限
    ./a.sh // 第一种执行方式
    bash a.sh // 第二种执行方式
    ```

+ 注释
    ```
    #/bin/bash // 指定bash版本
    # 单行注释
    :<<!
    多行注释
    !   
    ```

+ 变量
    ```
    #定义变量
    number=1
    a='a' // 单引号内的内容原样输出
    b="$number" // 双引号内的内容调用变量后拼接使用

    #定义命令变量
    d=`date`
    d=$(date)

    #使用变量
    ${variable}
    "${variable}"

    #只读变量
    readonly variable

    #删除变量
    unset variable
    ```

+ 数组
    ```
    #!/bin/bash
    #数组练习
    #定义一个数组
    arr=(a b c d e f)
    #赋值
    arr[0]=A
    #调用数组元素
    echo ${arr[0]}
    echo ${arr[1]}
    #数组长度
    echo "The length of arr is ${#arr[*]}"
    echo "The length of arr is ${#arr[@]}"
    ```

+ 算术运算符
    ```
    #!/bin/bash
    #整数相加
    num1=`expr 2 + 2`
    echo "整数2+2=${num1}"

    #整数相乘
    num2=`expr 2 \* 2`
    echo "整数2*2=${num2}"

    #变量相加
    a=10
    b=10
    c=`expr $a + $b`
    echo "变量a+b=${c}"

    #赋值
    d=10
    e=$d
    echo "变量赋值${e}"

    #自增
    f=1
    ((f++))
    echo "变量f自增${f}"
    ```

+ 字符串判断
    ```
    #!/bin/bash
    #判断两个字符串是否相等
    #0为真 1为假 $?取上一次计算的值
    a="aaa"
    b="bbb"
    [ "${a}" = "${b}" ]
    echo "字符串a和b是否相等 $?"

    [ "${a}" != "${b}" ]
    echo "字符串a和b是否不相等 $?"

    [ -z "${a}" ]
    echo "字符串a的长度是否为0 $?"

    [ -n "${a}" ]
    echo "字符串a的长度是否不为0 $?"

    [ $"{$a}" ]
    echo "字符串a是否非空 $?"
    ```

+ 关系运算符
    ```
    #!/bin/bash
    #判断两个数字之间的关系，可判断值为数字的字符串
    a=10
    b=1

    [ "${a}" -eq "${b}" ]
    echo "字符串a和b是否相等 $?"

    #-nq 不相等
    #-gt 大于
    #-lt 小于
    #-ge 大于等于
    #-le 小于等于
    ```

+ 布尔运算符
    ```
    #!/bin/bash
    #布尔运算符
    a=10
    b=20

    [ ! "${a}" -eq "${b}" ]
    echo "a=b?取反 $?"

    #或 -o
    [ "${a}" -lt 20 -o "${b}" -gt 100 ]
    echo "a < 20 or b >100 $?"

    #且 -a
    [ "${a}" -lt 20 -a "${b}" -gt 100 ]
    echo "a < 20 and b > 100 $?"
    ```

+ 逻辑运算符
    ```
    #!/bin/bash
    #逻辑运算符

    a=10
    b=20

    # &&
    [[ "${a}" -lt 100 && "${b}" -gt 100 ]]
    echo "a < 100 && b >100 $?"

    # ||
    [[ "${a}" -lt 100 || "${b}" -gt 100 ]]
    echo "a < 100 || b >100 $?"
    ```

+ if语句
    ```
    #!/bin/bash
    #if条件判断
    #判断a和b的大小关系

    a=10
    b=20
    if [ "${a}" -lt "${b}" ]
    then
            echo " a < b "
    elif [ "${a}" -eq "${b}" ]
    then
            echo " a = b "
    else
            echo " a > b "
    fi
    ```

+ case语句
    ```
    #!/bin/bash
    #选择语句
    v="1"
    case "${v}" in
    "0")
            echo "0"
            ;;
    "1")
            echo "1"
            ;;
    esac
    ```

+ for循环
    ```
    #!/bin/bash
    #for循环

    for var in A B C D E
    do
            echo "${var}"
    done
    ```

+ while循环
    ```
    #!/bin/bash
    #for循环

    for var in A B C D E
    do
            echo "${var}"
    done
    ```

+ 函数
    ```
    #!/bin/bash
    #键盘录入两个数，相加后打印

    method(){
            echo "请输入第一个数字："
            read number1

            echo "请输入第二个数字："
            read number2

            echo "两个数字分别是 ${number1} ${number2}"
            return $((number1 + number2))
    }

    method
    echo "$?"
    ```