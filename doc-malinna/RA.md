#小学四则运算软件需求文档
##一.目的
###本次软件项目开发的是一个小学生四则运算测试系统。使用此系统的小学生通过此系统进行小学生四则运算的练习。而教师和家长可以通过本系统查看学生的练习情况以更好的了解孩子的学习状况。
##二.用例
    |   用户   |    用例名    |                       用例描述                                                         |
    |         |    注册      |用户根据自己的学号，点击“注册”按钮注册帐号，用于之后系统使用的凭证。不得与已有帐号相同。  |
    |   学生   |    登录      |用户使用以及注册的帐号和注册时的密码登录系统，才能使用系统的其他功能。                      |
    |         |    进行练习  |用户成功登录后选择测试的难度，点击“开始”，进行测试，测试开始时将有倒计时，未在时间范围内完成测试的自动提交 。|
    |         |    统计信息  |用户登录后可以查询自己的测试记录，包括得分 。                                    |



    |   用户   |    用例名      |                       用例描述                                                           |
    |   家长   |    注册        |用户根据自己的手机号，点击“注册”按钮注册帐号，用于之后系统使用的凭证。不得与已有帐号相同。  |
    |   教师   |    登录        |用户使用以及注册的帐号和注册时的密码登录系统，才能使用系统的其他功能。                        |
    |         |    查询信息    |用户登录后可以查询自己关心的对象的的测试记录，包括得分，使用时间等。还可以知道学生几次测试的平均成绩老师还可以知道全班的平均分|
##三.功能需求
###我们将本次开发的功能需求分为三个层次
###1.四则运算（最核心）
####需要能够生成符合各个不同水平小学生需求的四则运算。我们将测试的难度分为五个等级：
####（1）等级一：为只接触过简单加减乘除的小学生做练习。
####样例：A  +/-  B = C
####运算式只包含一个操作符的简单加减运算。A，B，C均为不超过100的自然数。
####（2）等级二：为接触过加减乘除以其混合运算的小学生做练习。
####样例：A + B * C - D = F
####运算式包含不超过3个操作符（加减乘除），且不含括号。A，B，C，D，F及运算过程中不出现负数或分数。
####（3）等级三：为接触加减乘除，括号及其混合运算的小学生做练习。
####样例：A + B *(C / D) = F
####运算式包含不超过3个操作符（加减乘除），运算式中含有括号。A，B，C，D，F及运算过程中不出现负数或分数。
####（4）等级四：为接触了分数概念的小学生做练习。
####样例：A + (B * C) - (D / F) = E
####运算式包括不超过4个操作符（加减乘除），运算式中含有括号。A，B，C，D，F，E及运算过程中可以出现真分数，但是不能出现负数。
####（5）等级五：综合测试
####包含上述所有的题目类型测试。
###2.界面
####为了软件能够更好被使用合理美观的界面是必要的。
####（1）登陆界面
####包括登录和注册两个功能，针对学生或者家长及老师两类用户，需要有不同的权限。登录界面主要有用户名和密码的输入框，点击注册按钮，跳出注册框，注册框包括用户名和密码。点击登陆后调转到菜单界面。
####（2）菜单界面
####针对两类用户有不同的菜单栏：学生包括开始练习，回顾历史成绩，退出登录，统计成绩。家长和教师主要是回顾历史成绩，统计成绩，退出登陆。
####（3）难度选择界面
####学生点击开始练习后跳转到难度选择界面，界面主要内容是五个等级。
####（4）练习界面
####学生在难度选择界面选择任意等级后跳转到练习界面，界面主要内容为20道练习题，倒计时工具，以及提交按钮。
####（5）测试结果界面
####学生提交完测试后，跳转到测试结果界面，主要为练习题的对错以及错误题的正确答案，以及正确率。
####（6）回顾历史成绩界面
####学生及其家长的回顾界面相同，主要是历史测试的正确率以及答题时间。
####教师的回顾界面为其学生们的历史测试结果。
####（7）统计界面
####用折线图展示学生成绩的变化曲线和波动情况，用饼状图展示学生成绩在全部用户中处在哪个位置。
###3.统计
####为了让家长和老师能快速的了解学生的练习情况，本软件需要有统计功能，可以看到学生的成绩变化和波动情况，以及在整体中的排名水平。
####（1）折线图
####折线图分为三种：
####第一种：以学生的测试次数为横轴，以测试所得分数为纵轴。最细节的展示学生每一次成绩的变化。
####第二种：在折线图上方有4个下拉菜单，分别为：第一次使用本软件测试的时间；最近一次使用本软件的时间；你所选择的测试难度；你希望以多少天为单位取一次平均数。折线图的横轴以你所选的多少天取一次平局数做单位，纵轴为你最小单位的平局数。（例如：你在2016年8月1日开始使用本软件，到2016年10月10日最近一次使用。所选择难度为2级，你希望每4天取一次平均值。你折现统计图的横坐标为18个值[（31+31+10）/4]纵坐标为各四天的测试次数的平均值。）该折线图很好的展现了学生一段较长时间内的成绩变化。 
####第三种 ：将第二种的纵坐标由平均值换成方差，次折线图可以看出学生成绩的波动性。
####（2）饼状图
####饼状图有三个下拉菜单，开始时间和结束时间，以及难度等级。饼状图统计符合上述条件的所有用户的平均成绩，将其划分为5块：0-60；61-70；71-80；81-90；91-100。展示各个分块的百分比。用户可以用自己的平局分去对照，看自己大概在那个层次。
####（3）加权统计
####将用户做过所有等级难度的每个难度的平局分按照（等级一：5%，等级二：10%，等级三：20%，等级四：25%，等级五：30%）加权算出加权平均分，最后统计出在所有用户中的排名百分比。来展示你的综合水平在所有用户中的排名。

