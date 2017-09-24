function each(ary, callback) {
    for (var i = 0, len = ary.length; i < len; i++) {
        callback.call(ary[i], i, ary[i]);
    }
}

each([1, 2, 3], function (i, n) {
    console.log([i, n]);
});