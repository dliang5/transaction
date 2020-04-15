import React from 'react';

class TransactionInsert extends React.Component {

    render() {
        return(
            <React.Fragment>
                <div>
                    <div className="jumbotron">
                        <h1 className="display-4">Transaction Insert</h1>
                        <hr className="my-4"/>
                        <p className="lead">
                            <a className="btn btn-primary btn-lg" href="#" role="button">
                                Learn More
                            </a>
                        </p>
                    </div>
                </div>
                <form method="post" action="/insert">
                    <fieldset style={{margin: "10px"}}>
                        <p>
                            <label htmlFor="transactionAmount">Amount:</label>
                            <input id="transactionAmount" type="number" name="transactionAmount"  />
                        </p>
                        <button type="submit" className="button--sm">Login</button>
                    </fieldset>
                </form>
            </React.Fragment>
        );
    }
}

export default TransactionInsert;