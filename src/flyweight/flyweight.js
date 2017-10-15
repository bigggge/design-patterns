// 性别是内部状态，存储于对象内部，可共享，通常不会改变。内衣是外部状态，不能共享，取决于具体的场景。

var Model = function (sex) {
    this.sex = sex;
};
Model.prototype.takePhoto = function () {
    console.log('sex= ' + this.sex + ' underwear=' + this.underwear);
};

var maleModel = new Model('male'),
    femaleModel = new Model('female');

for (var i = 1; i <= 50; i++) {
    maleModel.underwear = 'underwear' + i;
    maleModel.takePhoto();
}

for (var j = 1; j <= 50; j++) {
    femaleModel.underwear = 'underwear' + j;
    femaleModel.takePhoto();
}