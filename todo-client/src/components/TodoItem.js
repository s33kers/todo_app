import React from 'react';
import {observer} from 'mobx-react';
import {withStyles} from '@material-ui/core/styles';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import ListItemSecondaryAction from '@material-ui/core/ListItemSecondaryAction';
import IconButton from '@material-ui/core/IconButton';
import ArchiveIcon from '@material-ui/icons/Archive';
import UnarchiveIcon from '@material-ui/icons/Unarchive';

const styles = theme => ({
  root: {
    width: '100%',
    backgroundColor: theme.palette.background.paper,
  },
});

@observer
class TodoItem extends React.Component {

  constructor(props) {
    super(props);

    this.handleArchive = this.handleArchive.bind(this);
  }

  handleArchive() {
    this.props.onArchiveStateChange(this.props.todoItem);
  }

  render() {
    const classes = this.props.classes;
    const todoItem = this.props.todoItem;
    const createDate = new Intl.DateTimeFormat('lt-LT', {
      year: 'numeric', month: 'numeric', day: 'numeric',
      hour: 'numeric', minute: 'numeric', second: 'numeric',
      hour12: false,
    }).format(new Date(todoItem.created));
    let archiveIcon;
    if (todoItem.archived) {
      archiveIcon = <ArchiveIcon/>
    } else {
      archiveIcon = <UnarchiveIcon/>
    }

    return (
      <ListItem>
        <ListItemText primary={todoItem.content + " " + createDate}/>
        <ListItemSecondaryAction>
          <IconButton aria-label="Archive" onClick={this.handleArchive}>
            {archiveIcon}
          </IconButton>
        </ListItemSecondaryAction>
      </ListItem>
    );
  }
}

export default withStyles(styles)(TodoItem);