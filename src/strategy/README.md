# 策略模式

定义一组算法，将每个算法都封装起来，并且使他们之间可以互换。

```javascript
    var S = function (salary) {
        return salary * 4
    }

    var A = function (salary) {
        return salary * 3
    }

    var B = function (salary) {
        return salary * 2
    }

    var calculateBonus2 = function (func, salary) {
        return func(salary);
    };

    console.log(calculateBonus2(S, 2000)); // 8000
    console.log(calculateBonus2(A, 2000)); // 6000
```

策略模式的主要优点有：

- 策略类之间可以自由切换，由于策略类实现自同一个抽象，所以他们之间可以自由切换。
- 易于扩展，增加一个新的策略对策略模式来说非常容易。
- 使用策略模式可以避免使用多重条件转移语句。

策略模式的缺点主要有两个：

- 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
- 策略模式将造成产生很多策略类，可以通过使用享元模式在一定程度上减少对象的数量。
