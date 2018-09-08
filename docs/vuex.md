### vuex 总结：
Vuex 是一个专为 Vue.js 应用程序开发的状态管理模式

##### 核心概念

- 1. State: 状态

- 2. Getter: 计算属性（是 store 的计算属性）
  - state 作为其第一个参数,也可以接受其他 getter 作为第二个参数
  ```
  getters: {
  // ...
  doneTodosCount: (state, getters) => {
    return getters.doneTodos.length
  }
  }
  ```
  - mapGetters 辅助函数: mapGetters 辅助函数仅仅是将 store 中的 getter 映射到局部计算属性

- 3. Mutation
  更改 Vuex 的 store 中的状态的唯一方法是提交 mutation
  - 你可以向 store.commit 传入额外的参数，即 mutation 的 载荷（payload）
  ```
  mutations: {
  increment (state, n) {
    state.count += n
  }
}
  ```
  - 你不能直接调用一个 mutation handler。这个选项更像是事件注册：“当触发一个类型为 increment 的 mutation 时，调用此函数。”要唤醒一个 mutation handler，你需要以相应的 type 调用 store.commit 方法：
  ```
store.commit('increment')
  ```
  - Mutation 必须是同步函数
  - mapMutations: 在组件中提交 Mutation

- 4. Action
Action 类似于 mutation，不同在于：
Action 提交的是 mutation，而不是直接变更状态。Action 可以包含任意异步操作。

  - 分发 Action: Action 通过 store.dispatch 方法触发

- 5.Module

