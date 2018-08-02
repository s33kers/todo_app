import TodoStore from "./TodoStore";
import UiStore from "./UiStore";

class RootStore {
  constructor() {
    this.todoStore = new TodoStore();
    this.uiStore = new UiStore();
  }
}

export default RootStore;