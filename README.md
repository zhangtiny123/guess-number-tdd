# Guess Number

## Simple [requirement](/REQUIREMENT.md) about this project, please click the link.

## task 1
* 当Answer类有一个答案的时候，给它任意一组互不相同的四位数字，能够返回一个包含猜测正确与否的code。
* 假设Answer类有一个答案“1234”。

1. 当猜测数字输入是“1234”的时候，返回“4A0B”
2. 当猜测数字输入是“4321”的时候，返回“0A4B”
3. 当猜测数字输入是“1324”的时候，返回“2A2B”
4. 当猜测数字输入是“5678”的时候，返回“0A0B”

## task 2
* 由于Answer类的答案需要随机生成，因此需要一个AnswerGenerator类来负责提供一个随机不重复的四位数字作为答案。
* AnswerGenerator类能产生一个四位数字的字符串

1. 产生的四位数字结果，必须长度为4
2. 产生的四位数字结果，必须每一位都与其它位不重复
3. 产生的四位数字结果，必须每一位都是数字字符
4. 产生的四位数字结果，产生多次所得结果不都相同

## task 3
* 显然Answer类需要依赖于AnswerGenerator类，因此修改之前的Answer类和相应的测试。
* 当Answer类构造好的时候就已经生成了answer

1. 使Answer类依赖于AnswerGenerator
2. 实例化一个Answer类就有了answer

## task 4
* 因为游戏中可猜测的次数是不定的（这里是6次），每次都是根据输入猜测并得到结果来判断是否继续，所以Game类负责执行一个游戏单元将要有的行为。
* Game类能执行一次猜测的判断和处理，Answer依然是“1234”

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
* 需要一个runner类来调用游戏的执行
* GameRunner类在控制台运行猜数字的游戏