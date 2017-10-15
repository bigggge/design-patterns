// 这种在运行时，动态地将代码切入到类的指定方法、指定位置上的编程思想就是面向切面的编程。

var before = function (fn, beforefn) {
    return function () {
        beforefn.apply(this, arguments);
        fn.apply(this, arguments);
    }
};

var a = before(
    function () {
        console.log(3)
    },
    function () {
        console.log(2)
    }
);

a = before(a, function () {
    console.log(1);
});

a();