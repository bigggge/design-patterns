var Chain = function (fn) {
    this.fn = fn;
    this.successor = null;
};

Chain.prototype.setNextSuccessor = function (successor) {
    return this.successor = successor;
};

Chain.prototype.start = function () {
    return this.fn.apply(this, arguments);
};

Chain.prototype.next = function () {
    return this.successor && this.successor.fn.apply(this.successor, arguments)
};

var fn1 = new Chain(function () {
    console.log(1);
    this.next()
});

var fn2 = new Chain(function () {
    console.log(2);
    var self = this;
    setTimeout(function () {
        self.next()
    }, 1000)
});

var fn3 = new Chain(function () {
    console.log(3)
});

fn1.setNextSuccessor(fn2).setNextSuccessor(fn3);
fn1.start();