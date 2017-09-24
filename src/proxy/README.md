# 代理模式

给某一个对象提供一个代理，并由代理对象控制对原对象的引用。

代理模式的优点

- 代理模式能够协调调用者和被调用者，降低了系统的耦合度。
- 虚拟代理通过使用一个小对象来代表一个大对象，如果需要创建一个资源消耗较大的对象，先创建一个消耗相对较小的对象来表示，
真实对象只在需要时才会被真正创建。。
- 保护代理可以控制对真实对象的使用权限。

代理模式的缺点

- 由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
- 实现代理模式需要额外的工作，有些代理模式的实现非常复杂。