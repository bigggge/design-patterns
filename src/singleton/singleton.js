!function () {
    var Singleton = function (name) {
        this.name = name;
        this.instance = null;
    };

    Singleton.getInstance = function (name) {
        if (!this.instance) {
            this.instance = new Singleton(name);
        }
        return this.instance;
    };

    var a = Singleton.getInstance('name1');
    var b = Singleton.getInstance('name2');
    console.log(a === b); // true
    console.log(a.name); // name1
    console.log(b.name); //name1

}();
