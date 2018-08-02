import {observer, inject} from 'mobx-react';
import React from 'react';
import {withStyles} from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import TodoItem from "./TodoItem";
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TodoAdd from "./TodoAdd";

const styles = theme => ({
  root: {
    width: '100%',
    backgroundColor: theme.palette.background.paper,
  },
  title: {
    margin: `${theme.spacing.unit * 8}px 0 ${theme.spacing.unit * 2}px`,
  },
});

@inject("rootStore")
@observer
class TodoList extends React.Component {

  constructor (props) {
    super(props);

    this.todoStore = props.rootStore.todoStore;
    this.uiStore = props.rootStore.uiStore;
    this.onArchiveTodoItem = this.onArchiveTodoItem.bind(this);
  }

  onArchiveTodoItem(todoItem) {
    this.todoStore.archiveTodoItem(todoItem);
  }

  componentDidMount () {
    this.todoStore.fetchData(this.props.location.search);
  }

  componentWillReceiveProps () {
    this.todoStore.fetchData(this.props.location.search);
  }

  render() {
    const classes = this.props.classes;
    const todoItems = this.todoStore.todoItems.map((todoItem) =>
      <TodoItem onArchiveStateChange={this.onArchiveTodoItem} key={todoItem.id} todoItem={todoItem} />
    );
    return (
      <Grid item xs={12} md={12}>
        <Typography variant="title" className={classes.title}>
          Todo
        </Typography>
        <div className={classes.root}>
          <List component="nav">
            {todoItems}
          </List>
          <TodoAdd store={this.todoStore} />
        </div>
      </Grid>
    );
  }
}

export default withStyles(styles)(TodoList);