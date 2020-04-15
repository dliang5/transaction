import React from 'react';

class TransactionLogin extends React.Component {
    render() {
        return (
            <React.Fragment>
                <div>
                    <div className="jumbotron">
                        <h1 className="display-4">Login</h1>
                        <hr className="my-4"/>
                        <p className="lead">
                            <a className="btn btn-primary btn-lg" href="#" role="button">
                                Learn More
                            </a>
                        </p>
                    </div>
                </div>

                <form method="post" action="/login">
                    <fieldset style={{margin: "10px"}}>
                        <p>
                            <label htmlFor="username">Username:</label>
                            <input id="username" type="text" name="username"  />
                        </p>
                        <p>
                            <label htmlFor="password">Password:</label>
                            <input id="password" type="password" name="password"  />
                        </p>
                        <button type="submit" className="button--sm">Login</button>
                    </fieldset>
                </form>
            </React.Fragment>
        );
    }
}

export default TransactionLogin;
