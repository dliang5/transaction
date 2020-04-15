import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
import TransactionSummary from './transaction-summary-component.jsx';
import TransactionView from './transaction-view-component.jsx';
import TransactionInsert from './transaction-insert-component.jsx';
import TransactionLogin from './transaction-login-component.jsx';
class App extends React.Component {

    render(){
        return (
            <React.Fragment>
                <Router>
                    <div>
                        <nav className="navbar navbar-expand-lg navbar-light bg-light">
                            <div id="navbarNav"> 
                                <ul className="navbar-nav">
                                    <li className="nav-item">
                                        <Link className="nav-link"to="/">Transactions</Link>
                                    </li>
                                    <li className="nav-item">
                                        <Link className="nav-link" to="/summary">Summary</Link>
                                    </li>
                                    <li className="nav-item">
                                        <Link className="nav-link" to="/insert">Insert</Link>
                                    </li>
                                    <li className="nav-item">
                                        <Link className="nav-link" to="/login">Login</Link>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                        
                        <Switch>
                            <Route path="/summary">
                                <TransactionSummary />
                            </Route>
                            <Route path="/insert">
                                <TransactionInsert />
                            </Route>
                            <Route path="/login">
                                <TransactionLogin />
                            </Route>
                            <Route path="/">
                                <TransactionView />
                            </Route>
                        </Switch>
                    </div>
                </Router>
            </React.Fragment>
        );
    }
}

export default App;