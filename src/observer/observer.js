!function () {

    var events = (function () {
        var topics = {};

        return {
            publish: function (topic, info) {
                console.log('publish a topic:' + topic);
                if (topics.hasOwnProperty(topic)) {
                    topics[topic].forEach(function (handler) {
                        handler(info ? info : {});
                    })
                }
            },
            subscribe: function (topic, handler) {
                console.log('subscribe a topic:' + topic);
                if (!topics.hasOwnProperty(topic)) {
                    topics[topic] = [];
                }

                topics[topic].push(handler);
            },
            remove: function (topic, handler) {
                if (!topics.hasOwnProperty(topic)) {
                    return;
                }

                var handlerIndex = -1;
                topics[topic].forEach(function (element, index) {
                    if (element === handler) {
                        handlerIndex = index;
                    }
                });

                if (handlerIndex >= 0) {
                    // 从第 handlerIndex 位开始删除 1 个元素
                    console.log('remove the index' + handlerIndex + ' handler on the topic:' + topic);
                    topics[topic].splice(handlerIndex, 1);
                }
            },
            removeAll: function (topic) {
                console.log('remove all the handler on the topic:' + topic);
                if (topics.hasOwnProperty(topic)) {
                    topics[topic].length = 0;
                }
            }
        }
    })();

    // 主题监听函数
    var cache = {};

    function handler(name) {
        if (!cache[name]) {
            cache[name] = function (info) {
                console.log("Hi， " + name + ' ' + info + " 做好啦！");
            };
        }
        return cache[name]
    }

    // 订阅milk主题
    events.subscribe('milk', handler('道格拉斯'));
    events.subscribe('milk', handler('图灵'));
    events.subscribe('milk', handler('牛顿'));
    events.remove('milk', handler('道格拉斯'));

    // 发布milk主题
    events.publish('milk', '草莓味的牛奶');
}();
