!function () {

    var multi = function () {
        var a = 1;
        for (var i = 0, l = arguments.length; i < l; i++) {
            a = a * arguments[i];
        }
        return a;
    };

    var plus = function () {
        var a = 0;
        for (var i = 0, l = arguments.length; i < l; i++) {
            a = a + arguments[i];
        }
        return a;
    };

    // 缓存代理
    var createProxyFactory = function (fn) {
        var cache = {};
        return function () {
            var args = Array.prototype.join.call(arguments, ',');
            if (args in cache) {
                return cache[args];
            }
            return cache[args] = fn.apply(this, arguments);
        }
    };

    var proxyMulti = createProxyFactory(multi),
        proxyPlus = createProxyFactory(plus);
    console.log(proxyMulti(1, 2, 3)); // 6
    console.log(proxyMulti(1, 2, 3)); // 6
    console.log(proxyPlus(1, 2, 3)); // 6
    console.log(proxyPlus(1, 2, 3)); // 6

}();
