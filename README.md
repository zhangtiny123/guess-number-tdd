# Guess Number

## task 1
* GuessNumber类有一个答案“1234”。

1. 当猜测数字输入是“1234”的时候，返回“4A0B”
2. 当猜测数字输入是“4321”的时候，返回“0A4B”
3. 当猜测数字输入是“1324”的时候，返回“2A2B”
4. 当猜测数字输入是“5678”的时候，返回“0A0B”

## task 2
* TargetGenerator类能产生一个四位数字的字符串

1. 产生的四位数字结果，必须长度为4
2. 产生的四位数字结果，必须每一位都与其它位不重复
3. 产生的四位数字结果，必须每一位都是数字字符
4. 产生的四位数字结果，产生多次所得结果不都相同

## task 3
* 当GuessNumber类构造好的时候就已经生成了targetNumber

1. 使GuessNumber依赖于TargetGenerator
2. 实例化一个GuessNumber类就有了targetNumber

## task 4
* Game类能执行一次猜测的判断和处理，target依然是“1234”

1. 当猜测数字输入是“1234”的时候，打印信息“Congratulations!”
1. 当猜测数字输入是“4321”的时候，打印“0A4B”
1. 当猜测数字输入是“1324”的时候，打印“2A2B”
1. 当猜测数字输入是“5678”的时候，打印“4A0B”

## task 5
* Runner类可以执行游戏在console运行的整个逻辑
* 依赖于Game类，因此需要playWith方法返回猜测结果信息

测试用例（正确答案是"1234"）
1. 游戏开始，输入"1234",验证依次打印
"Please input your guessing(6):",
"congratulations!"

2. 游戏开始，依次输入"1567","3476","1234",验证依次打印
"Please input your guessing(6):",
"1A0B\nPlease input your guessing(5):",
"0A2B\nPlease input your guessing(4):",
"congratulations!"

3. 游戏开始，依次输入"1567","3476","2316","7834","2456","5234",验证依次打印
"Please input your guessing(6):",
"1A0B\nPlease input your guessing(5):",
"0A2B\nPlease input your guessing(4):",
"0A3B\nPlease input your guessing(3):",
"2A0B\nPlease input your guessing(2):",
"0A2B\nPlease input your guessing(1):",
"3A0B\nGame over~"

## task 6
* GameRunner类在控制台运行猜数字的游戏