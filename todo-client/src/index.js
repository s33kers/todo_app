import React from 'react';
import {render} from "react-dom";
import Main from './components/Main';
import { BrowserRouter } from 'react-router-dom'
import registerServiceWorker from './modules/registerServiceWorker';

render(
  <div>
    <BrowserRouter>
      <Main/>
    </BrowserRouter>
  </div>,
  document.getElementById('root')
);
registerServiceWorker();
