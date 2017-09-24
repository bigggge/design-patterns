# 命令模式

将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销的操作。

和 Java 不同，JavaScript 不需要将方法封装到Command对象中，函数可以被传递，使用高阶函数也可以方便地实现命令模式。

```javascript
    // 创建命令
    function makeCommand(receiver, state) { 
        return function () {
            receiver[state]();
        }
    }
```
    