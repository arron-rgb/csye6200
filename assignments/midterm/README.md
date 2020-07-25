# 提供的类
1. AbstractTask
2. AbstractTaskFactory
3. AbstractTimeSheet
4. AbstractTimeSheetFactory

## 类的作用
1. Task和TimeSheet两个抽象类显然属于POJO，所以只需要写两个类分别继承这两个抽象类即可
2. TaskFactory和TimeSheetFactory两个工厂分别需要实现获取默认对象和解析csv格式的字符串获取对象的方法
3. TimeSheet从类名和提供的注释可以得知，Sheet的作用为汇总Task。并且通过参数名taskName可以猜想，需要通过taskName去索引到Task，也就需要在TimeSheet中定义一个Map，在Map中维护所有的Task

## 需要写的代码
1. 两个抽象基类的实体类
2. 两个抽象工厂的具体工厂类，并能够解析csv字符串来构造对象
3. TimeSheet中的add/ remove/ clear/ show等方法
4. Drive中的demo测试方法

### 涉及到的知识点
1. 继承
2. 工厂模式
3. String的split方法
4. Map的put/ remove及遍历方法
5. int类型私有变量的更新
