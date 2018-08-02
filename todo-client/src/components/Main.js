import React from 'react';
import {withStyles} from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Divider from '@material-ui/core/Divider';
import Typography from '@material-ui/core/Typography';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import TodoList from './TodoList';
import {Link, Redirect, Route, Switch} from 'react-router-dom';
import {Provider} from 'mobx-react';
import RootStore from "../modules/RootStore";


const styles = theme => ({
  root: {
    flexGrow: 1,
    zIndex: 1,
    overflow: 'hidden',
    position: 'relative',
    display: 'flex',
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
  },
  drawerPaper: {
    position: 'relative',
    width: 240,
  },
  content: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing.unit * 3,
    minWidth: 0, // So the Typography noWrap works
  },
  toolbar: theme.mixins.toolbar,
});

class Main extends React.Component {

  constructor(props) {
    super(props);

    this.rootStore = new RootStore();
  }

  render() {
    const classes = this.props.classes;
    return (
      <Provider rootStore={this.rootStore}>
        <div className={classes.root}>
          <AppBar position="absolute" className={classes.appBar}>
            <Toolbar>
              <Typography variant="title" color="inherit" noWrap>
                Todo items
              </Typography>
            </Toolbar>
          </AppBar>
          <Drawer
            variant="permanent"
            classes={{
              paper: classes.drawerPaper,
            }}
          >
            <div className={classes.toolbar}/>
            <ListItem button component={Link} to="/todo">
              <ListItemText primary="Todo items"/>
            </ListItem>
            <Divider/>
            <ListItem button component={Link} to="/todo?archived=true">
              <ListItemText primary="Archived"/>
            </ListItem>
          </Drawer>
          <main className={classes.content}>
            <Switch>
              <Route path="/todo" component={TodoList}/>
              <Redirect from="/" to="/todo" />
            </Switch>
          </main>
        </div>
      </Provider>
    );
  }
}

export default withStyles(styles)(Main);
