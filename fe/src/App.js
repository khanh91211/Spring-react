import React from 'react';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';
import Admin from './components/Admin';


function App() {
  return (
    <div>
    <Router>
      <Switch>
        <Route path="/" exact component={Admin} />
      </Switch>
    </Router>
    </div>
  );
}

export default App;
