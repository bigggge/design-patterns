!function () {
    var calculateBonus = function (performanceLevel, salary) {
        if (performanceLevel === 'S') {
            return salary * 4;
        }
        if (performanceLevel === 'A') {
            return salary * 3;
        }
        if (performanceLevel === 'B') {
            return salary * 2;
        }
    };

    console.log(calculateBonus('S', 2000)); // 8000
    console.log(calculateBonus('A', 2000)); // 6000

    // 使用策略模式重构
    var S = function (salary) {
        return salary * 4
    };

    var A = function (salary) {
        return salary * 3
    };

    var B = function (salary) {
        return salary * 2
    };

    var calculateBonus2 = function (func, salary) {
        return func(salary);
    };

    console.log(calculateBonus2(S, 2000)); // 8000
    console.log(calculateBonus2(A, 2000)); // 6000

}();

