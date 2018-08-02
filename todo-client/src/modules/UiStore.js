import {action, observable} from 'mobx';


class UiStore {
  @observable showArchived = false;

  @action
  toggleState(newState) {
    this.showArchived = newState;
  }
}

export default UiStore;