import {withStyles} from "@material-ui/core/styles/index";
import React from 'react';
import Button from '@material-ui/core/Button';
import AddIcon from '@material-ui/icons/Add';
import green from '@material-ui/core/colors/green';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';

const styles = theme => ({
  fab: {
    position: 'absolute',
    bottom: theme.spacing.unit * 2,
    right: theme.spacing.unit * 2,
  },
  fabGreen: {
    color: theme.palette.common.white,
    backgroundColor: green[500],
  },
});

class TodoAdd extends React.Component {
  state = {
    open: false,
    body: '',
  };

  handleOpenAdd = () => {
    this.setState({open: true});
  };

  handleClose = () => {
    this.setState({open: false});
  };

  onChange(event) {
    console.log('onChange');
    this.setState({body: event.target.value})
  }

  onSubmit (event) {
    console.log('onSubmit');

    event.preventDefault(); //kam?
    this.props.store.addTodoItem({ content: this.state.body })
  }

  render() {
    const classes = this.props.classes;

    return (
      <div>
        <Button onClick={this.handleOpenAdd} variant="fab" className={classes.fab} color="primary">
          <AddIcon/>
        </Button>
        <Dialog
          open={this.state.open}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title">Add Todo</DialogTitle>
          <form onSubmit={this.onSubmit.bind(this)}>
            <DialogContent>
              <TextField
                autoFocus
                margin="dense"
                id="todoItem"
                label="Todo Item"
                fullWidth
                onChange={this.onChange.bind(this)}
              />
            </DialogContent>
            <DialogActions>
              <Button onClick={this.handleClose} color="primary">
                Cancel
              </Button>
              <Button onClick={this.handleClose} color="primary" type="submit">
                Add
              </Button>
            </DialogActions>
          </form>
        </Dialog>
      </div>
    )
  }
}

export default withStyles(styles)(TodoAdd);