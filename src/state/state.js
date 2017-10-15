// 模拟切换空调模式

const auto = function () {
    console.log("自动");
};
const hot = function () {
    console.log("制热");
};
const cold = function () {
    console.log("制冷");
};

function* models() {
    for (let i = 0, fn, len = arguments.length; fn = arguments[i++];) {
        yield fn();
        if (i === len) {
            i = 0;
        }
    }
}

const exe = models(auto, hot, cold);
let count = 0;
const MAX = 5;

const timer = setInterval(() => {
    count++;
    exe.next();

    if (count >= MAX) {
        return clearInterval(timer)
    }
}, 500);

