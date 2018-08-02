import {observable, action, computed, runInAction} from 'mobx';

const client = require('./client');

class TodoStore {
  @observable todoItems = [];
  @observable isLoading = false;

  async fetchData(filter) {
    this.isLoading = true;
    filter = filter || '?archived=false';
    console.log(filter);
    fetch('http://localhost:8080/todo' + filter)
      .then(response => response.json())
      .then(response => {
        runInAction(() => {
          this.setItems(response);
          this.isLoading = false;
        });
      });
  }

  @action
  setItems(items) {
    this.todoItems = items;
  }

  @action
  addTodoItem(todoItem) {
    this.isLoading = true;
    client({
      method: 'POST',
      path: 'http://localhost:8080/todo/',
      headers: {'Content-Type': 'application/json'},
      entity: todoItem
    })
      .then(response => {
        runInAction(() => {
          let reponse = response.entity;
          if (this.todoItems != null && this.todoItems[0].archived == reponse.archived) {
            this.todoItems.unshift(reponse);
          }
          this.isLoading = false;
        });
      });
  }

  @action
  archiveTodoItem(todoItem) {
    this.isLoading = true;
    client({
      method: 'PUT',
      path: 'http://localhost:8080/todo/' + todoItem.id,
      headers: {'Content-Type': 'application/json'},
      entity: {archived: !todoItem.archived,
               content: todoItem.content}
    })
      .then(response => {
        runInAction(() => {
          this.todoItems.remove(todoItem);
          this.isLoading = false;
        });
      });
  }
}

export default TodoStore;